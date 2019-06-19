package com.example.myapplication.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initView();
        show();

    }


    private void initView() {
        listView = (ListView) findViewById(R.id.list_view);
    }

    private void show() {
        String[] data = {"a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this,
                android.R.layout.simple_list_item_1,data);


        listView.setAdapter(adapter);

    }
}
