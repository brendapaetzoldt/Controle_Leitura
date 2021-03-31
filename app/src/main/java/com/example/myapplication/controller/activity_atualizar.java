package com.example.myapplication.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.db.LivroDAO;
import com.example.myapplication.model.Livro;

import java.util.List;

public class activity_atualizar extends AppCompatActivity {

    private LivroDAO dao;
    private List<Livro> livros;
    private Livro livro = null;
    private EditText edt_titulo;
    private EditText edt_autor;
    private EditText edt_isbn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar);

        dao = new LivroDAO(getApplicationContext());
        livros = dao.selectAll();

        Intent intent = getIntent();

        if (intent.hasExtra("livro")) {
            livro = (Livro) intent.getSerializableExtra("livro");
        }

        edt_autor = findViewById(R.id.edt_autor);
        edt_titulo = findViewById(R.id.edt_titulo);
        edt_isbn = findViewById(R.id.edt_isbn);

        edt_titulo.setText(livro.getTitulo());
        edt_autor.setText(livro.getAutor());
        edt_isbn.setText(Integer.toString(livro.getISBN()));

    }



}