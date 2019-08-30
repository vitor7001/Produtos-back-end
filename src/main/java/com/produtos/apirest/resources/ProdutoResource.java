package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API Rest Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {

	// interface que possui os comandos implementados de persistencia
	@Autowired
	ProdutoRepository produtoRepository;

	// buscar por todos os produtos
	@GetMapping("/produtos")
	@ApiOperation(value = "Este método retorna todos os Produtos do banco de dados")
	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}

	// buscar por todo um produto
	@GetMapping("/produtos/{id}")
	@ApiOperation(value = "Este método retorna um único Produto do banco de dados")
	public Produto listarProdutoUnicos(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	// inserir um produto no banco de dados
	@PostMapping("/produtos")
	@ApiOperation(value = "Este método salva um Produtos no banco de dados")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	// deletar um produto do banco de dados
	@DeleteMapping("/produtos")
	@ApiOperation(value = "Este método deleta um Produtos do banco de dados")
	public void deletarProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}

	// atualizar algum produto do banco de dados e retorna o mesmo
	@PutMapping("/produtos")
	@ApiOperation(value = "Este método atualiza um Produtos do banco de dados")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
