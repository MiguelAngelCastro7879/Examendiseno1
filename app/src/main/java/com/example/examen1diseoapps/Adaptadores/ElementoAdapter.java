package com.example.examen1diseoapps.Adaptadores;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen1diseoapps.Modelos.Dato;
import com.example.examen1diseoapps.Modelos.Elemento;
import com.example.examen1diseoapps.R;

import java.util.List;
import java.util.zip.Inflater;

public class ElementoAdapter extends RecyclerView.Adapter<ElementoAdapter.ViewHolder> {
    List<Elemento> elementos;

    public ElementoAdapter(List<Elemento> elementos) {
        this.elementos = elementos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Elemento e = elementos.get(position);
        holder.llenar(e);
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView txtNombre;
        ImageView imagen;
        Intent I;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre= itemView.findViewById(R.id.txtnombre);
            imagen= itemView.findViewById(R.id.imagen);
            itemView.setOnClickListener(this);
        }

        public void llenar(Elemento e) {
            txtNombre.setText(e.getNombre());
            imagen.setImageResource(e.getImagen());
            I=e.getIntent();
        }

        @Override
        public void onClick(View v) {
            v.getContext().startActivity(I);
        }
    }
}
