package com.example.examen1diseoapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.examen1diseoapps.Adaptadores.ElementoAdapter;
import com.example.examen1diseoapps.Modelos.Elemento;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recycler);
        List<Elemento> elementos = new ArrayList<>();
        ElementoAdapter elementosAdapter = new ElementoAdapter(elementos);
        elementos.add(new Elemento(R.drawable.telefono, "Llamada directa",new Intent(Intent.ACTION_CALL, Uri.parse("tel: 8715722538"))));
        elementos.add(new Elemento(R.drawable.lista, "Explicito 1",new Intent(Intent.ACTION_CALL, Uri.parse("tel: 8715722538"))));
        elementos.add(new Elemento(R.drawable.ic_launcher_background, "Explicito 2",new Intent(Intent.ACTION_CALL, Uri.parse("tel: 8715722538"))));
        elementos.add(new Elemento(R.drawable.google, "Google",new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"))));
        elementos.add(new Elemento(R.drawable.telefono, "Dial",new Intent(Intent.ACTION_VIEW,Uri.parse("tel:8715722538"))));
        elementos.add(new Elemento(R.drawable.maps, "Google Maps",new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=37.423156,-122.084917"))));
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(elementosAdapter);

    }

}