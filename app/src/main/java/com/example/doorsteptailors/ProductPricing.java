package com.example.doorsteptailors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ProductPricing extends AppCompatActivity {
    private ArrayList<ProductItem> listItems = new ArrayList<ProductItem>();
    private ProductListAdapter adapter;
    private EditText priceEditText ;
    private EditText productEditText ;
    private ListView productList;
    private EditText discountRate ;
    private int current ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_pricing);
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setIcon(R.drawable.ic_launcher_background); // sets title icon
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        productEditText = findViewById(R.id.item_name);
        priceEditText = findViewById(R.id.item_price);
        productList = findViewById(R.id.productList);
        discountRate = findViewById(R.id.discount_rate);
        discountRate.setFocusable(false);
        discountRate.setText(String.valueOf(current));
        adapter = new ProductListAdapter(this,listItems,productList);
        productList.setAdapter(adapter);

    }

    public void increase(View view){
        if(current<50){
            current += 5;
        }
        discountRate.setText(String.valueOf(current));
        //discountRate.clearFocus();
    }

    public void decrease(View view){
        if(current>=5){
            current -= 5;
        }
        discountRate.setText(String.valueOf(current));
        //discountRate.clearFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.right_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void addClickHandler(View view){
        String itemName = productEditText.getText().toString();
        String price = priceEditText.getText().toString();

        if(!itemName.equals("") && !price.equals("")) {
            ProductItem item = new ProductItem(itemName, price + " BDT");

            listItems.add(item);
            adapter.notifyDataSetChanged();

            if (adapter != null) {
                int totalHeight = 0;
                for (int i = 0; i < adapter.getCount(); i++) {
                    View listItem = adapter.getView(i, null, this.productList);
                    listItem.measure(0, 0);
                    totalHeight += listItem.getMeasuredHeight() + (listItem.getMeasuredHeightAndState() / 2);
                }

                ViewGroup.LayoutParams params = productList.getLayoutParams();
                params.height = totalHeight + (productList.getDividerHeight() * (adapter.getCount() - 1));
                productList.setLayoutParams(params);
                productList.requestLayout();

                productEditText.getText().clear();
                priceEditText.getText().clear();
                priceEditText.clearFocus();
                productEditText.clearFocus();
            }
        }
    }
}
