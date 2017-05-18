package com.example.giovani.aulabanco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Giovani on 10/05/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Agenda"; //varivel para nome do banco de dados
    private static final int  DATABASE_VERSION = 1;//VERSAO
    private static String TABLE_CONTATOS = " CREATE TABLE CONTATOS ("+ "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "NOME TEXT, TELEFONE TEXT);";//comando para criacao da tabela

    DataBaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);//construtor do banco
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CONTATOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE CONTATOS;");
        onCreate(db);
    }
}
