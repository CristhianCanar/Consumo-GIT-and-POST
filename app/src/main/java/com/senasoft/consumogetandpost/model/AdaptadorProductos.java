package com.senasoft.consumogetandpost.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.senasoft.consumogetandpost.R;

import java.util.ArrayList;

public class AdaptadorProductos extends BaseAdapter {


    Context context;
    ArrayList<Producto> lista;

    public AdaptadorProductos(Context context, ArrayList<Producto> lista) {
        this.context = context;
        this.lista = new ArrayList<>(lista);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView image;
        TextView txtName, txtVolume, textValue, textStock;

        view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);

        image = view.findViewById(R.id.ivImagen);

        txtName = view.findViewById(R.id.textNombre);
        txtVolume = view.findViewById(R.id.textVolume);
        textValue = view.findViewById(R.id.textValue);
        textStock = view.findViewById(R.id.textStock);

        image.setImageResource(R.drawable.ic_wallpaper_black_24dp);

        txtName.setText(lista.get(i).getNameProduct());
        txtVolume.setText(lista.get(i).getVolumeProduct());
        textValue.setText(lista.get(i).getValueProduct());
        textStock.setText(lista.get(i).getStockProduct());

        return view;

    }
}
