package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.db.Conexao;
import com.example.myapplication.db.LivroDAO;
import com.example.myapplication.model.Livro;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    List<Livro> livros;
    private LivroDAO dao;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//    ListView listView = findViewById(R.id.listView);
//    dao = new LivroDAO(getApplicationContext());
//    livros = dao.selectAll();
//    ArrayAdapter<Livro> dataAdapter = new ArrayAdapter<Livro>(this, android.R.layout.simple_list_item_1, livros);
//    listView.setAdapter(dataAdapter);
//    dataAdapter.notifyDataSetChanged();




        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Sucesso" + livros, Toast.LENGTH_LONG).show();


                Intent intent = new Intent(MainActivity.this, Activity_cadastro.class);
                startActivity(intent);

            }
        });



    }


}