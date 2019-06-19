package com.example.myapplication;

import android.app.Application;

public class MyAplication extends Application {
    static int  test;

    public static int getTest() {
        return test;
    }

    public static void setTest(int test) {
        MyAplication.test = test;
    }
}
