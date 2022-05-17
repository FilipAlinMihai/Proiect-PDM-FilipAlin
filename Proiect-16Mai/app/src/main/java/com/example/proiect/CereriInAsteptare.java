package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CereriInAsteptare extends AppCompatActivity {
    Button b1,b2,b3;
    DBHelper db;
    TextView Mesaj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cereri_in_asteptare);
        b1=findViewById(R.id.UrmatoareaCerere);
        b2=findViewById(R.id.Aprobare);
        b3=findViewById(R.id.Respinge);
        db = new DBHelper(this);
        Cursor cursor= db.getdata5();
        cursor.moveToFirst();
        Mesaj=findViewById(R.id.DateInchiriere);
        if(cursor.isAfterLast())
            Mesaj.setText("Final!");
        else{
        String nume=cursor.getString(0);
        String pers=cursor.getString(1);
        String data=cursor.getString(2);
            String stat=cursor.getString(3);
            String id=cursor.getString(4);
        Mesaj.setText("Masina: "+nume.toUpperCase()+"\n Client: "+pers+"\n Data: "+data+"\n Status : "+stat+"\nID: "+id);}

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursor.moveToNext();
                if(cursor.isAfterLast())
                    Mesaj.setText("Final!");
                else
                {
                    String nume=cursor.getString(0);
                    String pers=cursor.getString(1);
                    String data=cursor.getString(2);
                    String stat=cursor.getString(3);
                    String id=cursor.getString(4);
                    Mesaj.setText("Masina: "+nume.toUpperCase()+"\n Client: "+pers+"\n Data: "+data+" Status : "+stat+"\nID: "+id);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(cursor.getString(4));
              boolean rez =db.aproba(id);
              if(rez){
                  Toast.makeText(CereriInAsteptare.this, "Succes", Toast.LENGTH_SHORT).show();
              }
              else
              {
                  Toast.makeText(CereriInAsteptare.this, "Esec", Toast.LENGTH_SHORT).show();
              }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(cursor.getString(4));
                boolean rez =db.respinge(id);
                if(rez){
                    Toast.makeText(CereriInAsteptare.this, "Succes", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(CereriInAsteptare.this, "Esec", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}