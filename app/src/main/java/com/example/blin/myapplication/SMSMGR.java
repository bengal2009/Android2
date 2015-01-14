package com.example.blin.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class SMSMGR extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsmgr);
        Button bt = (Button) findViewById(R.id.SendBT);
        Button bt11 = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num = (EditText) findViewById(R.id.num);
                EditText content = (EditText) findViewById(R.id.content);
                String mobile = num.getText().toString();
                String smstext = content.getText().toString();
                //获取SmsManager

                //如果内容大于70字，则拆分为多条
                SmsManager sms=SmsManager.getDefault();
                List<String> texts = sms.divideMessage(smstext);
                //逐条发送短信
                for (String text : texts)

                {

                    sms.sendTextMessage(mobile, null, text, null, null);

                }

                //发送结果提示

                Toast.makeText(SMSMGR.this, "发送成功", Toast.LENGTH_LONG).show();


            }

        });
    }

/*void SetNote(){
    Notification notification = new Notification(R.drawable.ic_launcher,

            "Service started", System.currentTimeMillis());

    PendingIntent contentIntent = PendingIntent.getActivity(this, 0,

            new Intent(this, SMSMGR.class), 0);

// must set this for content view, or will throw a exception

    notification.setLatestEventInfo(this, "Test Service",

            "Service started", contentIntent);

    nm.notify(R.string.hello, notification);

}*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_smsmgr, menu);
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
