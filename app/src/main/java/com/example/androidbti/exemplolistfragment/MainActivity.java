package com.example.androidbti.exemplolistfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.NumberFormat;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements AlimentosFragment.onItemCLick{
    TextFragment textFragment;

    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.fragText);
    }

    @Override
    public void onClick(Alimento alimento) {
        textFragment.setTextView(String.format("O preço do %s é %s", alimento.getNome(), nf.format(Double.parseDouble(alimento.getPreco()))));
    }
}
