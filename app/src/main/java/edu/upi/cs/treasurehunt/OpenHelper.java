package edu.upi.cs.treasurehunt;

/**
 * Created by metafiliana_X61 on 4/7/2016.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dbTreasure.db";
    public static final String TABLE_CREATE =
            "CREATE TABLE CHECKPOINT (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAMA TEXT, LONGITUDE TEXT, ALTITUDE TEXT);" +
                    "CREATE TABLE SCORE (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAMA TEXT, SCORE TEXT";

    public OpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        //create database
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //deteksi tabel data, create baru kalo diupgrade appsnya
        db.execSQL("DROP TABLE IF EXIST CHECKPOINT");
        db.execSQL("DROP TABLE IF EXIST SCORE");
    }
}
