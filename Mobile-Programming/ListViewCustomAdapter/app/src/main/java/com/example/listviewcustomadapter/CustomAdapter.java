package com.example.listviewcustomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Contatto> {
    public LayoutInflater layoutInflater;

    public CustomAdapter(@NonNull Context context, int resourceID, List<Contatto> objects) {
        super(context, resourceID, objects);
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
            convertView = layoutInflater.inflate(R.layout.list_element, null); // Trasforma il layout in una view da poter utilizzare

        Contatto c = getItem(position);

        TextView nome;
        TextView telefono;
        ImageView contatto;

        nome = (TextView) convertView.findViewById(R.id.list_text);
        telefono = (TextView) convertView.findViewById(R.id.number);
        contatto = (ImageView) convertView.findViewById(R.id.contact);

        nome.setText(c.getNome());
        telefono.setText(c.getNumero());
        contatto.setImageDrawable(c.getContatto());

        nome.setTag(position);
        telefono.setTag(position);
        contatto.setTag(position);

        return convertView;
    }
}