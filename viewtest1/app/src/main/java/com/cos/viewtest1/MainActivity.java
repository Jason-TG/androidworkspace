package com.cos.viewtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private MainActivity mContext = this;
    private Button btnMain, btnTel;

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: "+MyData.data);
        if(MyData.data == null){
            MyData.data = getSharedData();
        }
        super.onResume();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: "+MyData.data);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: "+MyData.data);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: "+MyData.data);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyData.data = "사과";

        Log.d(TAG, "onCreate: "+MyData.data);

        Intent intent = getIntent();
        String data = intent.getStringExtra("mykey");
        Log.d(TAG, "onCreate: " +data);

        init();
        initLtr();
    }

    public void initSharedData() {
        SharedPreferences pref =
                getSharedPreferences("mydata", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("data", "사과");
    }

    public Object getSharedData() {
        SharedPreferences pref =
                getSharedPreferences("mydata", Activity.MODE_PRIVATE);
            return

    }

    private void init() {
        btnMain = findViewById(R.id.btnMain);
        btnTel = findViewById(R.id.btnTel);
    }

    private void initLtr() {
        btnMain.setOnClickListener(v -> {
            MyData.data = "딸기";
            Log.d(TAG, "initLtr: Mydata.data"+MyData.data);
           Intent intent = new Intent(
                   mContext,
                   SubActivity.class
           );
//           기본 : no flag
//           intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

           intent.putExtra("mykey", "수박");
           intent.putExtra("user", new User(1, "ssar", "1234"));
           startActivity(intent);
        });

        btnTel.setOnClickListener(v -> {
            Intent intent = new Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel: 01055552222")
            );
            startActivity(intent);
        });
    }
}