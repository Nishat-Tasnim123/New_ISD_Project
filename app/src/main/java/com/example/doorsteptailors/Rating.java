package com.example.doorsteptailors;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Rating extends AppCompatActivity implements View.OnClickListener {

    private RatingBar ratingBar;
    private TextView textView;
    private Button btn;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        ratingBar=(RatingBar) findViewById(R.id.ratingBarId);
        textView=(TextView) findViewById(R.id.textId);
        btn= findViewById(R.id.testbtnId);
        btn.setOnClickListener(this);


        /*ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                textView.setText("Value : "+rating);
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.testbtnId)
        {
            textView.setText("IS WORKING");
        }
    }
}
