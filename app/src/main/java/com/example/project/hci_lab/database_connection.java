package com.example.project.hci_lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class database_connection extends SQLiteOpenHelper {




    public database_connection(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super( context, name, factory, version );
        Log.e("database_created","data base created / opened......");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    public void insert_27(SQLiteDatabase db)
    {
        ContentValues contentValues=new ContentValues(  );
        contentValues.put( "","" );
        contentValues.put( "","" );
       // db.insert( "","" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
