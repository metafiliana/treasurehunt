package edu.upi.cs.treasurehunt;

/**
 * Created by metafiliana_X61 on 4/7/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DbCheckpoint {
    public static class Checkpoint{
        public String Nama;
        public String Longitude;
        public String Altitude;
    }

    private SQLiteDatabase db;
    private final OpenHelper dbHelper;

    public DbCheckpoint(Context c){
        dbHelper = new OpenHelper(c);
    }
    public void open(){
        db = dbHelper.getWritableDatabase();
    }
    public void close(){
        db.close();
    }

    public long insertCheckpoint(String nama, String longitude, String altitude){
        ContentValues newValues = new ContentValues();
        newValues.put("NAMA", nama);
        newValues.put("LONGITUDE", longitude);
        newValues.put("ALTITUDE", altitude);
        return db.insert("CHECKPOINT", null, newValues);
    }

    //ambil data checkpoint berdasarkan nama
    public Checkpoint getCheckpoint(String nama){
        Cursor cur = null;
        Checkpoint C = new Checkpoint();

        //kolom yang diambil
        String[] cols = new String[] {"ID", "NAMA", "LONGITUDE", "ALTITUDE"};
        //parameter, akan mengganti ? pada NAMA=?
        String[] param = {nama};

        cur = db.query("CHECKPOINT",cols,"NAMA=?",param,null,null,null);

        if(cur.getCount()>0){ //ada data? ambil
            cur.moveToFirst();
            C.Nama = cur.getString(1);
            C.Longitude = cur.getString(2);
            C.Altitude = cur.getString(3);
        }

        return C;
    }

}
