package com.fjl.coordinatorLayout.behaviorrecy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fjl.coordinatorLayout.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fan on 2016/11/27.
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * <p/>
 * ━━━━━━感觉萌萌哒━━━━━━
 */
public class BehaviorRecyActivity extends AppCompatActivity {
    @BindView(R.id.recyclerview_dependency)
    RecyclerView mRecyclerviewDependency;
    @BindView(R.id.recyclerview_child)
    RecyclerView mRecyclerviewChild;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.behavior_recy);
        ButterKnife.bind(this);
        initView();
    }
    private void initView() {
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        MyAdapter adapter1 = new MyAdapter();
        mRecyclerviewDependency.setLayoutManager(layoutManager1);
        mRecyclerviewDependency.setAdapter(adapter1);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        MyAdapter adapter2 = new MyAdapter();
        mRecyclerviewChild.setLayoutManager(layoutManager2);
        mRecyclerviewChild.setAdapter(adapter2);
    }

    public class MyAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(BehaviorRecyActivity.this).inflate(R.layout.item, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((MyViewHolder)holder).updateView("position : " + position);
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

        void updateView(String text) {
            textView.setText(text);
        }
    }
}
