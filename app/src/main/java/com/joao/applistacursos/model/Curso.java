package com.joao.applistacursos.model;

import android.content.Context;

public class Curso {

    private String nomeCurso;

    public Curso (Context context){}

    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    @Override
    public String toString() {
        return "Curso: " + nomeCurso;
    }
}
