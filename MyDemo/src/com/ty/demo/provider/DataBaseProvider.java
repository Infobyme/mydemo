package com.ty.demo.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Switch;

import com.ty.demo.database.SqlDataBase;

/**
 * Created by Administrator on 2015/10/28.
 */
public class DataBaseProvider extends ContentProvider {

    private static final int BOOK_DIR=0;
    private static final int BOOK_ITEM=1;

    private static final int CATGORY_DIR=0;
    private static final int CATGORY_ITEM=1;

    private static final String AUTHORITY="com.tongyang.database.provider";
    private static UriMatcher uriMatcher;

    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"book",BOOK_DIR);
        uriMatcher.addURI(AUTHORITY,"book/#",BOOK_ITEM);
        uriMatcher.addURI(AUTHORITY,"category",CATGORY_DIR);
        uriMatcher.addURI(AUTHORITY,"category/#",CATGORY_ITEM);
    }

    private SqlDataBase sqd;

    @Override
    public boolean onCreate() {
        sqd=new SqlDataBase(getContext(),"BookStore.db", null, 2);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        Log.v("TAG","query");
        SQLiteDatabase db=sqd.getReadableDatabase();

        Cursor cursor=null;

        int type=uriMatcher.match(uri);
        switch (type){
            case  BOOK_DIR:
                cursor=db.query("book",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case BOOK_ITEM:
                String bookId=uri.getPathSegments().get(1);
                cursor= db.query("book",projection,"id=?",new String[]{bookId},null,null,sortOrder);
                break;
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                return "vnd.android.cursor.dir/vnd.com.tongyang.database.provider.book";
            case BOOK_ITEM:
                return "vnd.android.cursor.item/vnd.com.tongyang.database.provider.book";
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
