package com.example.doorsteptailors;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private EditText name,username,address,phnNo,Email,Password,ConfirmPassword;
    private RadioGroup radiogrp;
    private RadioButton radioBtn;
    private Button btn;

    int selectedid;

    UserDetails user;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name= findViewById(R.id.EditTextNameId);
        username= findViewById(R.id.EditTextUsernameId);
        address= findViewById(R.id.EditTextAddressId);
        phnNo= findViewById(R.id.EditTextPhoneNoId);
        Email= findViewById(R.id.EditTextEmailId);
        Password = findViewById(R.id.EditTextPasswordId);
        ConfirmPassword = findViewById(R.id.EditTextConfirmPasswordId);
        radiogrp =findViewById(R.id.RadioGRPsId);
        btn=findViewById(R.id.SignUpButtonId);


        user =new UserDetails();
        btn.setOnClickListener(this);

        database=new Database(this);

    }


    @Override
    public void onClick(View v) {

        //Toast.makeText(getApplicationContext(),"Onclick is working",Toast.LENGTH_LONG).show();
        String Name= name.getText().toString();
        String Username= username.getText().toString();
        String Address= address.getText().toString();
        String PhoneNo= phnNo.getText().toString();
        String email= Email.getText().toString();
        String password= Password.getText().toString();

        String confirmpassword = ConfirmPassword.getText().toString();

        user.setname(Name);
        user.setusername(Username);
        user.setaddress(Address);
        user.setConNo(PhoneNo);
        user.setEmail(email);
        user.setPw(password);


        int selectedid= radiogrp.getCheckedRadioButtonId();
        radioBtn=findViewById(selectedid);
        String selection=radioBtn.getText().toString();

        if(v.getId()==R.id.SignUpButtonId)
        {
            if(password == confirmpassword)
            {
                if(selection.equals("Tailor"))
                {
                    long rowId=database.InsertTailor(user);
                    if(rowId>0)
                    {
                        Toast.makeText(getApplicationContext(),"Row :"+rowId+"has inserted in Tailor Table",Toast.LENGTH_LONG).show();
                        Intent signin = new Intent(getApplicationContext(),SignIn.class);
                        startActivity(signin);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Nooo insertion",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    long rowId=database.InsertCustomer(user);
                    if(rowId>0)
                    {
                        Toast.makeText(getApplicationContext(),"Row :"+rowId+"has inserted in Customer Table",Toast.LENGTH_LONG).show();
                        Intent signin = new Intent(getApplicationContext(),SignIn.class);
                        startActivity(signin);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Noo insertion",Toast.LENGTH_LONG).show();
                    }
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Password and Confirm Password Didn't match",Toast.LENGTH_LONG).show();
            }

        }
    }
}
