package com.example.myapplication;

import android.app.Application;

public class MyAplication extends Application {
    static int  TEST;
    static int USERID = 1;

    public static int getTest() {
        return TEST;
    }

    public static void setTest(int test) {
        MyAplication.TEST = test;
    }

    public static int getUSERID() {
        return USERID;
    }

    public static void setUSERID(int USERID) {
        MyAplication.USERID = USERID;
    }
}
