package com.autopecas.estoque.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
    private String marca;
    private String codigo;
    private Double preco;
    private Integer quantidade;
}
