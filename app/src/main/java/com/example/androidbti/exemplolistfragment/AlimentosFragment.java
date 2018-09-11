package com.example.androidbti.exemplolistfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AlimentosFragment extends ListFragment {

    ArrayAdapter<Alimento> adapterAlimentos;
    private onItemCLick listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(!(context instanceof onItemCLick)){
            throw new RuntimeException("nao e instancia de onItemClick");
        }
        listener = (onItemCLick) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapterAlimentos = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);
        List<Alimento> alimentoList = new ArrayList<>();

        for (String s : getActivity().getResources().getStringArray(R.array.alimentosNomes)){
            Alimento alimento = new Alimento(s, null);
            alimentoList.add(alimento);
        }

        for (int i = 0; i < alimentoList.size(); i++) {
            alimentoList.get(i).setPreco(getActivity().getResources().getStringArray(R.array.alimentosPrecos)[i]);
            adapterAlimentos.add(alimentoList.get(i));
        }




        setListAdapter(adapterAlimentos);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Alimento alimento = adapterAlimentos.getItem(position);

        if(listener != null){
            listener.onClick(alimento);
        }

    }

    public interface onItemCLick{
        void onClick(Alimento alimento);
    }
}
