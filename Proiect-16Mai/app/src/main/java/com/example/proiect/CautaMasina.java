package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class CautaMasina extends AppCompatActivity {
    EditText nume;
    ImageView imagine;
    Button b;
    TextView date;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cauta_masina);

        date=findViewById(R.id.DateMasina);
        b=findViewById(R.id.Cauta);
        imagine=findViewById(R.id.RezultatCautare);
        nume=findViewById(R.id.MasinaCautata);
        db=new DBHelper(this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=nume.getText().toString().toLowerCase();
                n=n.toUpperCase();
                Cursor c= db.getdata2();
                boolean gasit=false;
                String d="";
                byte[] bitmap=null;
                Bitmap image=null;
                while(c.moveToNext())
                {
                    String s=c.getString(0);
                    s=s.toUpperCase();
                    if(s.compareTo(n)==0) {
                        gasit = true;
                        d="Pret: "+c.getString(3)+"\n Disponibile: "+c.getString(4);
                        bitmap = c.getBlob(5);
                        image = BitmapFactory.decodeByteArray(bitmap, 0 , bitmap.length);
                    }
                }
               if(gasit){
                   imagine.setImageBitmap(image);
                   date.setText(d);
               }
               else
               {
                   int resourceId = getResources().getIdentifier("eroare", "drawable", getPackageName());
                   Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),resourceId);
                   imagine.setImageBitmap(bitmap1);
                   date.setText("EROARE");
               }

            }
        });
    }
}