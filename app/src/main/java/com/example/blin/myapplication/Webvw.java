package com.example.blin.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class Webvw extends ActionBarActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webvw);
        webView = (WebView) findViewById(R.id.webView1);

            webView.getSettings().setJavaScriptEnabled(true);//设置使用够执行JS脚本
            webView.getSettings().setBuiltInZoomControls(true);//设置使支持缩放
            webView.getSettings().setDefaultFontSize(5);

            webView.loadUrl("http://60.248.68.66");
            webView.setWebViewClient(new WebViewClient(){
                 @Override
                 public boolean shouldOverrideUrlLoading(WebView view, String url) {
                         // TODO Auto-generated method stub
                         view.loadUrl(url);// 使用当前WebView处理跳转
                         return true;//true表示此事件在此处被处理，不需要再广播
                     }
                 @Override   //转向错误时的处理
                 public void onReceivedError(WebView view, int errorCode,
                                                   String description, String failingUrl) {
                         // TODO Auto-generated method stub
                         Toast.makeText(Webvw.this, "Oh no! " + description, Toast.LENGTH_SHORT).show();
                     }
                 });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_webvw, menu);
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

    @Override   //默认点回退键，会退出Activity，需监听按键操作，使回退在WebView内发生
    public boolean onKeyDown(int keyCode, KeyEvent event) {
       // TODO Auto-generated method stub
       if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
               webView.goBack();
               return true;
           }
           return super.onKeyDown(keyCode, event);
         }

}
