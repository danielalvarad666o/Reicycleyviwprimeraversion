package com.gasca1234.reicycleyviw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gasca1234.reicycleyviw.Adaptador.AdptadorPersona;
import  com.gasca1234.reicycleyviw.Modelos.persona;

import java.util.ArrayList;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ArrayList<persona> usersList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleview);
        usersList = new ArrayList<>();

        setUserInfo();
        setAdaptador();

    }
    private void setAdaptador() {
        AdptadorPersona adaptador= new AdptadorPersona(usersList);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adaptador);
    }

    private void setUserInfo() {
        usersList.add(new persona("Daniel", "8711340531"));
        usersList.add(new persona("victor", "8681299572"));
        usersList.add(new persona("Sebas <3", "8713385004"));
        usersList.add(new persona("paola", "8714162420"));
        usersList.add(new persona("Celeste", "8717696477"));
        usersList.add(new persona("yordi", "8712736050"));
        usersList.add(new persona("Gustavo", "8717696477"));

    }
}