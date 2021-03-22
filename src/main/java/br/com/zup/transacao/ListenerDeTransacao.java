package br.com.zup.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private final Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);
    private final TransacaoRepository transacaoRepository;

    @Autowired
    public ListenerDeTransacao(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoResponse transacaoResponse) {
        logger.info("Nova mensagem {}", transacaoResponse);
        Transacao transacao = transacaoResponse.toModel();
        transacaoRepository.save(transacao);
        logger.info("Transacao {}", transacao);
        System.out.println(transacaoResponse);
    }
}
