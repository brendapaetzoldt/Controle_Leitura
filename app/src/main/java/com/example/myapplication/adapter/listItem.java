package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.model.Livro;

import java.util.List;

public class listItem extends ArrayAdapter<Livro> {

    private Context context;
    private List<Livro> livros;

    public listItem(@NonNull Context context, int resource, @NonNull List<Livro> livros) {
        super(context, resource, livros);
        this.context = context;
        this.livros = livros;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Livro livro = livros.get(position);

        LayoutInflater inflater = LayoutInflater.from(getContext());


        convertView = inflater.inflate(R.layout.list_item, parent, false);


        TextView txt_autor = convertView.findViewById(R.id.txt_autor);
        TextView txt_titulo = convertView.findViewById(R.id.txt_titulo);


        txt_autor.setText(livro.getAutor());
        txt_titulo.setText(livro.getTitulo());


        return convertView;
    }
}
