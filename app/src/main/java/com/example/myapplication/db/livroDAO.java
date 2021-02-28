package com.example.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class livroDAO {

    private Conexao conecao;
    private SQLiteDatabase banco;

    public livroDAO(Context context) {
        conecao = new Conexao(context);
        banco = conecao.getWritableDatabase();
    }




}
