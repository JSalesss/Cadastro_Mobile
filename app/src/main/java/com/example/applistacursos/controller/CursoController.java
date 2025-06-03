package com.example.applistacursos.controller;

import android.content.Context;
import android.widget.Toast;

import com.example.applistacursos.model.Curso;

public class CursoController {
    private final Context context;

    public CursoController(Context context) {
        this.context = context;
    }

    public void salvarCurso(Curso curso) {
        Toast.makeText(context, curso.toString(), Toast.LENGTH_SHORT).show();
    }
}

