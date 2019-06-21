package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.myapplication.bean.Article;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.example.myapplication.MyAplication;

public class WebActivity extends AppCompatActivity {

    List<Article> la = new ArrayList<>();


    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        initView();
        show();
//        Toast.makeText(WebActivity.this,String.valueOf(MyAplication.getTest()),Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        webView = (WebView) findViewById(R.id.web_view);

    }

    public void show() {
        final Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        final int articleId = intent.getIntExtra("articleId", 0);


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


        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb);
        bmb.setButtonEnum(ButtonEnum.SimpleCircle);

        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_9_2);

        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_9_2);

        bmb.setBackPressListened(false);


        //        按钮1 喜欢
        SimpleCircleButton.Builder builder1 = new SimpleCircleButton.Builder()
                .normalImageRes(R.drawable.aa)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        try {
                            boolean isSuce = sendHttp(MyAplication.getUSERID(), articleId);
                            System.out.println(isSuce);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                });
        bmb.addBuilder(builder1);

        //        按钮2 搜索文章
        SimpleCircleButton.Builder builder2 = new SimpleCircleButton.Builder()
                .normalImageRes(R.drawable.aa)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        Toast.makeText(WebActivity.this,"搜索",Toast.LENGTH_SHORT);
                        Intent intent1 = new Intent(WebActivity.this, MainActivity.class);
                        intent1.putExtra("choice","java");
                        startActivity(intent1);


                    }
                });
        bmb.addBuilder(builder2);

        //        按钮3 发现文章
        SimpleCircleButton.Builder builder3 = new SimpleCircleButton.Builder()
                .normalImageRes(R.drawable.aa)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {


                        // When the boom-button corresponding this builder is clicked.
                        Toast.makeText(WebActivity.this, "Clicked " + index, Toast.LENGTH_SHORT).show();
                    }
                });
        bmb.addBuilder(builder3);

        //        按钮4
        SimpleCircleButton.Builder builder4 = new SimpleCircleButton.Builder()
                .normalImageRes(R.drawable.aa)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {


                        // When the boom-button corresponding this builder is clicked.
                        Toast.makeText(WebActivity.this, "Clicked " + index, Toast.LENGTH_SHORT).show();
                    }
                });
        bmb.addBuilder(builder4);

        //        按钮5
        SimpleCircleButton.Builder builder5 = new SimpleCircleButton.Builder()
                .normalImageRes(R.drawable.aa)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {


                        // When the boom-button corresponding this builder is clicked.
                        Toast.makeText(WebActivity.this, "Clicked " + index, Toast.LENGTH_SHORT).show();
                    }
                });
        bmb.addBuilder(builder5);

        //        按钮6
        SimpleCircleButton.Builder builder6 = new SimpleCircleButton.Builder()
                .normalImageRes(R.drawable.aa)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {


                        // When the boom-button corresponding this builder is clicked.
                        Toast.makeText(WebActivity.this, "Clicked " + index, Toast.LENGTH_SHORT).show();
                    }
                });
        bmb.addBuilder(builder6);


        //        按钮7
        SimpleCircleButton.Builder builder7 = new SimpleCircleButton.Builder()
                .normalImageRes(R.drawable.aa)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {


                        // When the boom-button corresponding this builder is clicked.
                        Toast.makeText(WebActivity.this, "Clicked " + index, Toast.LENGTH_SHORT).show();
                    }
                });
        bmb.addBuilder(builder7);

        //        按钮8
        SimpleCircleButton.Builder builder8 = new SimpleCircleButton.Builder()
                .normalImageRes(R.drawable.aa)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {


                        // When the boom-button corresponding this builder is clicked.
                        Toast.makeText(WebActivity.this, "Clicked " + index, Toast.LENGTH_SHORT).show();
                    }
                });
        bmb.addBuilder(builder8);

        //        按钮9
        SimpleCircleButton.Builder builder9 = new SimpleCircleButton.Builder()
                .normalImageRes(R.drawable.aa)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        // When the boom-button corresponding this builder is clicked.
                        Toast.makeText(WebActivity.this, "Clicked " + index, Toast.LENGTH_SHORT).show();
                    }
                });
        bmb.addBuilder(builder9);


    }


    boolean isLike = false;


    public boolean sendHttp(int uId, int aId) throws InterruptedException {

        final int userId = uId;
        final int articleId = aId;


        final CountDownLatch latch = new CountDownLatch(1);
//       拿到上一个活动传来的数据
        Intent intent = getIntent();
        final String t = intent.getStringExtra("choice");
        System.out.println(t);
//         final String t = "大数据";

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {

                    OkHttpClient client = new OkHttpClient();
//                            String a = "大数据";
//                    String path = "http://tishq.cn:5001/articles";
                    String url = "http://tishq.cn:8401/kgr?userId=" + userId + "&articleId=" + articleId;
                    System.out.println(url);


//                    发送get请求
                    Request request = new Request.Builder().url(url).get().build();

                    Call call = client.newCall(request);


                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, final IOException e) {
                            //进行更新UI操作
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(WebActivity.this, "清检查网络连接！",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
//                            阻塞子线程
                            latch.countDown();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {


                            String aa = response.body().string();
                            System.out.println(aa);
                            System.out.println("@@@@@@@@@@@@@@@@@@@@");

                            isLike = true;

                            runOnUiThread(new Runnable() {
                                public void run() {


                                    Toast.makeText(WebActivity.this, "已经喜欢！",
                                            Toast.LENGTH_SHORT).show();

                                }
                            });


//                            阻塞子线程
                            latch.countDown();

                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    latch.countDown();
                }
            }
        };

        runnable.run();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        //等待子线程执行结束
        latch.await();
        return isLike;

    }


}
