package com.joao.applistacursos.controller;

import android.content.Context;
import android.content.SharedPreferences;
import com.joao.applistacursos.model.Pessoa;

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
        return new Pessoa(
                sharedPreferences.getString("nome", ""),
                sharedPreferences.getString("sobrenome", ""),
                sharedPreferences.getString("telefone", "")
        );
    }

    public void apagarPessoa() {
        sharedPreferences.edit().clear().apply();
    }

    public boolean validarPessoa(Pessoa pessoa) {
        return !pessoa.getNome().isEmpty()
                && !pessoa.getSobrenome().isEmpty()
                && !pessoa.getTelefone().isEmpty();
    }
}