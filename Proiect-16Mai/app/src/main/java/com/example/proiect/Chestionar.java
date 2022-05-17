package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Chestionar extends AppCompatActivity {
    Button raspunde;
    RadioGroup q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15;
    String mesaj;
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15;
    TextView rezultat;
    int performanta=0, confort=0 , agilitate=0,teren=0,depozitare=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chestionar);
        raspunde=findViewById(R.id.Raspunde);
        q1=findViewById(R.id.grup1);
        q2=findViewById(R.id.grup2);
        q3=findViewById(R.id.grup3);
        q4=findViewById(R.id.grup4);
        q5=findViewById(R.id.grup5);
        q6=findViewById(R.id.grup6);
        q7=findViewById(R.id.grup7);
        q8=findViewById(R.id.grup8);
        q9=findViewById(R.id.grup9);
        q10=findViewById(R.id.grup10);
        q11=findViewById(R.id.grup11);
        q12=findViewById(R.id.grup12);
        q13=findViewById(R.id.grup13);
        q14=findViewById(R.id.grup14);
        q15=findViewById(R.id.grup15);
        rezultat=findViewById(R.id.Rezultate);
        q1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r1 = group.findViewById(checkedId);
            }
        });
        q2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r2 = group.findViewById(checkedId);
            }
        });

        q3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r3 = group.findViewById(checkedId);
            }
        });
        q4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r4 = group.findViewById(checkedId);
            }
        });
        q5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r5 = group.findViewById(checkedId);
            }
        });
        q6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r6 = group.findViewById(checkedId);
            }
        });
        q7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r7 = group.findViewById(checkedId);
            }
        });
        q8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r8 = group.findViewById(checkedId);
            }
        });
        q9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r9 = group.findViewById(checkedId);
            }
        });
        q10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r10 = group.findViewById(checkedId);
            }
        });
        q11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r11 = group.findViewById(checkedId);
            }
        });
        q12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r12 = group.findViewById(checkedId);
            }
        });
        q13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r13 = group.findViewById(checkedId);
            }
        });
        q14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r14 = group.findViewById(checkedId);
            }
        });
        q15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 r15 = group.findViewById(checkedId);
            }
        });

        raspunde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s=r1.getText().toString();
                if(s.compareTo("Deloc")==0)
                    confort=confort+10;
                else if(s.compareTo("Putin")==0)
                    agilitate=agilitate+10;
                else if(s.compareTo("Destul de mult")==0)
                    performanta=performanta+10;
                else
                    performanta=performanta+20;

                s=r2.getText().toString();
                if(s.compareTo("Deloc")==0)
                    agilitate=agilitate+10;
                else if(s.compareTo("Putin")==0)
                    confort=confort+10;
                else if(s.compareTo("Destul de mult")==0)
                    depozitare=depozitare+10;
                else
                    depozitare=depozitare+20;

                s=r3.getText().toString();
                if(s.compareTo("Deloc")==0)
                    confort=confort+10;
                else if(s.compareTo("Putin")==0)
                    agilitate=agilitate+10;
                else if(s.compareTo("Destul de mult")==0)
                    teren=teren+10;
                else
                    teren=teren+20;

                s=r4.getText().toString();
                if(s.compareTo("Deloc")==0)
                    confort=confort+10;
                else if(s.compareTo("Putin")==0)
                    agilitate=agilitate+10;
                else if(s.compareTo("Destul de mult")==0)
                    performanta=performanta+10;
                else
                    performanta=performanta+20;

                s=r5.getText().toString();
                if(s.compareTo("DA")==0) {
                    teren=teren+10;
                    depozitare=depozitare+10;
                }
                else {
                    confort = confort + 10;
                }

                s=r6.getText().toString();
                if(s.compareTo("DA")==0) {
                    teren=teren+10;
                    depozitare=depozitare+10;
                }
                else {
                    confort = confort + 10;
                    agilitate=agilitate+10;
                }

                s=r7.getText().toString();
                if(s.compareTo("Deloc")==0)
                    performanta=performanta+10;
                else if(s.compareTo("Putin")==0)
                    confort=confort+10;
                else if(s.compareTo("Destul de mult")==0)
                    depozitare=depozitare+10;
                else
                    agilitate=agilitate+10;

                s=r8.getText().toString();
                if(s.compareTo("Deloc")==0)
                    confort=confort+10;
                else if(s.compareTo("Putin")==0)
                    agilitate=agilitate+10;
                else if(s.compareTo("Destul de mult")==0)
                    performanta=performanta+10;
                else
                    performanta=performanta+20;

                s=r9.getText().toString();
                if(s.compareTo("Deloc")==0)
                    performanta=performanta+10;
                else if(s.compareTo("Putin")==0)
                    agilitate=agilitate+10;
                else if(s.compareTo("Destul de mult")==0)
                    depozitare=depozitare+10;
                else
                    agilitate=agilitate+20;

                s=r10.getText().toString();
                if(s.compareTo("Deloc")==0)
                    confort=confort+10;
                else if(s.compareTo("Putin")==0)
                    teren=teren+10;
                else if(s.compareTo("Destul de mult")==0)
                    performanta=performanta+10;
                else
                    performanta=performanta+20;

                s=r11.getText().toString();
                if(s.compareTo("Deloc")==0) {
                    performanta = performanta + 10;
                    teren = teren + 10;
                }
                else if(s.compareTo("Putin")==0) {
                    performanta=performanta+10;
                }
                else if(s.compareTo("Destul de mult")==0)
                    confort=confort+10;
                else
                    confort=confort+20;

                s=r12.getText().toString();
                if(s.compareTo("Deloc")==0)
                    confort=confort+10;
                else if(s.compareTo("Putin")==0)
                    teren=teren+10;
                else if(s.compareTo("Destul de mult")==0)
                    performanta=performanta+10;
                else
                    performanta=performanta+20;

                s=r13.getText().toString();
                if(s.compareTo("Urban")==0)
                    agilitate=agilitate+10;
                else if(s.compareTo("Mixt(predominant urban)")==0)
                    confort=confort+10;
                else if(s.compareTo("Mixt(predominant rural)")==0)
                    teren=teren+10;
                else
                    teren=teren+20;

                s=r14.getText().toString();
                if(s.compareTo("DA")==0)
                    performanta=performanta+10;
                else
                    confort=confort+10;

                s=r15.getText().toString();
                if(s.compareTo("DA")==0)
                    agilitate=agilitate+10;
                else
                    confort=confort+10;
                mesaj=""+performanta+" "+confort+" "+agilitate+" "+teren+" "+depozitare;

                int max1=0,max2=0;
                int calitate1=0,calitate2=0;

                ArrayList<Integer> rezultate= new ArrayList<Integer>();
                ArrayList<Integer> rezultate1= new ArrayList<Integer>();
                rezultate1.add(performanta);
                rezultate1.add(confort);
                rezultate1.add(agilitate);
                rezultate1.add(teren);
                rezultate1.add(depozitare);

                for(int i:rezultate1)
                {
                    if(i>max1)
                        max1=i;
                }
                int ok=1;
                for(int i:rezultate1)
                {
                    if(i==max1 && ok==1)
                        ok=0;
                    else
                        rezultate.add(i);
                }
                for(int i:rezultate)
                {
                    if(i>max2)
                        max2=i;
                }
                 if(max1==performanta)
                     calitate1=6;
                 else if(max1==confort)
                     calitate1=7;
                 else if(max1==agilitate)
                     calitate1=8;
                 else if(max1==teren)
                     calitate1=9;
                 else if(max1==depozitare)
                     calitate1=10;


                if(max2==performanta && calitate1!=6)
                    calitate2=6;
                else if(max2==confort && calitate1!=7)
                    calitate2=7;
                else if(max2==agilitate && calitate1!=8)
                    calitate2=8;
                else if(max2==teren && calitate1!=9)
                    calitate2=9;
                else if(max1==depozitare && calitate1!=10)
                    calitate2=10;
                //rezultat.setText(mesaj);
               String m1= gasesteMasini(calitate1);
               String m2= gasesteMasini(calitate2);

               String afisare="";
               afisare=m1+" "+m2;
                rezultat.setText(afisare);
            }
        });
    }

    public String gasesteMasini(int c1)
    {
        String s="";
        DBHelper db;
        db = new DBHelper(this);

        Cursor cursor= db.getdata2();
        cursor.moveToFirst();
        int max1=0;
        while(!cursor.isAfterLast())
        {
            String nume=cursor.getString(0);
            String prod=cursor.getString(1);
            int calitate1=cursor.getInt(c1);
            if(max1<calitate1) {
                max1 = calitate1;
                s=prod+" "+nume;
            }
            cursor.moveToNext();
        }
        return s.toUpperCase();
    }
}