package com.example.myapplication;

import android.app.Application;

public class MyAplication extends Application {
    static int  TEST;
    static int USERID = 1;


    public static int getTEST() {
        return TEST;
    }

    public static void setTEST(int TEST) {
        MyAplication.TEST = TEST;
    }

    public static int getUSERID() {
        return USERID;
    }

    public static void setUSERID(int USERID) {
        MyAplication.USERID = USERID;
    }

}
