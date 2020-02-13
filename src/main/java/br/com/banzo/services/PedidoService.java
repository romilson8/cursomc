package br.com.banzo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banzo.domain.Pedido;
import br.com.banzo.repositories.PedidoRepository;
import br.com.banzo.services.exceptions.ObjectNotFoundException;



@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository categoriaRepository;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> pedido = categoriaRepository.findById(id);
		return pedido.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}
