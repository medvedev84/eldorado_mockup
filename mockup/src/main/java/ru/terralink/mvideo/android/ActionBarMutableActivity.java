package ru.terralink.mvideo.android;

/**
 * Родитель для всех activity приложения, где требуется изменять вид action bar'а.
 * @author Медведев Константин
 */

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

abstract public class ActionBarMutableActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customizeActionBar();
    }

    /**
     * Метод для изменения внешнего вида action bar'а.
     */
    public void customizeActionBar() {
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(getActionBarLayout(), null);
        actionBar.setCustomView(v);
    }

    /**
     * Абстрактный метод получения layout'а для action bar'а. Должен быть перегружен в классах-потомках
     */
    abstract protected int getActionBarLayout();
}
