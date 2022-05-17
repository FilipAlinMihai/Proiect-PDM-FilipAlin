package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CerereInciriere extends AppCompatActivity {
    Button b;
    EditText em,pa,ma;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerere_inciriere);
        b=findViewById(R.id.Inciriaza);
        em=findViewById(R.id.Email);
        pa=findViewById(R.id.Parola);
        ma=findViewById(R.id.MasinaDorida);
        db = new DBHelper(this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor= db.getdata();
                String e= em.getText().toString();
                String p= pa.getText().toString();
                String m= ma.getText().toString().toLowerCase();
                boolean gasitu=false;
                boolean gasitm=false;
                cursor.moveToFirst();
                while(!cursor.isAfterLast())
                {
                    String email=cursor.getString(1);
                    String parola=cursor.getString(2);
                    if(email.compareTo(e)==0 && parola.compareTo(p)==0)
                        gasitu=true;
                    cursor.moveToNext();
                }
                Cursor cursor1= db.getdata2();
                cursor1.moveToFirst();
                while(!cursor1.isAfterLast())
                {
                    String nume=cursor1.getString(0);
                    if(nume.compareTo(m)==0 )
                        gasitm=true;
                    cursor1.moveToNext();
                }
                if(gasitm && gasitu)
                {
                    boolean insert = db.inserareInchiriere(m,e);
                    if(insert==true){
                        Toast.makeText(CerereInciriere.this, "Data Saved", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(CerereInciriere.this, "Data Not Saved "+insert ,
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(CerereInciriere.this, "Nu am gasit datele", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}