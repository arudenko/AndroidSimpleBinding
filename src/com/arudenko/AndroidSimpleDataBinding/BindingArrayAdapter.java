package com.arudenko.AndroidSimpleDataBinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class BindingArrayAdapter extends ArrayAdapter<Object> {
    private final Context context;
    private final ArrayList<Object> values;
    private final int rowLayoutId;

    public BindingArrayAdapter(Context context, ArrayList<Object> values, int rowLayoutId) {
        super(context, R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
        this.rowLayoutId = rowLayoutId;
    }

    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(rowLayoutId, parent, false);
        Object item = values.get(position);

        Method[] methods = item.getClass().getMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                //Try to find element with same ID
                int id = getResId(method.getName().replace("get", "").toLowerCase(), R.id.class);
                TextView textView = (TextView) rowView.findViewById(id);
                if(textView != null){
                    try {
                        Object invoke = method.invoke(item, (Object[]) null);
                        textView.setText((String) invoke);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return rowView;
    }
}