package com.example.doorsteptailors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity implements View.OnClickListener {
    private EditText username,Password;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView;
    private Button button;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username=findViewById(R.id.SigninEditTextUsernameId);
        Password=findViewById(R.id.SigninEditTextPasswordId);
        radioGroup=findViewById(R.id.RadioGRPuId);
        textView=findViewById(R.id.signuptxtId);
        button=findViewById(R.id.SignInButtonId);

        button.setOnClickListener(this);
        textView.setOnClickListener(this);
        database=new Database(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(),"Onclick is working",Toast.LENGTH_LONG).show();


        String Username=username.getText().toString();
        String password=Password.getText().toString();

        int getid = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(getid);
        String select = radioButton.getText().toString();

        if(v.getId()== R.id.signuptxtId)
        {
            Intent signup = new Intent(getApplicationContext(),SignUp.class);
            startActivity(signup);
        }

        if(v.getId() == R.id.SignInButtonId)
        {
            Toast.makeText(getApplicationContext(),"SignUp is working",Toast.LENGTH_LONG).show();
            if(select.equals("Tailor"))
            {
                Boolean result = database.SignInTailor(Username,password);
                if(result==true)
                {
                    Intent signin=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(signin);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Username and Password didn't match",Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Boolean result = database.SignInCustomer(Username,password);
                if(result==true)
                {
                    Intent signin=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(signin);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Username and Password didn't match",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
