package com.example.myapplication.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.db.LivroDAO;
import com.example.myapplication.model.Livro;

public class Activity_cadastro extends AppCompatActivity {



    private EditText edt_isbn;
    private EditText edt_titulo;
    private EditText edt_autor;
    private LivroDAO dao;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        edt_isbn = findViewById(R.id.edt_isbn);
        edt_titulo = findViewById(R.id.edt_titulo);
        edt_autor = findViewById(R.id.edt_autor);
        dao = new LivroDAO(this);
            }


    public void salvar(View view){
        Livro l = new Livro();
        l.setISBN(Integer.parseInt(edt_isbn.getText().toString()));
        l.setTitulo(edt_titulo.getText().toString());
        l.setAutor(edt_autor.getText().toString());
        long idLivro = dao.insert(l);
        Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
        l.setISBN(Integer.parseInt(""));
        l.setTitulo("");
        l.setAutor("");


    }


    public void retorna(View view) {
        Intent intent = new Intent(Activity_cadastro.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}