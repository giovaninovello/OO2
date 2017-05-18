package com.example.giovani.aulabanco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Giovani on 10/05/2017.
 */

public class ContatosDB {

    private SQLiteDatabase sqLiteDB;

    public ContatosDB(Context context){
        sqLiteDB = new DataBaseHelper(context).getWritableDatabase();
    }


    public void inserir(Contatos contatos)throws  Exception{
        ContentValues  valores = new ContentValues();

        valores.put("NOME",contatos.getNOME());
        valores.put("TELEFONE",contatos.getTELEFONE());

        sqLiteDB.insert("CONTATOS",null,valores);

    }




    public List<Contatos> listar(){
        List<Contatos> list = new ArrayList<>();

        String[] colunas = new String[]{"_id","NOME","TELEFONE"};
        Cursor cursor = sqLiteDB.query("CONTATOS",colunas,null,null,null,null,"NOME ASC");

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                Contatos contato = new Contatos();
                contato.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
                contato.setNOME(cursor.getString(cursor.getColumnIndex("NOME")));
                contato.setTELEFONE(cursor.getString(cursor.getColumnIndex("TELEFONE")));

                list.add(contato);
            }while (cursor.moveToNext());

        }
        return list;
    }




//METODOS PARA FAZER EM AULA
    public List<Contatos> buscar(String NOME){
        List<Contatos> list = new ArrayList<>();

        String[] colunas = new String[]{"_id","NOME","TELEFONE"};
        String  where = "nome=?";
        String [] argumemtos =  new String[]{NOME};
        Cursor cursor = sqLiteDB.query("CONTATOS",colunas,where,argumemtos,null,null,"NOME ASC");

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                Contatos contato = new Contatos();
                contato.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
                contato.setNOME(cursor.getString(cursor.getColumnIndex("NOME")));
                contato.setTELEFONE(cursor.getString(cursor.getColumnIndex("TELEFONE")));

                list.add(contato);
            }while (cursor.moveToNext());

        }
        return list;
    }



    public void atualizar(Contatos contatos) throws Exception{
        String where = "_id=?";
        String [] argumentos = new String[]{""+contatos.get_id()};

        ContentValues valores = new ContentValues();
        valores.put("NOME",contatos.getNOME());
        valores.put("TELEFONE",contatos.getTELEFONE());

        sqLiteDB.update("contatos",valores,where,argumentos);
    }




    public void deletar(Contatos contatos )throws  Exception{

        String where = "_id=?";
        String[] argumentos = new String[]{""+contatos.get_id()};
        sqLiteDB.delete("contatos",where,argumentos);
    }
}
