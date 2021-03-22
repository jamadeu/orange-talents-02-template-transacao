package br.com.zup.transacao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ListenerDeTransacaoTest {

    @InjectMocks
    private ListenerDeTransacao listener;

    @Mock
    private TransacaoRepository transacaoRepository;

    @Test
    @DisplayName("Salva transacao")
    void ouvir() {
        TransacaoResponse transacaoResponse = new TransacaoResponse(
                "id",
                new BigDecimal(100),
                new Estabelicimento("Nome", "Cidade", "Endereco"),
                new Cartao("IdCartao", "email@test.com"),
                LocalDateTime.now());

        Transacao transacao = transacaoResponse.toModel();
        when(transacaoRepository.save(transacao))
                .thenReturn(transacao);

        assertDoesNotThrow(() -> listener.ouvir(transacaoResponse));
    }
}