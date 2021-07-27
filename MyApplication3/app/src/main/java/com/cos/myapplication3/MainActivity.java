package com.cos.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    private TextView tvCount;
    private Button btnAdd, btnMinus;

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//      logd (d : debug, e : error)
        Log.d(TAG, "onCreate: Start");
//      시작.

        super.onCreate(savedInstanceState);

        /*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         */

        setContentView(R.layout.activity_main); // inflate

//      통신 => 다운로드 => 그림 그릴 예정.

        init();
        initData();
        initListener();

    } // onCreate() 함수가 종료될 때 그림이 그려진다.

    //    View를 찾는 함수 , 버터 나이프
    private void init() {
        tvCount = findViewById(R.id.tvCount);
        btnAdd = findViewById(R.id.btnAdd);
        btnMinus = findViewById(R.id.btnMinus);
    } // init()
//      안드로이드의 리소스들은 R이라는 객체에 들어있다.

    private void initData() {
        CountProvider countProvider = new CountProvider();
        new Thread(()->{
            count = countProvider.download();
            tvCount.setText(count+"");
        }).start();
    } // initData()

    private void initListener(){
        btnAdd.setOnClickListener((View v)->{
            count = count + 1;
            tvCount.setText(count + "");
        });
        btnMinus.setOnClickListener((View v)->{
            Log.d(TAG, "initListener: 클릭됨");
            count = count - 1;
            tvCount.setText(count + "");
        });
    } // initListener()

} // MainActivity{}