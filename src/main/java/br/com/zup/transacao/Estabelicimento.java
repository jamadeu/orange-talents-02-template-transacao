package br.com.zup.transacao;

import javax.persistence.*;

@Embeddable
public class Estabelicimento {

    private String nome;

    private String cidade;

    private String endereco;

    @Deprecated
    public Estabelicimento() {
    }

    public Estabelicimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
