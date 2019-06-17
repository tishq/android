package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


//更多信息
public class MoreMegActivity extends AppCompatActivity {


    private Button sure;
    private EditText introduce;
    public static String mes;
    private CheckBox b1;
    private CheckBox b2;
    private CheckBox b3;
    private CheckBox b4;
    private CheckBox b5;
    private CheckBox b6;
    private CheckBox b7;
    private CheckBox b8;
    private CheckBox b9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_msg);

        initView();
        initListener();
    }

    private void initView() {
        sure = (Button) findViewById(R.id.sure);
        b1 = (CheckBox) findViewById(R.id.b1);
        b2 = (CheckBox) findViewById(R.id.b2);
        b3 = (CheckBox) findViewById(R.id.b3);
        b4 = (CheckBox) findViewById(R.id.b4);
        b5 = (CheckBox) findViewById(R.id.b5);
        b6 = (CheckBox) findViewById(R.id.b6);
        b7 = (CheckBox) findViewById(R.id.b7);
        b8 = (CheckBox) findViewById(R.id.b8);
        b9 = (CheckBox) findViewById(R.id.b9);


    }

    private void initListener() {

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final StringBuffer sb = new StringBuffer();
                //判断CheckBox是否被选中
                if (b1.isChecked()) {
                    //把被选中的文字添加到StringBuffer中
                    sb.append(b1.getText().toString());
                }
                if (b2.isChecked()) {
                    //把被选中的文字添加到StringBuffer中
                    sb.append(b2.getText().toString());
                }
                if (b3.isChecked()) {
                    //把被选中的文字添加到StringBuffer中
                    sb.append(b3.getText().toString());
                }
                if (b4.isChecked()) {
                    //把被选中的文字添加到StringBuffer中
                    sb.append(b4.getText().toString());
                }
                if (b5.isChecked()) {
                    //把被选中的文字添加到StringBuffer中
                    sb.append(b5.getText().toString());
                }
                if (b1.isChecked()) {
                    //把被选中的文字添加到StringBuffer中
                    sb.append(b1.getText().toString());
                }
                if (b6.isChecked()) {
                    //把被选中的文字添加到StringBuffer中
                    sb.append(b6.getText().toString());
                }
                if (b7.isChecked()) {
                    //把被选中的文字添加到StringBuffer中
                    sb.append(b7.getText().toString());
                }
                if (b8.isChecked()) {
                    //把被选中的文字添加到StringBuffer中
                    sb.append(b8.getText().toString());
                }
                if (b9.isChecked()) {
                    //把被选中的文字添加到StringBuffer中
                    sb.append(b9.getText().toString());
                }


//                }


                Toast.makeText(MoreMegActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();

                mes = sb.toString();


                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            OkHttpClient client = new OkHttpClient();
                            String path = "http://47.100.127.206:8082/ins/" + "/" + sb;
                            final Gson gson = new Gson();
                            Request request = new Request.Builder().url(path)//请求的url
                                    .get().build();

                            Call call = client.newCall(request);
                            call.enqueue(new Callback() {
                                @Override
                                public void onFailure(Call call, final IOException e) {
                                    //进行更新UI操作
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(MoreMegActivity.this, "清检查网络连接！", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {


                                    runOnUiThread(new Runnable() {
                                        public void run() {

                                            Toast.makeText(MoreMegActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();


                                        }
                                    });

                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };


            }
        });

    }

}
