package com.example.giovani.aulabanco;

/**
 * Created by Giovani on 10/05/2017.
 */

public class Contatos {

    private  int _id;
    private  String NOME;
    private String TELEFONE;

    public String getTELEFONE() {
        return TELEFONE;
    }

    public void setTELEFONE(String TELEFONE) {
        this.TELEFONE = TELEFONE;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


}
