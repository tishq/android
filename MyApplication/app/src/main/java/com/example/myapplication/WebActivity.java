package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {


    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        initView();
        show();
//        Toast.makeText(WebActivity.this,String.valueOf(MyAplication.getTest()),Toast.LENGTH_SHORT).show();
    }

    private void  initView() {
        webView = (WebView) findViewById(R.id.web_view);

    }

    public void show() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");


        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        webView.getSettings().setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        webView.getSettings().setSupportZoom(true);//是否可以缩放，默认true
        webView.getSettings().setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        webView.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        webView.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        webView.getSettings().setAppCacheEnabled(true);//是否使用缓存
        webView.getSettings().setDomStorageEnabled(true);//DOM Storage
       // displayWebview.getSettings().setUserAgentString("User-Agent:Android");//设置用户代理，一般不用

        webView.setWebViewClient(new WebViewClient()); //打开新的页面也用webview
        webView.loadUrl(url);

    }
}
