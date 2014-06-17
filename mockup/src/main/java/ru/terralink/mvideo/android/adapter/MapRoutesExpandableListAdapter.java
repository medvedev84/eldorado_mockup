package ru.terralink.mvideo.android.adapter;

/**
 * Класс-адаптер для работы с вложенным списком маршрутов на карте. Старшие элементы списка - строковые значения, вложенные элементы - маршруты.
 * В приложении старший список искусственно ограничен одним старшим элементом, который содержит строку "маршруты". Теоритически может содержать любое количество старших элементов.
 * @author Медведев Константин
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.terralink.mvideo.android.R;
import ru.terralink.mvideo.android.RoutesMapFragment;
import ru.terralink.mvideo.android.model.Route;

public class MapRoutesExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    // список маршрутов
    private List<String> routes;
    // множество строка-маршруты
    private Map<String, List<Route>> routesCollection;
    // ссылка на фрагмент, где используется данный адаптер
    private RoutesMapFragment mapFrgament;

    public MapRoutesExpandableListAdapter(Context context,
                                          List<String> routes,
                                          HashMap<String, List<Route>> routesCollection,
                                          RoutesMapFragment parent) {
        this.context = context;
        this.routes = routes;
        this.routesCollection = routesCollection;
        this.mapFrgament = parent;
    }

    @Override
    public int getGroupCount() {
        return this.routes.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.routesCollection.get(this.routes.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.routes.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.routesCollection.get(this.routes.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     *  Метод возвращает представление для старшего элемента списка.
     *  @param groupPosition номер старшего элемента в списке
     *  @param isExpanded признак - распахнут данный элемент или свернут
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // получаем разметку из файла list_row_group_map_string.xml
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row_group_map_string, null);
        }
        // выводим строку "маршруты"
        TextView txtRoute = (TextView) convertView.findViewById(R.id.route_label);
        txtRoute.setText(context.getResources().getString(R.string.routes));
        return convertView;
    }

    /**
     *  Метод возвращает представление для вложенного элемента списка.
     *  @param groupPosition номер старшего элемента в списке
     *  @param childPosition номер вложенного элемента списка
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // получаем объект маршруты по номеру выбранного старшего элемента и номеру вложенного элемента
        final Route route = (Route) getChild(groupPosition, childPosition);

        if (convertView == null) {
            // получаем разметку из файла list_row_details_map_route.xml
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row_details_map_route, null);
        }

        // формируем представление
        String headerTitle = route.getNumberReduced();
        String deadline = route.getStrStartDate() != null ? ", с " + route.getStrStartDate() + " до " + route.getStrEndDate() : "";

        TextView txtRoute = (TextView) convertView.findViewById(R.id.route_number);
        txtRoute.setText(headerTitle + deadline);

        // если данный маршрут равен текущему, то подсвечиваем этот элемент списка
        if (mapFrgament.getSelectedRoute() != null && route == mapFrgament.getSelectedRoute()) {
            mapFrgament.highlight(convertView);
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
