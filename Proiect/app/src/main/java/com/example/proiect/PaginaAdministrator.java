package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaginaAdministrator extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_administrator);
        b1=findViewById(R.id.Adauga);
        b2=findViewById(R.id.Sterge);
        b3=findViewById(R.id.Incirieri);
        b4=findViewById(R.id.AfisareMasiniM);
        b5=findViewById(R.id.ModificaNR);
        b6=findViewById(R.id.Asteptare);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(PaginaAdministrator.this,AdaugaMasina.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(PaginaAdministrator.this,StergeMasini.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(PaginaAdministrator.this,AfisareCereri.class);
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 =new Intent(PaginaAdministrator.this,AfisareMasina.class);
                startActivity(i1);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 =new Intent(PaginaAdministrator.this,ModificaMasina.class);
                startActivity(i1);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 =new Intent(PaginaAdministrator.this,CereriInAsteptare.class);
                startActivity(i1);
            }
        });

    }
}