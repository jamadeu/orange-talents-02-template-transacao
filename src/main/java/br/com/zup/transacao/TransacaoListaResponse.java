package br.com.zup.transacao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoListaResponse {
    private final String id;
    private final BigDecimal valor;
    private final String nomeEstabelecimento;
    private final String idCartao;
    private final LocalDateTime efetivadaEm;

    final Logger logger = LoggerFactory.getLogger(TransacaoListaResponse.class);

    public TransacaoListaResponse(Transacao transacao) {
        if (transacao == null) {
            logger.warn("Transacao nula no construtor da classe {}", TransacaoListaResponse.class.getName());
            throw new RuntimeException("Transacao nao pode ser nula");
        }
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
