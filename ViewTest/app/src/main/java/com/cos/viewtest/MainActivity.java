package com.cos.viewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.cos.viewtest.adapter.PersonAdapter;
import com.cos.viewtest.provider.PersonProvider;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


// 어댑터와 리사이클러뷰 연결
public class MainActivity extends AppCompatActivity {

    private MainActivity mContext = this;
    private View rvPersons;
    private androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
    private PresonAdapter personAdapter;
    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init(); // 1번
        initAdapter(); // 어댑터 생성 2번
        initData(); // 데이터 생성 마지막.
        initListener();

    } // onCreate()

    private void initListener() {
        fabAdd.setOn(v -> {
            personAdapter.addItem(new Person("이름new", ))
        });
    }

    new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT)) {
        @Override
        public boo


    }

    private int initAdapter() {
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPersons.setLayoutManager(layoutManager);
        personAdapter = new PersonAdapter(mContext);
        rvPersons.setAdapter(personAdapter);
        return 0;
    }

    private void initData() {
        PersonProvider p = new PersonProvider();
        personAdapter.addItems(p.findAll());
    }

    private void init(){
        rvPersons = findViewById(R.id.rvPersons);
    } // init()



    public void mRvScroll() {
        rvPersons.scrollToPosition(getItemCount()-1);
    }
}