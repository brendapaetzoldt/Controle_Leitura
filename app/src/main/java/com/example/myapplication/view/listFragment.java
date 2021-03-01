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

import com.example.myapplication.R;
import com.example.myapplication.db.LivroDAO;
import com.example.myapplication.model.Livro;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link listFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class listFragment extends Fragment {


    private ListView listView;
    private Intent intent;

    private LivroDAO dao;
    private List<Livro> livros;

    public listFragment() {
        // Required empty public constructor
    }


    public static listFragment newInstance(String param1, String param2) {
        listFragment fragment = new listFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        intent = new Intent(getActivity(), Activity_cadastro.class);


        listView = view.findViewById(R.id.listView);
        dao = new LivroDAO(getActivity());
        livros = dao.selectAll();


        ArrayAdapter<Livro> adapter = new ArrayAdapter<Livro>(getContext(), android.R.layout.simple_list_item_1, livros);

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    listView.setAdapter(adapter);

        return view;
    }
}