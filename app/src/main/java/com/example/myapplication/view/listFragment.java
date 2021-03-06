package com.example.myapplication.view;

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



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        intent = new Intent(getActivity(), listFragment.class);


        listView = view.findViewById(R.id.listView);


        if(livros.isEmpty()){
            Toast.makeText(getContext(), "vazio", Toast.LENGTH_SHORT).show();

        }else{

            dao = new LivroDAO(getActivity());
            livros = dao.selectAll();
            ArrayAdapter<Livro> adapter = new ArrayAdapter<Livro>(getContext(), android.R.layout.simple_list_item_1, livros);

            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            Toast.makeText(getContext(), "Chamou", Toast.LENGTH_SHORT).show();

        }




        return view;
    }
}