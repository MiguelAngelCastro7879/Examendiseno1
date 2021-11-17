package com.example.examen1diseoapps.Adaptadores;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen1diseoapps.Modelos.Dato;
import com.example.examen1diseoapps.R;

import java.util.List;

public class DatoAdapter extends RecyclerView.Adapter<DatoAdapter.ViewHolder>{
    private final List<Dato> lista;

    public DatoAdapter(List<Dato> lista) {
        this.lista = lista;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dato d = lista.get(position);
        holder.llenar(d);

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView nombre, web, telefono, nombre_real;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtnombre);
//            web = itemView.findViewById(R.id.txtweb);
//            telefono = itemView.findViewById(R.id.txttelefono);
            telefono.setOnClickListener(this);
            web.setOnClickListener(this);

        }

        public void llenar(Dato d) {
            nombre.setText(d.getNombre());
            web.setText(d.getWeb());
            telefono.setText(d.getTelefono());
        }
        @Override
        public void onClick(View v) {
            if(v.getId()==telefono.getId()){
                Intent mandar = new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+telefono.getText()));
                v.getContext().startActivity(mandar);
            }
        }
    }
}
