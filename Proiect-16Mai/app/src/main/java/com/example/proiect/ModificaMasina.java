package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModificaMasina extends AppCompatActivity {
    Button b;
    EditText nr,nume;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_masina);
        b=findViewById(R.id.Modifica);
        nr=findViewById(R.id.NumarNou);
        nume=findViewById(R.id.NumeMasinaEdit);
        db=new DBHelper(this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m=nume.getText().toString().toLowerCase();
                int n=Integer.parseInt(nr.getText().toString());

                if(db.modificaNr(m,n))
                {
                    Toast.makeText(ModificaMasina.this, "Numar Modificat", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ModificaMasina.this, "Eroare la modificare", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}