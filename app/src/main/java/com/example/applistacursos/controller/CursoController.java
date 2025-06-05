package com.example.applistacursos.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.applistacursos.model.Curso;

public class CursoController {
    private static final String PREFS_NAME = "lista_pref";
    private final SharedPreferences sharedPreferences;

    public CursoController(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void salvarCurso(Curso curso) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nomeCurso", curso.getNomeCurso());
        editor.apply();
    }

    public Curso carregarCurso() {
        String nomeCurso = sharedPreferences.getString("nomeCurso", "");
        return new Curso(nomeCurso);
    }
}
