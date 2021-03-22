package br.com.zup.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoListaResponse {
    private final String id;
    private final BigDecimal valor;
    private final String nomeEstabelecimento;
    private final String idCartao;
    private final LocalDateTime efetivadaEm;

    public TransacaoListaResponse(Transacao transacao) {
        this.id = transacao.getIdTransacao();
        this.valor = transacao.getValor();
        this.nomeEstabelecimento = transacao.getEstabelicimento().getNome();
        this.idCartao = transacao.getCartao().getIdCartao();
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
