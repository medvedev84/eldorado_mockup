package ru.terralink.mvideo.android;

/**
 * Диалог смены статусов приложения
 * @author Медведев Константин
 */

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ru.terralink.mvideo.android.async.UpdateStatusAsyncTask;
import ru.terralink.mvideo.android.data.DataConnector;
import ru.terralink.mvideo.android.data.DataStorage;
import ru.terralink.mvideo.android.db.DatabaseHelper;
import ru.terralink.mvideo.android.model.Order;
import ru.terralink.mvideo.android.model.OrderStatus;

public class UpdateStatusDialog {

    // количество секунд в минуте
    private final static int MINUTE_DELAY = 60;
    // идентификатор выбранного статуса
    private static int selectedStatus = -1;
    // идентификатор выбранной задержки
    private static int selectedDelay = -1;

    private Context context;

    // массив объектов OrderStatus
    private OrderStatus status;
    // надпись для статуса заказа
    private TextView statusLabel;
    // надпись для комментария заказа
    private TextView commentLabel;
    // надпись для задержки заказа
    private TextView delayLabel;
    // строковый массив названий статусов задержки
    private String[] mDelays;
    // заказ, для которого показывается диалог
    private Order order;

    public UpdateStatusDialog(Context context, Order order, TextView statusLabel,  TextView delayLabel, TextView commentLabel){
        this.context = context;
        this.order = order;
        this.statusLabel = statusLabel;
        this.mDelays = context.getResources().getStringArray(R.array.dialog_select_delay_array);
        this.commentLabel = commentLabel;
        this.delayLabel = delayLabel;
    }

