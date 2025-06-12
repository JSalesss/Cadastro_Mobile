package com.joao.applistacursos.model;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private String telefone;

    public Pessoa(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = String.valueOf(telefone);
    }

    @Override
    public String toString() {
        return "Nome completo= " + nome + " " + sobrenome + "\nTelefone= " + telefone;
    }
}
