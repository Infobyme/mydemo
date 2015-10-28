package com.ty.demo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2015/10/28.
 */
public class SqlDataBase extends SQLiteOpenHelper {

    private static final String CREATE_BOOK="create table Book ("
            +"id integer primary key autoincrement, "
            +"author text ,"
            +"price real ,"
            +"pages integer, "
            +"name text)";

    private static final String CREATE_CATEGORY="create table Category("
            +"id integer primary key autoincrement, "
            +"category_name text, "
            +"category_code integer)";

    public SqlDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.v("TAG","db oncreate");
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.v("TAG","db onUpgrade");
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);

    }
}
