package br.com.zup.transacao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class TransacaoResponseTest {

    @Test
    @DisplayName("toModel cria uma nova instancia de Transacao")
    void toModelCriaTransacao() {

        String idTransacao = "idTransacao";
        BigDecimal valor = new BigDecimal(100);
        LocalDateTime emitidaEm = LocalDateTime.now();
        Estabelicimento estabelicimento = new Estabelicimento("Nome", "Cidade", "Endereco");
        Cartao cartao = new Cartao("idCartao", "email@teste.com");
        TransacaoResponse transacaoResponse = new TransacaoResponse(
                idTransacao,
                valor,
                estabelicimento,
                cartao,
                emitidaEm);

        Transacao transacao = new Transacao(idTransacao, valor, emitidaEm, cartao, estabelicimento);
        Transacao transacaoGerada = transacaoResponse.toModel();

        assertEquals(transacao, transacaoGerada);
    }
}