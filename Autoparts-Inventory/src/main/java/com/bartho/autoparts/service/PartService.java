package com.bartho.autoparts.service;

import com.bartho.autoparts.model.Part;
import com.bartho.autoparts.repository.PartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {

    private final PartRepository repository;

    public PartService(PartRepository repository) {
        this.repository = repository;
    }

    public List<Part> getAllParts() {
        return repository.findAll();
    }

    public Part createPart(Part part) {
        return repository.save(part);
    }

    public void deletePart(Long id) {
        repository.deleteById(id);
    }
}