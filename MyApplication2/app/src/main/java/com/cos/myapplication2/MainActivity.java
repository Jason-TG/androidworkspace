package com.cos.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

//    logt
    private static final String TAG = "MainActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//      logd (d : debug, e : error)
        Log.d(TAG, "onCreate: Start");
//      시작.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}