package com.example.myapplication.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.PagerAdapter;
import com.example.myapplication.db.Conexao;
import com.example.myapplication.db.LivroDAO;
import com.example.myapplication.model.Livro;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    private LivroDAO dao;
    private List<Livro> livros;
    private ListView listView;
    private FragmentManager fm;
    private int behavior;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, Activity_cadastro.class);
                startActivity(intent);

            }
        });

        listView = findViewById(R.id.listView);

        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem tabHome = findViewById(R.id.home);
        TabItem tabHistorico = findViewById(R.id.historico);

        final ViewPager viewPager = findViewById(R.id.viewPager);


         PagerAdapter pagerAdapter = new PagerAdapter(fm, behavior);





        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


}
