package br.com.banzo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banzo.domain.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@GetMapping
	public List<Categoria> listar() {
		
		Categoria cat1 =  new Categoria();
		cat1.setId(1);
		cat1.setNome("A");
		
		Categoria cat2 =  new Categoria();
		cat2.setId(2);
		cat2.setNome("B");
		
		List<Categoria> listaCategorias = new ArrayList<>();
		listaCategorias.add(cat1);
		listaCategorias.add(cat2);
		
		return listaCategorias;
	}

}
