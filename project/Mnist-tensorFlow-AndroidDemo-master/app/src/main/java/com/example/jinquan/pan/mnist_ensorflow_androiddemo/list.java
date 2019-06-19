package com.example.jinquan.pan.mnist_ensorflow_androiddemo;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nanohana on 2018/7/16.
 */

public class list extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_one);
        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("0"));
        words.add(new word("1"));
        words.add(new word("2"));
        words.add(new word("4"));
        words.add(new word("5"));
        words.add(new word("7"));
        words.add(new word("9"));
        wordAdapter adapter =new wordAdapter(this,words);
        ListView listView=(ListView)findViewById(R.id.listone);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(list.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("label", words.get(i).getNumber());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
