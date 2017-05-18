package com.example.giovani.aulabanco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText edtnome;//vincula
    EditText edtTelefone;


    Contatos contatos;
    ContatosDB contatosDB;//instancia


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtnome = (EditText) findViewById(R.id.editNome);
        edtTelefone = (EditText) findViewById(R.id.editFone);

        contatosDB = new ContatosDB(this);

    }

    public void Inserir(View v) {

        try {

            contatos = new Contatos();
            contatos.setNOME(edtnome.getText().toString());
            contatos.setTELEFONE(edtTelefone.getText().toString());

            contatosDB.inserir(contatos);
            Toast.makeText(MainActivity.this,"SALVO COM SUCESSO",Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(MainActivity.this,"OCORREU UM ERRO",Toast.LENGTH_SHORT).show();
        }
    }
    public void Listar(View v){
        Intent intent = new Intent(this,ListaContatos.class);
        startActivity(intent);
    }
}
