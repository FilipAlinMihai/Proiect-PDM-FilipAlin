package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AfisareMasina extends AppCompatActivity {
    DBHelper db;
    ImageView imagine;
    TextView Masina;
    Button urmatoarea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afisare_masina);
        db = new DBHelper(this);
        Masina=findViewById(R.id.NumeleMasinii);
        imagine=findViewById(R.id.ImagineMasina);
        Cursor cursor= db.getdata2();
        cursor.moveToFirst();

        String nume=cursor.getString(0);
        String prod=cursor.getString(1);
        String pret=cursor.getString(3);
        String nr=cursor.getString(4);
        Masina.setText(nume.toUpperCase()+"\n Produgator "+prod+"\n Disponibile: "+nr+"\n Pret: "+pret );
        byte[] bitmap = cursor.getBlob(5);
        Bitmap image = BitmapFactory.decodeByteArray(bitmap, 0 , bitmap.length);
        imagine.setImageBitmap(image);
        urmatoarea=findViewById(R.id.UrmatoareaMasina);
        urmatoarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursor.moveToNext();
                if(cursor.isAfterLast())
                    cursor.moveToFirst();
                String nume=cursor.getString(0);
                String prod=cursor.getString(1);
                String pret=cursor.getString(3);
                String nr=cursor.getString(4);
                Masina.setText(nume.toUpperCase()+"\n Produgator "+prod+"\n Disponibile: "+nr+"\n Pret: "+pret );
                byte[] bitmap = cursor.getBlob(5);
                Bitmap image = BitmapFactory.decodeByteArray(bitmap, 0 , bitmap.length);
                imagine.setImageBitmap(image);
            }
        });
    }
}