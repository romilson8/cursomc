package br.com.banzo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banzo.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
