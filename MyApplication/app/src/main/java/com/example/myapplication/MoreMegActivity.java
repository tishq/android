package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


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

//  重写onActivityResult()方法,接受活动返回来的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    System.out.println(returnData);
                    Log.d("FirstActivity", returnData);
                }
                break;
            default:
        }
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

//               活动跳转和消息传递
                Intent intent = new Intent(MoreMegActivity.this, MainActivity.class);
                intent.putExtra("choice",mes);

//                传数据到上一个活动,并接受返回的消息
//                请求码用用于在之后的回调中判断数据来源
                startActivityForResult(intent, 1);

//                传数据到下一个活动,不需要接受返回消息
//                intent.putExtra("choice",mes);
//                startActivity(intent);


                Intent intent1 =new Intent(MoreMegActivity.this, com.example.myapplication.test.RecyclerViewActivity.class);
//                startActivity(intent1);


            }
        });

    }

}
