package com.fjl.coordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fjl.coordinatorLayout.behaviorImage.TestActivity;
import com.fjl.coordinatorLayout.behaviormore.MainActivity;
import com.fjl.coordinatorLayout.behaviorrecy.BehaviorRecyActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

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
public class FirstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.behavior_image)
    public void goBe(){
        startActivity(new Intent(FirstActivity.this, TestActivity.class));
    }
    @OnClick(R.id.behavior_recy)
    public void go(){
        startActivity(new Intent(FirstActivity.this, BehaviorRecyActivity.class));
    }
    @OnClick(R.id.more)
    public void more(){
        startActivity(new Intent(FirstActivity.this, MainActivity.class));
    }
}
