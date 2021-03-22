package br.com.zup.transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findFirst10ByCartaoIdCartaoOrderByEfetivadaEmDesc(String idCartao);
}
