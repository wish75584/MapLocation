package com.androidbatch.androiddevelopementtrainingfelix;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//this class is for declaring all constant variables and creating table ,defining  database version
class DbHelper extends SQLiteOpenHelper {

    //declaring constant variables
    public static final String DATABASE_NAME = "database_one";//defining database name
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_TABLE = "CREATE TABLE user_login(username  text ,password text)";

    // in create table text is the datatype and username & password is variable
    //default constructor
    //context = this .context is used in separate  classes only
    //name = table name
    //sql query
    //version
    //we need only context here and nothing else
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
