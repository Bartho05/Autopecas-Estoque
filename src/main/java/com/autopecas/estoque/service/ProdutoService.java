package com.autopecas.estoque.service;
import com.autopecas.estoque.model.Produto;
import com.autopecas.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> listar(){
        return repository.findAll();
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public Produto atualizar(Long id, Produto produto){
        produto.setId(id);
        return repository.save(produto);
    }

}