    /**
     * метод показа диалога выбора статуса
     */
    public void showSelectStatusDialog(){
        OrderStatus[] statusesTemp = new OrderStatus[]{};
        String[] mStatusesTemp = new String[] {};

        // бизнес логика отображения возможных статусов в зависимости от текущего
        switch (order.getStatus()) {
            case LOAD_END:
                statusesTemp = new OrderStatus[] {
                        OrderStatus.Z_DLV_PART,
                        OrderStatus.POD,
                        OrderStatus.Z_DELAY,
                        OrderStatus.Z_U_FM
                };
                mStatusesTemp = new String[] {"Доставлено частично", "Доставлено", "Задержка доставки", "Не доставлено"};
                break;
            case Z_DELAY:
                // если задержка более 4 часов, то статус "задержка" не доступен для выбора
                boolean isDelayAvailable = order.getDelay() < MINUTE_DELAY * 60 * 4;
                statusesTemp =
                        isDelayAvailable ?
                            new OrderStatus[] {
                                    OrderStatus.Z_DLV_PART,
                                    OrderStatus.POD,
                                    OrderStatus.Z_DELAY,
                                    OrderStatus.Z_U_FM
                            }:
                             new OrderStatus[] {
                                    OrderStatus.Z_DLV_PART,
                                    OrderStatus.POD,
                                    OrderStatus.Z_U_FM
                            };
                mStatusesTemp =
                        isDelayAvailable ?
                            new String[] {"Доставлено частично", "Доставлено", "Задержка доставки", "Не доставлено"}:
                            new String[] {"Доставлено частично", "Доставлено", "Не доставлено"};
                break;
            case POD:
                statusesTemp = new OrderStatus[] {};
                mStatusesTemp = new String[] {};
                break;
            case Z_DLV_PART:
                statusesTemp = new OrderStatus[] { OrderStatus.Z_RETURNS };
                mStatusesTemp = new String[] {"Возвращено"};
                break;
            case Z_U_FM:
                statusesTemp = new OrderStatus[] { OrderStatus.Z_RETURNS };
                mStatusesTemp = new String[] {"Возвращено"};
                break;
        }

        final OrderStatus[] statuses = statusesTemp;
        final String[] mStatuses = mStatusesTemp;

        int selected = -1;
        for(int i = 0; i< statuses.length; i++){
            // ищем текущий статус заказа
            if (order.getStatus() == statuses[i]) {
                selected = i;
                selectedStatus = selected;
                break;
            }
        }

        // если массив статусов, доступных для выбора, пуст, то значит для данного заказа статус сменить нельзя
        if (statuses.length == 0) {
            Toast.makeText(context, R.string.dialog_can_not_change_status, Toast.LENGTH_SHORT).show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.dialog_select_status_title);
        builder.setSingleChoiceItems(mStatuses, selected, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedStatus = which;
            }
        });
        // обработчик кнопки "ОК" диалога
        builder.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // если статус не выбран, то показываем соответствующее сообщение
                if (selectedStatus == -1) {
                    Toast.makeText(context, R.string.dialog_can_select_status, Toast.LENGTH_SHORT).show();
                    return;
                }

                status = statuses[selectedStatus];

                // бизнес логика показа дополнительных диалогов, в зависимости от выбранного статусы
                switch (status) {
                    case Z_DLV_PART:
                    case Z_U_FM:
                        // показываем диалог добавления комментария
                        showAddCommentDialog();
                        break;
                    case Z_DELAY:
                        // если заказ уже был в списке "просроченных", то берем величину задержки заказа из этого списка
                        int delay = DataStorage.getDelayedOrders().containsKey(order.getOrderNumber()) ?
                                DataStorage.getDelayedOrders().get(order.getOrderNumber()).getDelay(): 0;
                        // показываем диалог с выбором задержки
                        showSelectDelayDialog(delay);
                        break;
                    case POD:
                    case Z_RETURNS:
                        // показываем диалог подтверждения
                        showConfirmationDialog();
                    default:
                        break;
                }
            }
        });
        builder.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                statusLabel.setEnabled(true);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    /**
     * метод показа диалога подтверждения
     */
    private void showConfirmationDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.dialog_confirm_title);
        builder.setMessage(R.string.dialog_confirm_message);
        builder.setPositiveButton(R.string.dialog_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                order.setStatus(status);
                statusLabel.setText(status.getName());
                statusLabel.setTextColor(status.getColor());

                // удаляем диалог из списка "просроченных" (если он там был)
                DataStorage.getDelayedOrders().remove(order.getOrderNumber());

                // получаем класс-помощник работы с локальной БД
                DatabaseHelper db = new DatabaseHelper(context);

                if (status == OrderStatus.Z_DELAY) {
                    // для статуса "задержка" расссчитываем величину задержки
                    order.setDelay((selectedDelay + 1) * 15 * MINUTE_DELAY);
                    order.setStrDelay(mDelays[selectedDelay]);

                    // если заказ был в нашей БД, то обновляем его, если нет - создаем
                    if (db.isExists(order.getOrderNumber())) {
                        db.updateOrder(order);
                    } else {
                        db.createOrder(order);
                    }

                    // сохраняем заказ в списке "просроченных"
                    DataStorage.getDelayedOrders().put(order.getOrderNumber(), order);
                    // отображаем величину задержки на экране и меняем цвет надписи
                    delayLabel.setText(mDelays[selectedDelay]);
                    delayLabel.setTextColor(status.getColor());
                    selectedDelay = -1;
                } else {
                    // если статус заказа не "задержка", то хранить его в локальной БД не надо. Если он там есть - удаляем
                    if (db.isExists(order.getOrderNumber()))
                        db.deleteOrder(order);
                    delayLabel.setText("");
                }

                db.closeDB();

                if (!(status == OrderStatus.Z_DLV_PART || status == OrderStatus.Z_U_FM)) {
                    order.setComment(null);
                    if (commentLabel != null)
                        commentLabel.setText("");
                }

                // если у заказа есть комментарий - отображаем на экране
                if (order.getComment() != null & commentLabel != null) {
                    commentLabel.setText(order.getComment());
                }

                statusLabel.setEnabled(true);

                if (DataConnector.isOnline(context)) {
                    // если устройство подключено к сети интернет, то обновляем данные на сервере через синхронизацию
                    final ProgressDialog progressRoutes = new ProgressDialog(context);
                    progressRoutes.setMessage(context.getResources().getString(R.string.updating_status));
                    progressRoutes.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressRoutes.setCancelable(false);
                    progressRoutes.show();

                    // запускаем обновление в отдельном потоке
                    new UpdateStatusAsyncTask(context, order, true,
                            new  UpdateStatusAsyncTask.AsyncTaskCallBackListener(){
                                @Override
                                public void postExecute(Boolean param) {
                                    progressRoutes.dismiss();
                                    if (param) {
                                        Toast.makeText(context, R.string.updating_status_success, Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(context, R.string.updating_status_error, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                    ).execute();

                } else {
                    // если подключение отсутствует, то сохраняем данные локально и показываем диалог проверки настроек подключения
                    //DataConnector.updateStatus(order, false);
                    MainDrawerActivity.uncommitedChanges = true;
                    (new InternetSettingsDialog(context)).show();
                }
            }
        });
        builder.setNegativeButton(R.string.dialog_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                statusLabel.setEnabled(true);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    /**
     * метод показа диалога выбора задержки
     */
    private void showSelectDelayDialog(int delay){
        // рассчитываем, начиная с какой величины задержки надо строить список доступных задержок
        final int selected = (delay / MINUTE_DELAY / 15);
        int size = mDelays.length - selected;
        String[] delays = new String[size];
        System.arraycopy(mDelays, selected, delays, 0, size);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.dialog_select_delay_title);
        builder.setSingleChoiceItems(delays, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ((AlertDialog)dialog).getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(true);
                selectedDelay = which + selected;
            }
        });
        builder.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showConfirmationDialog();
            }
        });
        builder.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                statusLabel.setEnabled(true);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(false);
    }

    /**
     * метод показа диалога добавления комментария
     */
    private void showAddCommentDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.dialog_reject_title);
        builder.setTitle(R.string.dialog_reject_body);
        final EditText input = new EditText(context);
        builder.setView(input);

        builder.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // сохраняем комментарий в заказ и показываем диалог подтверждения
                order.setComment(input.getText().toString());
                showConfirmationDialog();
            }
        });
        builder.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                statusLabel.setEnabled(true);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
