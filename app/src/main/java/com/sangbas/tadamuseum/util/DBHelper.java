package com.sangbas.tadamuseum.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Museum.db";
    private static final String TABLE_USER = "user";
    private static final String CREATE_TABLE_SQL = "create table if not exists user (id integer primary key, username text,password text)";
//    private static final String GET_USER_SQL = "select * from user where username='"+"'";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertUser (String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        db.insert(TABLE_USER, null, contentValues);
        return true;
    }

    public Cursor getUser(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from user where username='"+username+"'", null );
        return res;
    }

    public boolean isUserExist(String username) {
        Cursor res = getUser(username);
        if(res.getCount() > 0) {
            return true;
        }

        return false;
    }

    public boolean isUsernameAndPasswordMatch(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from user where username='"+username+"' and password = '"+password+"'", null );

        if(res.getCount() > 0) {
            return true;
        }
        return false;
    }
}
