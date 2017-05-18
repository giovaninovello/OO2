package com.example.giovani.aulabanco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Giovani on 10/05/2017.
 */

public class ContatosAdapter extends BaseAdapter {

    private Context context;
    private List<Contatos> list;

    public ContatosAdapter(Context context, List<Contatos> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();//tamano do list
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);//retorna a posicao do item da minha lista
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int auxposition = position;

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.activity_lista_contatos,null);

        TextView txtnome = (TextView)layout.findViewById(R.id.textnomecontato);
        txtnome.setText(list.get(position).getNOME());




        return layout;
    }
}
