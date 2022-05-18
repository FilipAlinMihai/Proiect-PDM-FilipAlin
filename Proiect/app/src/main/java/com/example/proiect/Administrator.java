package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Administrator extends AppCompatActivity {
    EditText nume;
    EditText parola;
    Button butonul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);

        butonul=findViewById(R.id.BAutentifAdmin);
        nume=findViewById(R.id.NumeA);
        parola=findViewById(R.id.ParolaA);
        butonul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                String n,p;
                n=nume.getText().toString();
                p=parola.getText().toString();
                if(n.compareTo("Admin")==0 && p.compareTo("Parola")==0) {
                    Intent i = new Intent(Administrator.this, PaginaAdministrator.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(Administrator.this, "Eroare", Toast.LENGTH_SHORT).show();
            }

        });
    }
}