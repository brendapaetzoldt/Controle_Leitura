package com.example.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;
    private static final String TABELA = "livro";
//    private static final String TABELA2 = "avaliacao";

    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table livro(idLivro integer primary key autoincrement, " +
                "ISBN Integer, titulo varchar(50), autor varchar(50))");
//        db.execSQL("create table avaliacao(idLivro integer primary key autoincrement, " +
//                "idAvaliacao Integer, idLivro Livro, dataCompra Date, estrelas double, status varchar(30))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABELA);
//        db.execSQL("drop table if exists " + TABELA2);
        onCreate(db);

    }
}


