package br.com.banzo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.banzo.domain.Categoria;
import br.com.banzo.repositories.CategoriaRepository;
import br.com.banzo.services.exceptions.DataIntegrityException;
import br.com.banzo.services.exceptions.ObjectNotFoundException;



@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria inserir(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}

	public  Categoria atualizar(Categoria categoria) {
		buscar(categoria.getId());
		return categoriaRepository.save(categoria);
	}

	public void apagar(Integer id) {
		buscar(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produto");
		}
	}

	public List<Categoria> buscarLista() {
		List<Categoria> categorias = categoriaRepository.findAll();
		return categorias;
	}


}
