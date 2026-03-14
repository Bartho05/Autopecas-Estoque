package com.autopecas.estoque.controller;
import com.autopecas.estoque.model.Produto;
import com.autopecas.estoque.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
        return service.salvar(produto);
    }

    @GetMapping
    public List<Produto> listar(){
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto){
        return service.atualizar(id, produto);
    }
}

