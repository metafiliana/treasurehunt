package edu.upi.cs.treasurehunt;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //insert tabel
        DbCheckpoint db = new DbCheckpoint(getApplicationContext());
        db.open();
        db.insertCheckpoint("bandung","200","100");

        //ambil data tabel
        DbCheckpoint.Checkpoint c = db.getCheckpoint("bandung");
        AlertDialog ad = new AlertDialog.Builder(this).create();
        ad.setMessage("nama="+c.Nama+" longitude="+c.Longitude+" altitude="+c.Altitude);
        ad.show();
    }
}
