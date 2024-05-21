package com.random.loginscreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String dataBaseName="Signup.db";
       public DatabaseHelper(@Nullable Context context) {
        super(context,"Signup.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("CREATE TABLE allusers(email PRIMARY KEY, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int oldVersion, int newVersion) {
        MyDatabase.execSQL("DROP TABLE IF EXİSTS allusers");
    }
    public boolean insertData(String email,String  password){
           SQLiteDatabase MyDatabase=this.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put("email",email);
            contentValues.put("password",password);
            long result=MyDatabase.insert("allusers",null,contentValues);

            if(result==-1){
                return false;
            }
            else {
                return true;
            }
    }

    public boolean checkEmail(String email){
        SQLiteDatabase MyDatabase=this.getWritableDatabase();
        Cursor cursor=MyDatabase.rawQuery("Select * From allusers where email= ? ",new String[]{email});

        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
    public  boolean checkEmailPassword(String email, String password){
           SQLiteDatabase MyDatabase=this.getWritableDatabase();
           Cursor cursor=MyDatabase.rawQuery("Select * From allusers where email=? and password =?",new String[]{email,password});
           if (cursor.getCount()>0){
               return true;
           }else {
               return false;
           }
    }
}
