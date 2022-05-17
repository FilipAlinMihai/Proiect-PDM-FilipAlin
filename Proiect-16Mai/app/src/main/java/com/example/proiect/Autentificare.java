package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Autentificare extends AppCompatActivity {
    public Button buton;
    EditText email,parola;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autentificare);
        buton= (Button) findViewById(R.id.button3);
        email=findViewById(R.id.editText3);
        parola=findViewById(R.id.editText4);
        db=new DBHelper(this);

        buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                String em=email.getText().toString();
                String p=parola.getText().toString();

                Cursor c=db.getdata();
                if(c.getCount()==0) {
                    Toast.makeText(Autentificare.this, "Fara Date", Toast.LENGTH_SHORT).show();
                    return ;
                }
                StringBuffer buf= new StringBuffer();
                boolean gasit=false;
                while(c.moveToNext())
                {
                  if(em.compareTo(c.getString(1))==0 && p.compareTo(c.getString(2))==0)
                      gasit=true;
                }
                if(gasit)
                {
                    Intent i = new Intent(Autentificare.this, Principal.class);
                    i.putExtra("email",em);
                    startActivity(i);
                }
                else
                    Toast.makeText(Autentificare.this, "Date Invalide", Toast.LENGTH_SHORT).show();
            }

        });
    }
}