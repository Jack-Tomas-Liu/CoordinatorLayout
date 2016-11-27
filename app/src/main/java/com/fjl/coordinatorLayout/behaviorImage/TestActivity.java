package com.fjl.coordinatorLayout.behaviorImage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

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
public class TestActivity extends AppCompatActivity {

    @BindView(R.id.iv_dependency)
    ImageView mIvDependency;
    @BindView(R.id.iv_child)
    ImageView mIvChild;
    private int mLastX;
    private int mLastY;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        ButterKnife.bind(this);
        mIvDependency.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // 记录触摸点坐标
                        mLastX = x;
                        mLastY = y;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // 计算偏移量
                        int offsetX = x - mLastX;
                        int offsetY = y - mLastY;
                        mIvDependency.offsetLeftAndRight(offsetX);
                        mIvDependency.offsetTopAndBottom(offsetY);
                        break;

                    default:
                        break;
                }
                return true;
            }
        });
        mIvChild.postDelayed(new Runnable() {
            @Override
            public void run() {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)mIvChild.getLayoutParams();
                final DependentBehavior dependentBehavior = (DependentBehavior) layoutParams.getBehavior();
                dependentBehavior.setInitDisX(mIvDependency.getLeft() - mIvChild.getLeft());
            }
        }, 100);
    }
}
