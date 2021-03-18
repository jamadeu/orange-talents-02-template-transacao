package br.com.zup.transacao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idTransacao;

    private BigDecimal valor;

    private LocalDateTime efetivadaEm;

    @OneToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;

    @OneToOne(cascade = CascadeType.MERGE)
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
}
