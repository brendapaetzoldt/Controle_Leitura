package com.example.myapplication.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.db.LivroDAO;
import com.example.myapplication.model.Livro;
import com.google.common.primitives.Chars;

import java.util.List;

public class activity_atualizar extends AppCompatActivity {

    private LivroDAO dao;
    private List<Livro> livros;
    private Livro livro = null;
    private EditText edt_titulo, edt_date;
    private EditText edt_autor;
    private EditText edt_isbn;
    private RatingBar ratingBar;
    private Spinner spinner_status;
    private String selectedItemText;
    private TextView textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar);

        ratingBar = findViewById(R.id.ratingBar);

        dao = new LivroDAO(getApplicationContext());
        livros = dao.selectAll();

        Intent intent = getIntent();

        if (intent.hasExtra("livro")) {
            livro = (Livro) intent.getSerializableExtra("livro");
        }

        edt_autor = findViewById(R.id.edt_autor);
        edt_titulo = findViewById(R.id.edt_titulo);
        edt_isbn = findViewById(R.id.edt_isbn);
        edt_date = findViewById(R.id.edt_date);
        ratingBar = findViewById(R.id.ratingBar);
        spinner_status = findViewById(R.id.spinner_status);
        textView4 = findViewById(R.id.textView4);

        edt_titulo.setText(livro.getTitulo());
        edt_autor.setText(livro.getAutor());
        edt_isbn.setText(Integer.toString(livro.getISBN()));
        edt_date.setText(livro.getDataCompra());
        ratingBar.setNumStars((int) livro.getEstrelas());
        textView4.setText(livro.getStatus());

        Spinner spinner_status = findViewById(R.id.spinner_status);

        final ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.status, android.R.layout.simple_spinner_dropdown_item);
        spinner_status.setAdapter(adapter);

        spinner_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItemText = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void Alterar(View view) {
        if (livro == null) {
            livro = new Livro();
            livro.setTitulo(edt_titulo.getText().toString());
            livro.setAutor(edt_autor.getText().toString());
            livro.setISBN(Integer.parseInt(edt_isbn.getText().toString()));
            livro.setDataCompra(edt_date.getText().toString());
            livro.setEstrelas(ratingBar.getRating());
            livro.setStatus(selectedItemText);
            long id = dao.insert(livro);
            Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity_atualizar.this, MainActivity.class);
            startActivity(intent);
        } else {
            livro.setTitulo(edt_titulo.getText().toString());
            livro.setAutor(edt_autor.getText().toString());
            livro.setISBN(Integer.parseInt(edt_isbn.getText().toString()));
            livro.setDataCompra(edt_date.getText().toString());
            livro.setEstrelas(ratingBar.getRating());
            livro.setStatus(selectedItemText);

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

    public void retorna(View view) {
        Intent intent = new Intent(activity_atualizar.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}