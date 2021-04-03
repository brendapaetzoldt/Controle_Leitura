package com.example.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "bd.db";
    private static final int version = 2;
    private static final String TABELA = "livro";

    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table livro(ISBN Integer  primary key , titulo varchar(50), autor varchar(50),dataCompra Date, estrelas Double, status String, fav Boolean)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABELA);
        onCreate(db);

    }
}


