package br.com.zup.transacao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TransacaoListaResponseTest {

    @Test
    @DisplayName("Lança RuntimeException quando transacao for nula")
    void RuntimeException() {
        Assertions.assertThrows(RuntimeException.class, () -> new TransacaoListaResponse(null));
    }
}