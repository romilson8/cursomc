package br.com.banzo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banzo.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
