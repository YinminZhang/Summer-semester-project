package com.example.jinquan.pan.mnist_ensorflow_androiddemo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nanohana on 2018/7/16.
 */

public class wordAdapter extends ArrayAdapter<word> {
    private static  final  String Log_TAg=wordAdapter.class.getSimpleName();
    public wordAdapter(Activity context, ArrayList<word> numberWord) {
        super(context,0, numberWord);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView=convertView;
        if (listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(
                    R.layout.list_example,parent,false);
        }
        word currentadapter=getItem(position);
        TextView name=(TextView)listItemView.findViewById(R.id.name);
        name.setText(currentadapter.getName());
        TextView number=(TextView)listItemView.findViewById(R.id.number);
        number.setText(currentadapter.getNumber());
        return listItemView;
    }
}
