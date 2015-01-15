package com.example.blin.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class lstview extends ActionBarActivity {
    private ListView mainListView;
    private ArrayAdapter<String> listAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lstview);
        mainListView = (ListView) findViewById( R.id.mnlist);
//        ListView lv = getListView();
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0,
                                    View arg1, int position, long arg3)
            {
                System.out.println("LIST ITEM POSITION "+position);
//                Toast.makeText(mainListView, "你单击了" , Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Click! " + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(COUNTRIES) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planetList);
        mainListView.setAdapter( listAdapter );

    }
    static final String[] COUNTRIES = new String[] {
            "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24"
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lstview, menu);
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
}
