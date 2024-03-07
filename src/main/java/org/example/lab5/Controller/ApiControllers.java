package org.example.lab5.Controller;

import org.example.lab5.Models.Triangle;
import org.example.lab5.Repo.TriangleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private TriangleRepo triangleRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Hello";
    }
    @GetMapping(value = "/triangles")
    public List<Triangle> getTriangle(){
       return triangleRepo.findAll();
    }
    @PostMapping(value = "/save")
    public String saveTriangle(@RequestBody Triangle triangle){
        triangleRepo.save(triangle);
        return "Трикутник додано";
    }
}