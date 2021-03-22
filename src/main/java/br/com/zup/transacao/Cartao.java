package br.com.zup.transacao;

import javax.persistence.*;

@Embeddable
public class Cartao {

    private String idCartao;

    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String idCartao, String email) {
        this.idCartao = idCartao;
        this.email = email;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public String getEmail() {
        return email;
    }
}
