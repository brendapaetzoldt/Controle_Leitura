package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.model.Livro;

public class LivroDAO {

    private Conexao conecao;
    private SQLiteDatabase banco;

    public LivroDAO(Context context) {
        conecao = new Conexao(context);
        banco = conecao.getWritableDatabase();
    }

    public long insert(Livro livro){
        ContentValues values = new ContentValues();
        values.put("isbn", livro.getISBN());
        values.put("titulo", livro.getTitulo());
        values.put("autor", livro.getAutor());
        return banco.insert("livro", null, values);

    }




}
