package com.example.project.hci_lab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class
Mydatabase extends SQLiteAssetHelper {

   private static final String  DATABASE_NAME="gpdp_databse.db";
   private static final int DATABASE_VERSION=1;

   public Mydatabase(Context context){
       super(context,DATABASE_NAME,null,DATABASE_VERSION);
   }
}
