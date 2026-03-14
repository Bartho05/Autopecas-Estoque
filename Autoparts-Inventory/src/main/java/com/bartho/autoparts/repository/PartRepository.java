package com.bartho.autoparts.repository;

import com.bartho.autoparts.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {

}