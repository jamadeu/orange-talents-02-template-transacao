package br.com.zup.transacao;

import javax.persistence.*;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
