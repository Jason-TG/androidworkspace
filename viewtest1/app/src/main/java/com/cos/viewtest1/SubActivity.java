package com.cos.viewtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    private Button btnSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String
        User
        Log.d(TAG, "onCreate: ");
        Log.d(TAG, "onCreate: ");
        init();
        initLtr();
    }

    private void init(){
        btnSub = findViewById(R.id.btnSub);

    }

    private void initLtr() {
        btnSub.setOnClickListener(v -> {
            finish();
        });
    }

}