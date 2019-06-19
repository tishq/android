package com.example.myapplication.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.bean.Article;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class http extends AppCompatActivity {
    private TextView textView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        sendHttp();

    }
    private void initView() {

        listView = (ListView) findViewById(R.id.list_view);

    }


//  点击back键后,把消息返回给上一个活动
    @Override
    public void onBackPressed() {
//        返回数据到上一个活动
        Intent intent1 = new Intent();
        intent1.putExtra("data_return","return@@@@@@@");
        setResult(RESULT_OK,intent1);
        finish();
    }



    public void sendHttp() {

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
                    String url = "http://tishq.cn:8401/articles?keyword="+t;


//                    利用JSONString构造json类型的string数据
//                    JSONObject postData = new JSONObject();
////                            String s1 = {"article_kwd":"大数据"}
//                    String keyword = mes;
//                    postData.put("article_kwd", keyword);
//                    String jsonString = postData.toString();
//                            System.out.println(jsonString + "#########");



//                            利用对象构造json类型的string数据
//                            Query query = new Query();
//                            query.setArticle_kwd("大数据");
//                            Gson gson = new Gson();
//                            String json = gson.toJson(query);
//                            System.out.println(json);

//                    构造post请求的body
//                    方式一
//                    RequestBody body = FormBody.create(MediaType.parse("application/json; charset=utf-8"),
//                            jsonString);

//                     方式二
//                     RequestBody body = new FormBody.Builder().add("article_kwd","大数据").build();

//                    发送post请求(url不能是localhost)
//                    Request request = new Request.Builder().url(path)//请求的url
//                            .post(body).build();

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
                                    Toast.makeText(http.this, "清检查网络连接！",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {


                            String aa = response.body().string();
//                            System.out.println(aa);
                            System.out.println("@@@@@@@@@@@@@@@@@@@@");
                            Gson gson1 = new Gson();
                            List<Article> la = gson1.fromJson(aa, new TypeToken<List<Article>>() {
                            }.getType());



                            for (int ff = 0; ff < la.size(); ff++) {
                                Integer articleId = la.get(ff).getArticleId();
                                String title = la.get(ff).getTitle();
                                String url = la.get(ff).getUrl();
                                System.out.println(articleId);
                                System.out.println(title);
                                System.out.println(url);

                            }


//                            解析列表中的整数
    //                                    List<Integer> la = gson.fromJson(aa, new TypeToken<List<Integer>>() {
    //                                    }.getType());
    //                                    System.out.println(la.get(0));
    //                                    if(la.get(0)==15) {
    //                                        System.out.println(15);
    //                                    }
                            runOnUiThread(new Runnable() {
                                public void run() {


                                        Toast.makeText(http.this, "注册成功！",
                                            Toast.LENGTH_SHORT).show();

                                }
                            });

                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        runnable.run();
    }
}
