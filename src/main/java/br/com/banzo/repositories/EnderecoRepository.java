package br.com.banzo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banzo.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
