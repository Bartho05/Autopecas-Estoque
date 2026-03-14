package com.autopecas.estoque.controller;
import com.autopecas.estoque.model.Produto;
import com.autopecas.estoque.repository.ProdutoRepository;
import com.autopecas.estoque.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service){
        this.service = service;
    }
    @GetMapping
    public List<Produto> listar(){
        return service.listarTodos();
    }
    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        return service.salvar(produto);
    }

}

