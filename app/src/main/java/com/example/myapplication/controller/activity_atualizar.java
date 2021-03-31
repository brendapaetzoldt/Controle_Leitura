package com.example.myapplication.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    public void Alterar(View view) {
        if (livro == null) {
            livro = new Livro();
            livro.setTitulo(edt_titulo.getText().toString());
            livro.setAutor(edt_autor.getText().toString());
            livro.setISBN(Integer.parseInt(edt_isbn.getText().toString()));

            long id = dao.insert(livro);
            Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity_atualizar.this, MainActivity.class);
            startActivity(intent);
        } else {
            livro.setTitulo(edt_titulo.getText().toString());
            livro.setAutor(edt_autor.getText().toString());
            livro.setISBN(Integer.parseInt(edt_isbn.getText().toString()));
            dao.atualizar(livro);
            Toast.makeText(this, "Alteração realizada com sucesso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity_atualizar.this, MainActivity.class);
            startActivity(intent);
        }

    }

    public void Excluir(View view) {

        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Atenção").setMessage("Deseja realmente excluir?").setNegativeButton("Não", null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        livros.remove(livro);
                        dao.excluir(livro);
                        Toast.makeText(getApplicationContext(), "Excluído com sucesso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(activity_atualizar.this, MainActivity.class);
                        startActivity(intent);

                    }
                }).create();
        dialog.show();

    }


}