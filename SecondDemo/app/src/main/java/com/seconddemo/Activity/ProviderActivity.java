package com.seconddemo.Activity;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.seconddemo.R;

/**
 * Created by Administrator on 2015/10/28.
 */
public class ProviderActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);

        findViewById(R.id.provider_reder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("content://com.tongyang.database.provider/book");
                Cursor cursor=getContentResolver().query(uri,null,null,null,null);
                if (cursor!=null){
                    while (cursor.moveToNext()){

                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                        double price=cursor.getDouble(cursor.getColumnIndex("price"));

                        Log.v("TAG","name="+name+"author="+author+"pages="+pages+"price="+price);

                    }
                    cursor.close();
                }
            }
        });
    }
}
