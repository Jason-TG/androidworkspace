package com.cos.viewtest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.viewtest.MainActivity;
import com.cos.viewtest.R;
import com.cos.viewtest.model.Person;

import java.util.ArrayList;
import java.util.List;

// 2. 어댑터 만들기
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder> {

    private static final String TAG = "PersonAdapter";
    private MainActivity mContext;
    private int createCount = 1;
    private int bindCount = 1;

//  3. 컬렉션 만들기
    private List<Person> persons = new ArrayList<>();

//  4. 컬렉션 데이터 세팅
    public void addItems(List<Person> persons) {
        this.persons = persons;
        notifyDataSetChanged();
        rvPersons.scrollToPosition(getItemCount()-1);
    }

    public void addItem(Person person) {
        this.persons.add(person);
        notifyDataSetChanged();
        mContext.mRvScroll();
    }

    public List<Person> getItems(){
        return persons;
    }

    public void removeItem(int index){
        persons.remove(index);
        notifyDataSetChanged();
    }

//  뷰홀더 객체 만드는 함수
//  뷰홀더 생성차를 호출
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater
                = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.person_item, parent, false);
        view.setOnClickListener(v -> {
            Log.d(TAG, "onCreateViewHolder: "+v);

        });
        return new MyViewHolder(view);
//      여기서 view는 linearlayout
    }

//  뷰홀더에 새로운 데이터를 바인딩하는 함수
//  setItem을 호출
//  최초에는 onCreateViewHolder가 실행되는 횟수만큼 실행.
//  이후 스크롤 시 필요한 만큼 단독적으로 실행.
    @Override
    public void onBindViewHolder(PersonAdapter.MyViewHolder holder, int position) {
        Person person = persons.get(position);
        holder.setItem(person);
    }

//  어댑터가 자동적으로 호출해서 출력할 뷰의 수를 연산
//  연산 이후 onCreateViewHolder를 자동적으로 호출
    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvTel;

//      앱 구동 시에 발동
        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvTel = itemView.findViewById(R.id.tvTel);

            initListener();
        }

        private void initListener() {
            itemView.setOnClickListener(v -> {
                Log.d(TAG, "initListener: " +getAdapterPosition());
                int index = getAdapterPosition();
                Log.d(TAG, "initListener: "+personAdapter.getItem());
                personAdapter.removeItem(index);

//                TextView t = v.findViewById(R.id.tvName);
//                Log.d(TAG, "initListener: "+t.getText());
            });
        }

//      앱 구동시 + 스크롤 시에 발동
        public void setItem(Person person) {
            tvName.setText(person.getName());
            tvTel.setText(person.getTel());
        }

    }

}
