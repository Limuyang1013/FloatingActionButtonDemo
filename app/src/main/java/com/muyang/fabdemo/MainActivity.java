package com.muyang.fabdemo;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private FloatingActionButton fab;
    private CoordinatorLayout mCoor;
    private List<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        mCoor = (CoordinatorLayout) findViewById(R.id.coor);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        setData();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mCoor,"FAB",Snackbar.LENGTH_SHORT)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .show();
            }
        });
    }
    private void setData() {
        listData = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            listData.add(i + "");
        }
        lv.setAdapter(new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, listData));
    }
}
