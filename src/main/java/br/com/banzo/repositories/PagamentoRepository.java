package br.com.banzo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banzo.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
