package org.example.lab5.Controller;

import org.example.lab5.Models.Triangle;
import org.example.lab5.Repo.TriangleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/update/{id}")
    public String updateTriangle(@PathVariable long id, @RequestBody Triangle triangle){
        Triangle updateTriangle = triangleRepo.findById(id).get();
        updateTriangle.setX1(triangle.getX1());
        updateTriangle.setX2(triangle.getX2());
        updateTriangle.setX3(triangle.getX3());
        updateTriangle.setY1(triangle.getY1());
        updateTriangle.setY2(triangle.getY2());
        updateTriangle.setY3(triangle.getY3());
        triangleRepo.save(updateTriangle);
        return "Трикутник було зміненно";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTriangle(@PathVariable long id){
        Triangle deleteTriangle = triangleRepo.findById(id).get();
        triangleRepo.delete(deleteTriangle);
        return "Трикутник видалено";
    }
}