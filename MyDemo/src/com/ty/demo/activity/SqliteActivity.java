package com.ty.demo.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ty.demo.R;
import com.ty.demo.base.BaseActivity;
import com.ty.demo.database.SqlDataBase;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/10/28.
 */
public class SqliteActivity extends BaseActivity implements View.OnClickListener {


    @Bind(R.id.create_table)
    Button createTable;
    @Bind(R.id.insert_data)
    Button insertData;
    @Bind(R.id.update_data)
    Button updateData;
    @Bind(R.id.detele_data)
    Button deteleData;
    @Bind(R.id.query_data)
    Button queryData;

    private SqlDataBase mDataBase;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sqlite);
        ButterKnife.bind(this);

        initView();
    }

    @Override
    public void initView() {
        mDataBase = new SqlDataBase(baseContext, "BookStore.db", null, 2);
        createTable.setOnClickListener(this);
        insertData.setOnClickListener(this);
        updateData.setOnClickListener(this);
        deteleData.setOnClickListener(this);
        queryData.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.create_table:
                db = mDataBase.getWritableDatabase();
                break;
            case R.id.insert_data:

                ContentValues cv = new ContentValues();
                cv.put("name", "第一行代码");
                cv.put("author", "郭林");
                cv.put("price", 16.96);
                cv.put("pages", 454);
                db.insert("Book", null, cv);
                cv.clear();
                cv.put("name", "第二行代码");
                cv.put("author", "郭林");
                cv.put("price", 20);
                cv.put("pages", 501);
                db.insert("Book", null, cv);
                break;
            case R.id.update_data:

                ContentValues values = new ContentValues();
                values.put("price", "25");
                db.update("Book", values, "name=?", new String[]{"第一行代码"});

                break;
            case R.id.detele_data:
                db.delete("Book", "name=?", new String[]{"第一行代码"});
                break;

            case R.id.query_data:

                Cursor cursor =db.query("Book",null,null,null,null,null,null);

                if (cursor!=null){

                    while (cursor.moveToNext()){
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                        double price=cursor.getDouble(cursor.getColumnIndex("price"));

                        Log.v("TAG","name="+name+"author="+author+"pages="+pages+"price="+price);
                    }

                }else{
                    Toast.makeText(baseContext,"数据库还没有数据",Toast.LENGTH_SHORT).show();
                }

                cursor.close();

                break;
        }
    }
}
