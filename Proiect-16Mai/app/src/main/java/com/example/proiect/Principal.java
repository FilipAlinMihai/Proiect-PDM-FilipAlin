package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    public Button buton,masini,inchiriere,cereri,cauta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        buton= (Button) findViewById(R.id.button6);
        masini=findViewById(R.id.button5);
        inchiriere=findViewById(R.id.button7);
        cereri=findViewById(R.id.CereriAnterioare);
        cauta=findViewById(R.id.CautaMasina);
        String e= getIntent().getStringExtra("email");
        DBHelper db;
        db = new DBHelper(this);


        buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent i =new Intent(Principal.this,Chestionar.class);
                startActivity(i);
            }

        });

        masini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 =new Intent(Principal.this,AfisareMasina.class);
                startActivity(i1);
            }
        });

        inchiriere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 =new Intent(Principal.this,CerereInciriere.class);
                startActivity(i2);
            }
        });

        cereri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 =new Intent(Principal.this,CereriAnterioare.class);
                i2.putExtra("email",e);
                startActivity(i2);

            }
        });

        cauta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 =new Intent(Principal.this,CautaMasina.class);
                startActivity(i2);
            }
        });
    }
}