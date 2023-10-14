package com.example.listviewcustomadapter;

import android.graphics.drawable.Drawable;

public class Contatto {
    private String nome, numero;
    private Drawable contatto;

    public Contatto (String nome, String numero, Drawable contatto) {
        this.nome = nome;
        this.numero = numero;
        this.contatto = contatto;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public Drawable getContatto() {
        return contatto;
    }
}
