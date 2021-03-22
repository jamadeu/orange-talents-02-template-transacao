package br.com.zup.transacao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idTransacao;

    private BigDecimal valor;

    private LocalDateTime efetivadaEm;

    @Embedded
    private Cartao cartao;

    @Embedded
    private Estabelicimento estabelicimento;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String idTransacao, BigDecimal valor, LocalDateTime efetivadaEm, Cartao cartao, Estabelicimento estabelicimento) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.cartao = cartao;
        this.estabelicimento = estabelicimento;
    }

    public Long getId() {
        return id;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Estabelicimento getEstabelicimento() {
        return estabelicimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return getIdTransacao().equals(transacao.getIdTransacao()) && getValor().equals(transacao.getValor()) && getEfetivadaEm().equals(transacao.getEfetivadaEm()) && getCartao().equals(transacao.getCartao()) && getEstabelicimento().equals(transacao.getEstabelicimento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTransacao(), getValor(), getEfetivadaEm(), getCartao(), getEstabelicimento());
    }
}
