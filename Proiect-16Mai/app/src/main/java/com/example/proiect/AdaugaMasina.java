package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Locale;

public class AdaugaMasina extends AppCompatActivity {
    Button adauga;
    EditText nume,producator,tip,pret,numar,perf,conf,agil,teren,depozitare;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_masina);
        adauga= findViewById(R.id.AdaugaMasina);
        nume=findViewById(R.id.NumeMasina);
        producator=findViewById(R.id.Producator);
        tip=findViewById(R.id.Tip);
        pret=findViewById(R.id.Pret);
        numar=findViewById(R.id.Numar);
        perf=findViewById(R.id.Performanta);
        conf=findViewById(R.id.Confort);
        agil=findViewById(R.id.Agilitate);
        teren=findViewById(R.id.Teren);
        depozitare=findViewById(R.id.Depozitare);
        DB = new DBHelper(this);
        adauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = nume.getText().toString().toLowerCase();
                String p = producator.getText().toString();
                String t = tip.getText().toString();
                int pre= Integer.parseInt(pret.getText().toString());
                int num= Integer.parseInt(numar.getText().toString());
                int per= Integer.parseInt(perf.getText().toString());
                int con= Integer.parseInt(conf.getText().toString());
                int agilitate= Integer.parseInt(agil.getText().toString());
                int ter= Integer.parseInt(teren.getText().toString());
                int depoz= Integer.parseInt(depozitare.getText().toString());

                int resourceId = getResources().getIdentifier(x, "drawable", getPackageName());
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),resourceId);
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArray);
                byte[] img = byteArray.toByteArray();

                boolean insert = DB.inserareMasina(x,p,t,pre,num,img,per,con,agilitate,ter,depoz);
                if(insert==true){
                    Toast.makeText(AdaugaMasina.this, "Data Saved", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AdaugaMasina.this, "Data Not Saved",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}