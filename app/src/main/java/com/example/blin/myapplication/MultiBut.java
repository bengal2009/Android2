package com.example.blin.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Field;


public class MultiBut extends ActionBarActivity {
    private TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_but);
        Button button = (Button)findViewById(R.id.button7);
        Button buttontest = (Button)findViewById(R.id.button8);
        this.textview = (TextView)findViewById(R.id.textView4);
        button.setOnClickListener(new Button_Listener(this));
        buttontest.setOnClickListener(new Button_Listener(this));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_multi_but, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public TextView getTextview() {
        return this.textview;
    }
}
class Button_Listener implements View.OnClickListener {
    private MultiBut activity;


    public Button_Listener(MultiBut activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        TextView textview = activity.getTextview();
//        String name = getIDName(textview, R.id.class);
        textview.setText("你点击了Button" +v.getId());
        switch (v.getId())
        {
            case R.id.button7:
                textview.setText("你点击了Button7");
                break;
            case R.id.button8:
                textview.setText("你点击了Button8");
                break;
        }
    }
    public static String getIDName(View view, Class<?> clazz)  {
        try {
            Integer id = view.getId();
            Field[] ids = clazz.getFields();
            for (int i = 0; i < ids.length; i++) {
                Object val = ids[i].get(null);
                if (val != null && val instanceof Integer
                        && ((Integer) val).intValue() == id.intValue()) {
                    return ids[i].getName();
                }
            }


        }
        catch (Exception Er)
        {

        }
        return "";
    }
}


