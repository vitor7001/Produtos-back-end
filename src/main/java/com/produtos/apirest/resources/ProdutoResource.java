package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

	//interface que possui os comandos implementados de persistencia
	@Autowired
	ProdutoRepository produtoRepository;

	//buscar por todos os produtos
	@GetMapping("/produtos")
	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}
	
	//buscar por todo um produto
	@GetMapping("/produtos/{id}")
	public Produto listarProdutoUnicos(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	
	@PostMapping("/produtos")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
