package com.example.applistacursos.controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.applistacursos.model.Pessoa;

public class PessoaController {
    private final Context context;

    public PessoaController(Context context) {
        this.context = context;
    }

    public void salvarPessoa(Pessoa pessoa) {
        Toast.makeText(context, pessoa.toString(), Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciado!");
        return super.toString();
    }

    public void salvar(Pessoa pessoa){
        Log.d("MVC_Controller", "Salvo " + pessoa.toString());
    }
}
