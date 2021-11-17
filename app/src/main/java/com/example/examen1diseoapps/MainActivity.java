package com.example.examen1diseoapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.example.examen1diseoapps.Adaptadores.ElementoAdapter;
import com.example.examen1diseoapps.Modelos.Elemento;
import com.example.examen1diseoapps.Modelos.Permiso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    List<Permiso> permisos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recycler);

        permisos = new ArrayList<>();

        List<Elemento> elementos = new ArrayList<>();
        ElementoAdapter elementosAdapter = new ElementoAdapter(elementos);
        elementos.add(new Elemento(R.drawable.telefono, "Llamada directa",new Intent(Intent.ACTION_CALL, Uri.parse("tel: 8715722538"))));
        elementos.add(new Elemento(R.drawable.lista, "Explicito 1",new Intent(Intent.ACTION_CALL, Uri.parse("tel: 8715722538"))));
        elementos.add(new Elemento(R.drawable.ic_launcher_background, "Explicito 2",new Intent(Intent.ACTION_CALL, Uri.parse("tel: 8715722538"))));
        elementos.add(new Elemento(R.drawable.google, "Google",new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"))));
        elementos.add(new Elemento(R.drawable.telefono, "Dial",new Intent(Intent.ACTION_VIEW,Uri.parse("tel:8715722538"))));
        elementos.add(new Elemento(R.drawable.maps, "Google Maps",new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=37.423156,-122.084917"))));


        permisos.add(new Permiso("Llamada", Manifest.permission.CALL_PHONE));
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(elementosAdapter);

        comprobar_permisos(permisos);

    }

    private void comprobar_permisos(List<Permiso> permisos) {
        String[] permisos_denegados = new String[50];
        for(int i=0;i<permisos.size();i++){
            if(ContextCompat.checkSelfPermission(this,permisos.get(i).getNombre_real())==
                    PackageManager.PERMISSION_DENIED){
                permisos_denegados[i]=permisos.get(i).getNombre_real();
            }
        }
        requestPermissions(permisos_denegados,363);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 363:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){

                }
                else{
                    if(ActivityCompat.shouldShowRequestPermissionRationale(this,permissions[0])){
                        AlertDialog.Builder constructor = new AlertDialog.Builder(this);
                        constructor.setMessage("Puede que se presenten errores si se rechazan los permisos");
                        constructor.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                comprobar_permisos(permisos);
                            }
                        });
                        AlertDialog dialogo  = constructor.create();
                        dialogo.show();
                    }
                    else{
                        AlertDialog.Builder constructor = new AlertDialog.Builder(this);
                        constructor.setMessage("Esta app no funcionará sin los permisos necesarios");
                        constructor.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                    }
                }
                break;
        }

    }


}