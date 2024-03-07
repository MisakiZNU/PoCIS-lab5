package org.example.lab5.Repo;

import org.example.lab5.Models.Triangle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriangleRepo extends JpaRepository<Triangle, Long> {

}