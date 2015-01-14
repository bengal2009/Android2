package com.example.blin.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class IntentTest extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_test);
        Button INBT1 = (Button)findViewById(R.id.INBT1);
        Button INBT2 = (Button)findViewById(R.id.INBT2);
        Button INBT3 = (Button)findViewById(R.id.INBT3);
        Button INBT4 = (Button)findViewById(R.id.INBT4);
        Button INBT5 = (Button)findViewById(R.id.INBT5);
        Button INBT6 = (Button)findViewById(R.id.INBT6);
        Button INBT7 = (Button)findViewById(R.id.INBT7);
        Button INBT8 = (Button)findViewById(R.id.INBT8);
        Button INBT9 = (Button)findViewById(R.id.INBT9);
//        显示网页

        INBT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.baidu.com");
                 Intent it = new Intent(Intent.ACTION_VIEW, uri);
                 startActivity(it);
            }

        });
        INBT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:38.899533,-77.036476");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
                //其他 geo URI 範例
                //geo:latitude,longitude
                //geo:latitude,longitude?z=zoom
                //geo:0,0?q=my+street+address
                //geo:0,0?q=business+near+city
                //google.streetview:cbll=lat,lng&cbp=1,yaw,,pitch,zoom&mz=mapZoom
            }

        });
        INBT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Uri uri = Uri.parse("http://maps.google.com/maps?f=d&saddr=startLat%20startLng&daddr=endLat%20endLng&hl=en");
               Intent it = new Intent(Intent.ACTION_VIEW, uri);
               startActivity(it);
               //where startLat, startLng, endLat, endLng are a long with 6 decimals like: 50.123456
            }

        });
        INBT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //叫出拨号程序
               Uri uri = Uri.parse("tel:0800000123");
               Intent it = new Intent(Intent.ACTION_DIAL, uri);
               startActivity(it);
               //直接打电话出去
              /* Uri uri = Uri.parse("tel:0800000123");
               Intent it = new Intent(Intent.ACTION_CALL, uri);
               startActivity(it);
               //用這個，要在 AndroidManifest.xml 中，加上
               //<uses-permission id="android.permission.CALL_PHONE" />
            }

        });
        INBT5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //调用短信程序
                Uri uri = Uri.parse("smsto://0800000123");
               Intent it = new Intent(Intent.ACTION_VIEW, uri);
               it.putExtra("sms_body", "The SMS text");
               it.setType("vnd.android-dir/mms-sms");
               startActivity(it);
               //传送消息
              /* Uri uri = Uri.parse("smsto://0800000123");
               Intent it = new Intent(Intent.ACTION_SENDTO, uri);
               it.putExtra("sms_body", "The SMS text");*/

               /*startActivity(it);*/
               //传送 MMS
               /*Uri uri = Uri.parse("content://media/external/images/media/23");
               Intent it = new Intent(Intent.ACTION_SEND);
               it.putExtra("sms_body", "some text");
               it.putExtra(Intent.EXTRA_STREAM, uri);
               it.setType("image/png");
               startActivity(it);*/
            }

        });
        INBT6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Uri uri = Uri.parse("mailto:xxx@abc.com");
              Intent it = new Intent(Intent.ACTION_SENDTO, uri);
              startActivity(it);


            /*  Intent it = new Intent(Intent.ACTION_SEND);
              it.putExtra(Intent.EXTRA_EMAIL, "me@abc.com");
              it.putExtra(Intent.EXTRA_TEXT, "The email body text");
              it.setType("text/plain");
              startActivity(Intent.createChooser(it, "Choose Email Client"));*/


              /*Intent it=new Intent(Intent.ACTION_SEND);
              String[] tos={"me@abc.com"};
              String[] ccs={"you@abc.com"};
              it.putExtra(Intent.EXTRA_EMAIL, tos);
              it.putExtra(Intent.EXTRA_CC, ccs);
              it.putExtra(Intent.EXTRA_TEXT, "The email body text");
              it.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");
              it.setType("message/rfc822");
              startActivity(Intent.createChooser(it, "Choose Email Client"));*/
             /*   1. //传送附件
                2. Intent it = new Intent(Intent.ACTION_SEND);
                3. it.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");
                4. it.putExtra(Intent.EXTRA_STREAM, "file:///sdcard/mysong.mp3");
                5. sendIntent.setType("audio/mp3");
                6. startActivity(Intent.createChooser(it, "Choose Email Client"));*/
            }

        });
        INBT7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("file:///sdcard/song.mp3");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                it.setType("audio/mp3");
                startActivity(it);
//                Uri uri1 = Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "1");
//                Intent it1 = new Intent(Intent.ACTION_VIEW, uri1);
//                startActivity(it1);
            }

        });
        INBT8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 //寻找某个应用
                 Uri uri = Uri.parse("market://search?q=pname:pkg_name");
                 Intent it = new Intent(Intent.ACTION_VIEW, uri);
                 startActivity(it);
                 //where pkg_name is the full package path for an application
                 //显示某个应用的相关信息
                /* Uri uri = Uri.parse("market://details?id=app_id");
                 Intent it = new Intent(Intent.ACTION_VIEW, uri);
                 startActivity(it);*/
                 //where app_id is the application ID, find the ID
                 //by clicking on your application on Market home
                 //page, and notice the ID from the address bar
            }

        });
        INBT9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   Uri uri = Uri.fromParts("package", strPackageName, null);
                Intent it = new Intent(Intent.ACTION_DELETE, uri);
                startActivity(it);*/
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intent_test, menu);
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
