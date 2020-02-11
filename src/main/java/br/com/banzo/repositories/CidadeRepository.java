package br.com.banzo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banzo.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
