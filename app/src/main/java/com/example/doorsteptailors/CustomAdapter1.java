package com.example.doorsteptailors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter1 extends BaseAdapter {

    String[] items1;
    Context context1;
    private LayoutInflater inflater;

    CustomAdapter1(Context received_orders,String[] items1)
    {
        this.context1=received_orders;
        this.items1=items1;
    }
    @Override
    public int getCount() {
        return items1.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            inflater= (LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.orders,parent,false);
        }
        TextView textView=(TextView) convertView.findViewById(R.id.Item1ID);

        textView.setText(items1[position]);
        return convertView;
    }
}
