package com.example.myapplication.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
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
    private RatingBar ratingBar;
    private Boolean verdade;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar);

        ratingBar = findViewById(R.id.ratingBar);
        radioButton = findViewById(R.id.radioButton);

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

        if (radioButton.isSelected()) {
            verdade = true;
        } else {
            verdade = false;
        }

    }


    public void Alterar(View view) {
        if (livro == null) {
            livro = new Livro();
            livro.setTitulo(edt_titulo.getText().toString());
            livro.setAutor(edt_autor.getText().toString());
            livro.setISBN(Integer.parseInt(edt_isbn.getText().toString()));
            livro.setEstrelas(ratingBar.getRating());
            livro.setFav(check());
            long id = dao.insert(livro);
            Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity_atualizar.this, MainActivity.class);
            startActivity(intent);
        } else {
            livro.setTitulo(edt_titulo.getText().toString());
            livro.setAutor(edt_autor.getText().toString());
            livro.setISBN(Integer.parseInt(edt_isbn.getText().toString()));
            livro.setEstrelas(ratingBar.getRating());
            livro.setFav(verdade);

            dao.atualizar(livro);
            Toast.makeText(this, "Alteração realizada com sucesso" + check(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity_atualizar.this, MainActivity.class);
            startActivity(intent);
        }

    }

    public boolean check() {
        if(radioButton.isSelected()){
        return true;
        }
        return false;


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

    public void retorna(View view) {
        Intent intent = new Intent(activity_atualizar.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}