package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.adapter.ArticleAdapter;
import com.example.myapplication.bean.Article;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements ArticleAdapter.mitemonClick {

    List<Article> la = new ArrayList<>();


    private Context context;

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        try {
            la = sendHttp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArticleAdapter adapter = new ArticleAdapter(la, context);
        recyclerView.setAdapter(adapter);
        adapter.setItemClickListener(this);

    }


    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }


    @Override
    public void onitemOnclick(View v, int position) {
        Intent intent = new Intent(MainActivity.this, WebActivity.class);
        intent.putExtra("url",la.get(position).getUrl());
        MyAplication.setTest(1);
        startActivity(intent);

    }

    public List<Article> sendHttp() throws InterruptedException {

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
                    String url = "http://tishq.cn:8401/articles?keyword=" + t;
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
                                    Toast.makeText(MainActivity.this, "清检查网络连接！",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
//                            阻塞子线程
                            latch.countDown();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {


                            String aa = response.body().string();
//                            System.out.println(aa);
                            System.out.println("@@@@@@@@@@@@@@@@@@@@");
                            Gson gson1 = new Gson();
                            List<Article> lat = gson1.fromJson(aa, new TypeToken<List<Article>>() {
                            }.getType());

//                          把拿到的文章列表存到la
                            for (int i = 0; i < lat.size(); i++) {
                                la.add(lat.get(i));
                            }


                            runOnUiThread(new Runnable() {
                                public void run() {


                                    Toast.makeText(MainActivity.this, "注册成功！",
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
        return la;

    }


    //  点击back键后,把消息返回给上一个活动
    @Override
    public void onBackPressed() {
//        返回数据到上一个活动
        Intent intent1 = new Intent();
        intent1.putExtra("data_return", "return@@@@@@@");
        setResult(RESULT_OK, intent1);
        finish();
    }


}
