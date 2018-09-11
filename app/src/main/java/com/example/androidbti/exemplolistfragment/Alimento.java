package com.example.androidbti.exemplolistfragment;

import java.util.Objects;

public class Alimento {

    String nome;
    String preco;

    public Alimento(String nome, String preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

}
