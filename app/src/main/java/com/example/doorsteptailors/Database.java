package com.example.doorsteptailors;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="NewDataBase.db";

    private static final int VERSION_NUMBER=2;

    private static final String TAILOR_TABLE="Tailor_Details";
    private static final String T_ID="T_id";
    private static final String T_NAME="T_Name";
    private static final String T_USERNAME="T_Username";
    private static final String T_ADDRESS="T_Address";
    private static final String T_CONTACT_NUMBER="T_Contact_number";
    private static final String T_EMAIL="T_Email";
    private static final String T_PASSWORD="T_Password";
    private static final String T_SHOP_NAME="T_Shop_name";
    private static final String T_WORKING_EXPERIENCE="T_Working_Experience";
    private static final String T_AVAILABILITY="T_Availability";
    private static final String T_RATING="T_Rating";
    private static final String T_SHOP_IMAGE="T_Shop_Image";


    private static final String CUSTOMER_TABLE="Customer_Details";
    private static final String C_ID="C_id";
    private static final String C_NAME="C_Name";
    private static final String C_USERNAME="C_Username";
    private static final String C_ADDRESS="C_Address";
    private static final String C_CONTACT_NUMBER="C_Contact_number";
    private static final String C_EMAIL="C_Email";
    private static final String C_PASSWORD="C_Password";


    private Context context;

    private static final String CREATE_TABLE_TAILOR= "CREATE TABLE "+TAILOR_TABLE+"("+T_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+T_NAME+" VARCHAR(255) NOT NULL,"+T_USERNAME+" VARCHAR(255) NOT NULL,"+T_ADDRESS+" VARCHAR(255) NOT NULL,"+T_CONTACT_NUMBER+" TEXT NOT NULL,"+T_EMAIL+" TEXT NOT NULL,"+T_PASSWORD+" TEXT NOT NULL,"+T_SHOP_NAME+"TEXT NOT NULL,"+T_WORKING_EXPERIENCE+" TEXT NOT NULL,"+T_AVAILABILITY+"TEXT NOT NULL,"+T_RATING+"INTEGER,"+T_SHOP_NAME+",BLOB);";
    private static final String DROP_TABLE_TAILOR ="DROP TABLE IF EXISTS "+TAILOR_TABLE;

    private static final String CREATE_TABLE_CUSTOMER= "CREATE TABLE "+CUSTOMER_TABLE+"("+C_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+C_NAME+" VARCHAR(255) NOT NULL,"+C_USERNAME+" VARCHAR(255) NOT NULL,"+C_ADDRESS+" VARCHAR(255) NOT NULL,"+C_CONTACT_NUMBER+" TEXT NOT NULL,"+C_EMAIL+" TEXT NOT NULL,"+C_PASSWORD+" TEXT NOT NULL);";
    private static final String DROP_TABLE_CUSTOMER ="DROP TABLE IF EXISTS "+CUSTOMER_TABLE;

    public Database(Context context) {
        super(context,DATABASE_NAME,null, VERSION_NUMBER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_TABLE_TAILOR);
            db.execSQL(CREATE_TABLE_CUSTOMER);
            Toast.makeText(context,"onCreate is called", Toast.LENGTH_LONG).show();
        }
        catch(Exception e) {
            Toast.makeText(context,"Exception:"+e, Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Toast.makeText(context,"onUpgrade is called", Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE_TAILOR);
            db.execSQL(DROP_TABLE_CUSTOMER);
            onCreate(db);

        }
        catch(Exception e) {
            Toast.makeText(context,"Exception:"+e, Toast.LENGTH_LONG).show();

        }
    }
    public long InsertTailor(UserDetails user)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T_NAME,user.getname());
        values.put(T_USERNAME,user.getusername());
        values.put(T_ADDRESS,user.getaddress());
        values.put(T_CONTACT_NUMBER,user.getConNo());
        values.put(T_EMAIL,user.getEmail());
        values.put(T_PASSWORD,user.getPw());

        long rowID=sqLiteDatabase.insert(TAILOR_TABLE,null,values);

        return rowID;
    }

    public long InsertCustomer(UserDetails user)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(C_NAME,user.getname());
        values.put(C_USERNAME,user.getusername());
        values.put(C_ADDRESS,user.getaddress());
        values.put(C_CONTACT_NUMBER,user.getConNo());
        values.put(C_EMAIL,user.getEmail());
        values.put(C_PASSWORD,user.getPw());

        long rowID=sqLiteDatabase.insert(CUSTOMER_TABLE,null,values);

        return rowID;
    }
    public Boolean SignInTailor(String uname, String pass)
    {
        SQLiteDatabase sqLiteDatabase =this.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT*FROM "+TAILOR_TABLE,null);
        Boolean result=false;
        if(cursor.getCount()==0)
        {
            Toast.makeText(context,"No data is found",Toast.LENGTH_LONG).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                String username=cursor.getString(2);
                String password=cursor.getString(6);

                if(username.equals(uname)&& password.equals(pass))
                {
                    result=true;
                    break;
                }
            }
        }
        return result;
    }
    public Boolean SignInCustomer(String uname, String pass)
    {
        //Toast.makeText(context,"Database is working",Toast.LENGTH_LONG).show();

        SQLiteDatabase sqLiteDatabase =this.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT*FROM "+CUSTOMER_TABLE,null);
        Boolean result=false;
        if(cursor.getCount()==0)
        {
            Toast.makeText(context,"No data is found",Toast.LENGTH_LONG).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                //Toast.makeText(context,"Searching",Toast.LENGTH_LONG).show();

                String username=cursor.getString(2);
                //Toast.makeText(context,uname,Toast.LENGTH_LONG).show();
                //Toast.makeText(context,username,Toast.LENGTH_LONG).show();

                String password=cursor.getString(6);
                //Toast.makeText(context,password,Toast.LENGTH_LONG).show();
                //Toast.makeText(context,pass,Toast.LENGTH_LONG).show();

                if(username.equals(uname)&& password.equals(pass))
                {
                    result=true;
                    break;
                }
            }
        }
        return result;
    }
}
