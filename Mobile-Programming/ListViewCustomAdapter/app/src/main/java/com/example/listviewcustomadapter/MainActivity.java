package com.example.listviewcustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListView listView;
    public CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] nomi = {"Pasquale","Maria","Michele","Antonella", "Vincenzo",
                "Teresa", "Roberto", "Rossella", "Antonio", "Luca", "Liliana", "Stefania",
                "Francesca", "Andrea", "Marco", "Elisa", "Anna", "Lorenzo"};

        listView = findViewById(R.id.list_view);

        customAdapter = new CustomAdapter(this, R.layout.list_element, new ArrayList<Contatto>());

        listView.setAdapter(customAdapter);

        for (String nome : nomi) {
            Contatto c = new Contatto(nome, "333-00-00-000", getResources().getDrawable(R.drawable.contact,null));
            customAdapter.add(c);
        }

//        listView.setOnItemClickListener((parent, view, position, id) -> {
//            String nome = listView.getItemAtPosition(position).toString();
//            Toast.makeText(getApplicationContext(), "Click sulla posizione " + position + ": " + nome, Toast.LENGTH_SHORT).show();
//        });

    }

    // Aggiunta dei listener
    public void onContactClick(View v) {
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(), "Click sulla foto - posizione n. " + position, Toast.LENGTH_SHORT).show();
    }
    public void onNumberClick(View v) {
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(), "Click sul numero - posizione n. " + position + ": " + c.getNumero(), Toast.LENGTH_SHORT).show();
    }
    public void onNameClick(View v) {
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(), "Click sul nome - posizione n. " + position + ": " + c.getNome(), Toast.LENGTH_SHORT).show();
    }
}