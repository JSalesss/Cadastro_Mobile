package com.example.applistacursos.controller;

import android.content.Context;
import android.widget.Toast;
import com.example.applistacursos.model.Pessoa;

public class PessoaController {
    private final Context context;

    public PessoaController(Context context) {
        this.context = context;
    }

    public void salvarPessoa(Pessoa pessoa) {
        String msg = "Pessoa salva: " + pessoa.getNome() + " " + pessoa.getSobrenome();
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}

