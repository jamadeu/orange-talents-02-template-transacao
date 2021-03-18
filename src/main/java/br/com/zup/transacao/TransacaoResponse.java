package br.com.zup.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {
    private final String id;
    private final BigDecimal valor;
    private final Estabelicimento estabelicimento;
    private final Cartao cartao;
    private final LocalDateTime efetivadaEm;

    public TransacaoResponse(String id, BigDecimal valor, Estabelicimento estabelicimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelicimento = estabelicimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao toModel() {
        return new Transacao(id, valor, efetivadaEm, cartao, estabelicimento);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelicimento getEstabelicimento() {
        return estabelicimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
