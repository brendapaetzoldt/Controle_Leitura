package com.example.myapplication.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.listItem;
import com.example.myapplication.db.LivroDAO;
import com.example.myapplication.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class listFragment extends Fragment {


    private ListView listView;
    private Intent intent;

    private LivroDAO dao;
    private List<Livro> livros;

    public listFragment() {
        // Required empty public constructor
    }


    private AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView parent, View v, int position, long isbn) {

            final Livro livroAtualizar = livros.get(position);
            intent.putExtra("livro", livroAtualizar);

            verifica((int) isbn);
            listView.invalidateViews();

            startActivity(intent);


        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        intent = new Intent(getActivity(), activity_atualizar.class);
        listView = view.findViewById(R.id.listView);

        dao = new LivroDAO(getActivity());
        livros = dao.selectAll();

        listItem adapter = new listItem(getActivity().getApplicationContext(), 0, livros);

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(listClick);
        return view;
    }

    public boolean verifica(int isbn) {
        for (Livro l : livros) {
            if (l.getISBN() == isbn) {
                livros.add(l);
                return true;

            }
        }
        return false;
    }
}