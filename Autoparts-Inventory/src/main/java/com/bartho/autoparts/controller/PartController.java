package com.bartho.autoparts.controller;

import com.bartho.autoparts.model.Part;
import com.bartho.autoparts.service.PartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parts")
public class PartController {

    private final PartService service;

    public PartController(PartService service) {
        this.service = service;
    }

    @GetMapping
    public List<Part> getAllParts() {
        return service.getAllParts();
    }

    @PostMapping
    public Part createPart(@RequestBody Part part) {
        return service.createPart(part);
    }

    @DeleteMapping("/{id}")
    public void deletePart(@PathVariable Long id) {
        service.deletePart(id);
    }
}