package br.com.zup.transacao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TransacaoControllerTest {

    private final String URL_API_TRANSACOES = "/api/v1/transacoes";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TransacaoRepository transacaoRepository;


    @Test
    @WithMockUser
    @DisplayName("Retorna lista de transacoes")
    void retornaListaDeTransacoes() throws Exception {
        Estabelicimento estabelicimento = new Estabelicimento("Nome", "Cidade", "Endereco");
        Cartao cartao = new Cartao("IdCartao", "email@test.com");
        Transacao transacao = new Transacao(
                "idTransacao",
                new BigDecimal(100),
                LocalDateTime.now(),
                cartao,
                estabelicimento);

        transacaoRepository.save(transacao);
        mockMvc.perform(MockMvcRequestBuilders
                .get(URL_API_TRANSACOES + "/cartao/" + cartao.getIdCartao())
        ).andExpect(MockMvcResultMatchers
                .status()
                .is2xxSuccessful()
        );
    }

    @Test
    @WithMockUser
    @DisplayName("Retorna 404 quando idCartao invalido")
    void retorna404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get(URL_API_TRANSACOES + "/cartao/" + "idInvalido")
        ).andExpect(MockMvcResultMatchers
                .status()
                .is(404)
        );
    }

}