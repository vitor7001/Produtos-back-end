package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	//metodo para buscar um produto por id
	Produto findById(long id);
	
}
