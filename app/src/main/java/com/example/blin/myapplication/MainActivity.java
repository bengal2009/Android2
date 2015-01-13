package com.example.blin.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//http://www.oschina.net/question/54100_32486

//http://www.cnblogs.com/feisky/archive/2010/01/16/1649081.html
public class MainActivity extends ActionBarActivity {
    private EditText InputStr;
    protected void dialog() {
     AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
     builder.setMessage("确认退出吗？");
     builder.setTitle("提示");
     builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
       @Override
             public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
           MainActivity.this.finish();
               }
             });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                   }
            });
          builder.create().show();
         }
    void DispToast(String s1){
        Toast.makeText(getApplicationContext(), s1,
                Toast.LENGTH_SHORT).show();


    }
    void InputDialog() {
        InputStr = new EditText(this);
        //InputStr.setInputType(InputType.TYPE_DATETIME_VARIATION_TIME);
        InputStr.setRawInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD );
        DialogInterface.OnClickListener t1 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                DispToast(InputStr.getText().toString() );
//                DispToast("1111");
                dialog.dismiss();
            }
        };

        new AlertDialog.Builder(this).setTitle("请输入").setIcon(
                 android.R.drawable.ic_dialog_info).setView(
                InputStr).setPositiveButton("确定",t1)
                 .setNegativeButton("取消", null).show();
    }

    void StartAct(){
        Intent it = new Intent(MainActivity.this, ImgView.class);
        startActivity(it);
    }
    void StartActPass(){
        Intent it = new Intent(MainActivity.this, PassInfo.class);
        Bundle bundle=new Bundle();
        bundle.putString("name", "This is from MainActivity!");
        it.putExtras(bundle);       // it.putExtra(“test”, "shuju”);
        startActivity(it);            // startActivityForResult(it,REQUEST_CODE);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonClick = (Button)findViewById(R.id.DiaBt);
        Button InputClick = (Button)findViewById(R.id.btInput);
        Button InputClick1 = (Button)findViewById(R.id.BT2);
        Button InputClick2 = (Button)findViewById(R.id.BT3);
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog();
            }

        });
        InputClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputDialog();
            }

        });
        InputClick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartAct();
            }

        });
        InputClick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartActPass();
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
