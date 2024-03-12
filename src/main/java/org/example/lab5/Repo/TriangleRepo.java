package org.example.lab5.repo;

import org.example.lab5.models.Triangle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriangleRepo extends JpaRepository<Triangle, Long> {

}