package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.myapplication.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private Conexao conecao;
    private SQLiteDatabase banco;

    public LivroDAO(Context context) {
        conecao = new Conexao(context);
        banco = conecao.getWritableDatabase();
    }

    public long insert(Livro livro) {
        ContentValues values = new ContentValues();
        values.put("isbn", livro.getISBN());
        values.put("titulo", livro.getTitulo());
        values.put("autor", livro.getAutor());
        return banco.insert("livro", null, values);


    }

    public List<Livro> selectAll() {
        List<Livro> livros = new ArrayList<>();
        Cursor cursor = banco.query("livro", new String[]{"id", "isbn", "titulo", "autor"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            Livro l = new Livro();
            l.setIdLivro(cursor.getInt(0));
            l.setISBN(cursor.getInt(1));
            l.setAutor(cursor.getString(2));
            l.setAutor(cursor.getString(3));
            livros.add(l);

        }
        return livros;
    }


}
