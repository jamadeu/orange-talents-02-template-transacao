package br.com.zup.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/transacoes")
public class TransacaoController {

    private final Logger logger = LoggerFactory.getLogger(TransacaoController.class);

    private final TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("/cartao/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> buscaPorCartao(@PathVariable("id") String idCartao) {
        logger.info("Busca transacao por idCartao = {}", idCartao);

        List<Transacao> transacoes = transacaoRepository.findByCartaoIdCartaoOrderByEfetivadaEmDesc(idCartao);
        if (transacoes.isEmpty()) {
            logger.info("Nenhuma transacao localizada para o cartao {}", idCartao);
            return ResponseEntity.notFound().build();
        }

        List<TransacaoBuscaPorCartaoResponse> responses = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            responses.add(new TransacaoBuscaPorCartaoResponse(transacoes.get(i)));
        }

        logger.info("Transacaoes localizadas {}", responses);
        return ResponseEntity.ok(responses);
    }

}
