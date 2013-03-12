package com.arudenko.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import com.arudenko.AndroidSimpleDataBinding.BindingArrayAdapter;
import com.arudenko.AndroidSimpleDataBinding.R;
import com.arudenko.example.models.MItem;

import java.util.ArrayList;

public class StartActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        ListView lv = (ListView) findViewById(R.id.mylist);


        ArrayList<Object> values = new ArrayList<Object>();

        values.add(new MItem("Name1", "Value1"));
        values.add(new MItem("Name2", "Value2"));

        BindingArrayAdapter adapter = new BindingArrayAdapter(this, values);
        lv.setAdapter(adapter);
    }
}
