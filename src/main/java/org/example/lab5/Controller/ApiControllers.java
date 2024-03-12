package org.example.lab5.Controller;

import org.example.lab5.Models.Triangle;
import org.example.lab5.Repo.TriangleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiControllers {

    @Autowired
    private TriangleRepo triangleRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Hello";
    }

    @GetMapping(value = "/triangles")
    public ResponseEntity<List<Triangle>> getTriangle(){
       List<Triangle> triangles = triangleRepo.findAll();
       return ResponseEntity.ok(triangles);
    }

    @GetMapping(value = "/triangle/{id}")
    public ResponseEntity<Triangle> getTriangleById(@PathVariable long id){
        Optional<Triangle> triangle = triangleRepo.findById(id);
        return triangle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveTriangle(@RequestBody Triangle triangle){
        triangleRepo.save(triangle);
        return ResponseEntity.ok("трикутник додано");
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateTriangle(@PathVariable long id, @RequestBody Triangle triangle){
        Optional<Triangle> optionalTriangle = triangleRepo.findById(id);
        if (optionalTriangle.isPresent()) {
            Triangle updateTriangle = optionalTriangle.get();
            updateTriangle.setX1(triangle.getX1());
            updateTriangle.setX2(triangle.getX2());
            updateTriangle.setX3(triangle.getX3());
            updateTriangle.setY1(triangle.getY1());
            updateTriangle.setY2(triangle.getY2());
            updateTriangle.setY3(triangle.getY3());
            triangleRepo.save(updateTriangle);
            return ResponseEntity.ok("Трикутник було змінено");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity <String> deleteTriangle(@PathVariable long id){
        Optional<Triangle> optionalTriangle = triangleRepo.findById(id);
        if (optionalTriangle.isPresent()) {
            Triangle deleteTriangle = optionalTriangle.get();
            triangleRepo.delete(deleteTriangle);
            return ResponseEntity.ok("Трикутник видалено");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}