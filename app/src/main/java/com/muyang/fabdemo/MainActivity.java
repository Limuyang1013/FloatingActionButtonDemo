package com.muyang.fabdemo;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private CoordinatorLayout mCoor;
    private TextView hide;
    //判断是否打开
    private boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.mRecycleView);
        mCoor = (CoordinatorLayout) findViewById(R.id.coor);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        hide = (TextView) findViewById(R.id.hide);
        // 线性布局
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerViewAdapter(this));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * SnackBar结合RotateBehavior使用
                 */
//                Snackbar.make(mCoor,"FAB",Snackbar.LENGTH_SHORT)
//                        .setAction("UNDO", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//
//                            }
//                        })
//                        .show();
                if (!isOpen) {
                    turnLeft(v);
                } else {
                    trunRight(v);
                }
            }
        });
    }

    //开始旋转
    public void turnLeft(View v) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotation", 0, -155, -135);
        objectAnimator.setDuration(300);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.start();
        hide.setVisibility(View.VISIBLE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 0.75f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setFillAfter(true);
        hide.startAnimation(alphaAnimation);
        isOpen = true;
    }

    //回到起始位置
    public void trunRight(View v) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotation", -135, 20, 0);
        objectAnimator.setDuration(300);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.start();
        hide.setVisibility(View.GONE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.75f, 0);
        alphaAnimation.setDuration(300);
        alphaAnimation.setFillAfter(true);
        hide.startAnimation(alphaAnimation);
        isOpen = false;
    }

}
