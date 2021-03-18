package br.com.zup.transacao;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private final TransacaoRepository transacaoRepository;

    public ListenerDeTransacao(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoResponse transacaoResponse) {
        Transacao transacao = transacaoResponse.toModel();
        transacaoRepository.save(transacao);
        System.out.println(transacaoResponse);
    }
}
