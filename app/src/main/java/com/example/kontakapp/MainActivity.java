package com.example.kontakapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kontakapp.adapter.KontakAdapter;
import com.example.kontakapp.model.Kontak;
//import com.google.android.filament.View;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    KontakAdapter kontakRecyclerAdapter;
    ArrayList<Kontak> _kontakList;
    Button btnAddData;
    int[] foto = {R.drawable.ava1, R.drawable.ava2, R.drawable.ava3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnAddData = findViewById(R.id.id_BtAddData);
        btnAddData.setOnClickListener(this);
        loadData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.id_rvKontak);
        kontakRecyclerAdapter = new KontakAdapter(_kontakList, this);
        recyclerView.setAdapter(kontakRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void addData() {
        Random ran = new Random();
        int choose = ran.nextInt(3);
        _kontakList.add(new Kontak("newData"+(_kontakList.size()-1), "0879761521" + (_kontakList.size()-1), foto[choose]));

    }

    private void loadData() {
        _kontakList = new ArrayList<>();
        _kontakList.add(new Kontak("Nisriina", "085651023987", foto[0]));
        _kontakList.add(new Kontak("Dyan", "081234567890", foto[1]));
        _kontakList.add(new Kontak("Pramesthi", "08907654321", foto[2]));
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnAddData.getId()) {
            addData();
            kontakRecyclerAdapter.notifyDataSetChanged();
        }
    }
}