package com.example.doorsteptailors;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductListAdapter extends ArrayAdapter<ProductItem> {

    private final Activity context;
    private final ArrayList<ProductItem> items ;
    private final ListView productList;

    public ProductListAdapter(Activity context , ArrayList<ProductItem> items,ListView productList) {
        super(context,R.layout.product_item, items); // this line actually tells the app that this is the row of list
        // TODO Auto-generated constructor stub
        this.context=context;
        this.items = items;
        this.productList = productList;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        @SuppressLint("ViewHolder") View rowView= inflater.inflate(R.layout.product_item, null,true);

        TextView product_name = rowView.findViewById(R.id.product_name);
        TextView product_price = rowView.findViewById(R.id.product_price);

        product_name.setText(items.get(position).productName);
        product_price.setText(items.get(position).price);

        ImageButton delete = rowView.findViewById(R.id.deleteItem);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(position);
                notifyDataSetChanged();

                int totalHeight = 0;
                for (int i = 0; i < getCount(); i++) {
                    View listItem = getView(i, null, productList);
                    listItem.measure(0, 0);
                    totalHeight += listItem.getMeasuredHeight() + (listItem.getMeasuredHeightAndState() / 2);
                }

                ViewGroup.LayoutParams params = productList.getLayoutParams();
                params.height = totalHeight + (productList.getDividerHeight() * (getCount() - 1));
                productList.setLayoutParams(params);
                productList.requestLayout();
            }
        });

        return rowView;
    };
}
