package br.com.zup.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Pageable;

@RestController
@RequestMapping("api/v1/transacoes")
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;
    private final CartaoRepository cartaoRepository;

    public TransacaoController(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    @GetMapping("/cartao/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> buscaPorCartao(@PathVariable("id") Long idCartao, @PageableDefault Pageable pageable) {
        Cartao cartao = cartaoRepository.findById(idCartao)
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartao nao encontrado");
                });

        Page<Transacao> transacoes = transacaoRepository.findByCartao(cartao, pageable);
        return ResponseEntity.ok(transacoes);
    }

}
