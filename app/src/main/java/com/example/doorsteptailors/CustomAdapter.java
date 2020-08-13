package com.example.doorsteptailors;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int[] images;
    String[] tailorNames;
    private LayoutInflater inflater;


    public CustomAdapter(Context bestRated, String[] tailorNames, int[] images) {
        this.context = bestRated;
        this.tailorNames = tailorNames;
        this.images=images;
    }

    @Override
    public int getCount() {
        return tailorNames.length;
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

        if(convertView == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row,parent,false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewTailorId);
        TextView textView = (TextView) convertView.findViewById(R.id.TextViewTailorNameID);

        textView.setText(tailorNames[position]);
        imageView.setImageResource(images[position]);

        return convertView;
    }
}
