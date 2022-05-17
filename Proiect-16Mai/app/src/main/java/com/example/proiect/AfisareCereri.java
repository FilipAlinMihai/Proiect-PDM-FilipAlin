package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class AfisareCereri extends AppCompatActivity {
    TextView cereri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afisare_cereri);
        cereri=findViewById(R.id.CereriInchiriere);

        String s="Cererile sunt :\n*";
        DBHelper db;
        db = new DBHelper(this);

        Cursor cursor= db.getdata3();
        cursor.moveToFirst();
        int max1=0;
        while(!cursor.isAfterLast())
        {
            String m=cursor.getString(0);
            String e=cursor.getString(1);
            String d=cursor.getString(2);
            String stat=cursor.getString(3);
            String id=cursor.getString(4);
            s=s+"Masina: "+m.toUpperCase()+"\nClient: "+e+"\nData: "+d+" Status : "+stat+"\nID: "+id+"\n*";
            cursor.moveToNext();
        }
        cereri.setText(s);
    }
}