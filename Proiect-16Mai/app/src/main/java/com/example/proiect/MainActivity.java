package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button buton;
    public Button buton1;
    public Button buton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buton= (Button) findViewById(R.id.button);
        buton1= (Button) findViewById(R.id.button2);
        buton2= (Button) findViewById(R.id.button3);
        DBHelper db;
        db = new DBHelper(this);

        buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent i =new Intent(MainActivity.this,CreareCont.class);
                startActivity(i);
//                int x=db.generareCod();
//                Toast.makeText(MainActivity.this, String.valueOf(x), Toast.LENGTH_SHORT).show();
            }

        });
        buton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent i =new Intent(MainActivity.this,Autentificare.class);
                startActivity(i);
            }

        });
        buton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent i =new Intent(MainActivity.this,Administrator.class);
                startActivity(i);
            }

        });
    }
}
