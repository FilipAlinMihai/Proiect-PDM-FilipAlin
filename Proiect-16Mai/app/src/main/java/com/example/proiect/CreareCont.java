package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreareCont extends AppCompatActivity {
    EditText nume,email,parola1,parola2;
    Button buton;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creare_cont);

        nume=findViewById(R.id.editText5);
        email=findViewById(R.id.editText8);
        parola1=findViewById(R.id.editText6);
        parola2=findViewById(R.id.editText7);
        buton=findViewById(R.id.button4);

        db=new DBHelper(this);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num=nume.getText().toString();
                String p1=parola1.getText().toString();
                String p2=parola2.getText().toString();
                String e=email.getText().toString();

                if(p1.compareTo(p2)==0)
                {
                    if(num.length()>5 && p1.length()>5 && email.length()>5)
                    {
                        Boolean reusita=db.inserare(num,e,p1);
                        if(reusita==true)
                        {
                            Toast.makeText(CreareCont.this, "Date Introduse", Toast.LENGTH_SHORT).show();
                            Intent i =new Intent(CreareCont.this,Principal.class);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(CreareCont.this, "Datele nu au fost introduse!", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(CreareCont.this, "Date prea scurte", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(CreareCont.this, "Parola 1 nu este egala cu parola 2", Toast.LENGTH_SHORT).show();
            }
        });
    }
}