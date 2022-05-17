package com.example.proiect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper( Context context) {
        super(context, "InchiriereMasini5.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table utilizatori(nume Text,Email Text primary key,parola Text)");
        DB.execSQL("create Table masini(Nume Text,Producator Text,Tip Text,Pret Int,Numar Int, Imagine blob,Performanta Int , Confort Int , Agilitate Int, Teren Int, Depozitare Int)");
        DB.execSQL("create Table inchiriere(numeMasina Text,Email Text ,Data Text,Statut Text,ID int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists utilizatori");
        DB.execSQL("drop Table if exists masini");
        DB.execSQL("drop Table if exists inchiriere");
    }
    public Boolean inserareMasina (String nume , String prod , String tip,int pret, int numar , byte[] img, int perfo,int conf,int agil , int teren ,int depozitare)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues continut= new ContentValues();
        continut.put("Nume",nume);
        continut.put("Producator",prod);
        continut.put("Tip",tip);
        continut.put("Pret",pret);
        continut.put("Numar",numar);
        continut.put("Imagine",img);
        continut.put("Performanta",perfo);
        continut.put("Confort",conf);
        continut.put("Agilitate",agil);
        continut.put("Teren",teren);
        continut.put("Depozitare",depozitare);
        long rez= DB.insert("masini",null , continut);
        if(rez==-1)
        {
            return false;
        }
        return true;
    }
    public Boolean inserare (String nume , String email , String parola)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues continut= new ContentValues();
        continut.put("nume",nume);
        continut.put("email",email);
        continut.put("parola",parola);
        long rez= DB.insert("utilizatori",null , continut);
        if(rez==-1)
        {
            return false;
        }
        return true;
    }

    public Boolean inserareInchiriere (String nume , String email )
    {
        Date d=new Date();
        int id=1;
        id=generareCod();
       SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues continut= new ContentValues();
        continut.put("numeMasina",nume);
        continut.put("Email",email);
        continut.put("Data", format.format(d));
        continut.put("Statut", "Asteptare");
        continut.put("ID", id);
        long rez= DB.insert("inchiriere",null , continut);


        if(rez==-1)
        {
            return false;
        }
        return true;
    }


    public Boolean modificare (String nume , String email , String parola)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues continut= new ContentValues();
        continut.put("nume",nume);
        continut.put("parola",parola);

        Cursor c= DB.rawQuery("Select * from utilizatori where email = ?", new String[]{email});
        if(c.getCount()>0) {
            long rez = DB.update("utilizatori", continut, "email=?", new String[]{email});
            if (rez == -1) {
                return false;
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    public Boolean stergere ( String email)
    {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor c= DB.rawQuery("Select * from utilizatori where email = ?", new String[]{email});
        if(c.getCount()>0) {
            long rez = DB.delete("utilizatori","email=?", new String[]{email});
            if (rez == -1) {
                return false;
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean stergereMasina ( String nume)
    {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor c= DB.rawQuery("Select * from masini where Nume = ?", new String[]{nume});
        if(c.getCount()>0) {
            long rez = DB.delete("masini","Nume=?", new String[]{nume});
            if (rez == -1) {
                return false;
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor c= DB.rawQuery("Select * from utilizatori",null);
        return c;
    }
    public Cursor getdata2 ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor c= DB.rawQuery("Select * from masini",null);
        return c;
    }
    public Cursor getdata3()
    {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor c= DB.rawQuery("Select * from inchiriere",null);
        return c;
    }

    public Cursor getdata5()
    {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor c= DB.rawQuery("Select * from inchiriere where Statut='Asteptare'",null);
        return c;
    }

    public boolean modificaNr (String m,int nr)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        try{
            DB.execSQL("UPDATE masini SET Numar="+nr+" WHERE Nume='"+m+"'");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int generareCod()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        int i=1;
        boolean da=true;
        String s="";
        while(i<=1000 && da) {
            Cursor c = DB.rawQuery("Select * from inchiriere", null);
            c.moveToFirst();
            da=false;


            int a=0;
            if(c.isAfterLast())
                return 1;

            while(!c.isAfterLast())
            {
                a=Integer.parseInt(c.getString(4));
                s=s+" "+a;
                if(a==i) {
                    da = true;
                    i++;
                }
                c.moveToNext();
            }


        }

        return i;
    }


    public boolean aproba (int id)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        try{
            DB.execSQL("UPDATE inchiriere SET Statut='Aprobata' WHERE ID="+id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean respinge (int id)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        try{
            DB.execSQL("UPDATE inchiriere SET Statut='Respinsa' WHERE ID="+id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
