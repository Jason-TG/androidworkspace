package com.cos.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
implements {

    private Button[] btn = new Button[16];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initListener();
        }
    }

    private void initListener(){

    }
    

    private void init() {
        btn[0] = findViewById(R.id.num0);
        btn[1] = findViewById(R.id.num1);
        btn[2] = findViewById(R.id.num2);
        btn[3] = findViewById(R.id.num3);
        btn[4] = findViewById(R.id.num4);
        btn[5] = findViewById(R.id.num5);
        btn[6] = findViewById(R.id.num6);
        btn[7] = findViewById(R.id.num7);
        btn[8] = findViewById(R.id.num8);
        btn[9] = findViewById(R.id.num9);
        btn[10] = findViewById(R.id.btn_add);
        btn[11] = findViewById(R.id.btn_minus);
        btn[12] = findViewById(R.id.btn_multi);
        btn[13] = findViewById(R.id.btn_divide);
        btn[14] = findViewById(R.id.btn_clear);
        btn[15] = findViewById(R.id.btn_cal);
        btn[16] = findViewById(R.id.pt_result);

    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        Log.d(TAG, "onClick: ");
        ptResult.append(btn.getText());
    }

}