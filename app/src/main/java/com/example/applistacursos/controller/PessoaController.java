package com.example.applistacursos.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.applistacursos.model.Pessoa;

public class PessoaController {
    private static final String PREFS_NAME = "lista_pref";
    private final SharedPreferences sharedPreferences;

    public PessoaController(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void salvarPessoa(Pessoa pessoa) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nome", pessoa.getNome());
        editor.putString("sobrenome", pessoa.getSobrenome());
        editor.putString("telefone", pessoa.getTelefone());
        editor.apply();
    }

    public Pessoa carregarPessoa() {
        String nome = sharedPreferences.getString("nome", "");
        String sobrenome = sharedPreferences.getString("sobrenome", "");
        String telefone = sharedPreferences.getString("telefone", "");
        return new Pessoa(nome, sobrenome, telefone);
    }
    public void apagarPessoa(){
        sharedPreferences.edit().clear().apply();
    }
}
