package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StergeMasini extends AppCompatActivity {
    Button b;
    EditText nume;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sterge_masini);
        b=findViewById(R.id.StergeMasina);
        nume=findViewById(R.id.MasinaStergere);
        db = new DBHelper(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n= nume.getText().toString().toLowerCase();

                boolean sters=db.stergereMasina(n);
                if(sters)
                {
                    Toast.makeText(StergeMasini.this, "Masina a fost stearsa", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(StergeMasini.this, "Masina nu a fost stearsa", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}