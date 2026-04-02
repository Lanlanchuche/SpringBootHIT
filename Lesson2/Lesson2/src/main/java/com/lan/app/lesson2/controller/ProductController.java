package com.lan.app.lesson2.controller;

import com.lan.app.lesson2.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private List<Product> productList = new ArrayList<>();

    public ProductController() {
        productList.add(new Product("001", "Laptop", 20000000, 123));
        productList.add(new Product("002", "Smartphone", 35000000, 50));
    }

    @GetMapping("/api/products")
    public ResponseEntity<Product> getAll(@RequestParam String name){
        if(!productList.isEmpty() || !name.isEmpty()){
            for(Product product : productList){
                if(product.getName().equals(name)){
                    return ResponseEntity.ok(product);
                }
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id){
        for(Product p: productList){
            if(p.getId().equals(id)){
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> create(@RequestBody Product p){
        productList.add(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

    @PutMapping("/api/products/{id}")
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody Product p){
        for(Product prod: productList){
            if(prod.getId().equals(id)){
                prod.setName(p.getName());
                prod.setPrice(p.getPrice());
                prod.setQuantity(p.getQuantity());

                return ResponseEntity.ok(prod);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<Product> delete(@PathVariable String id){
        for(Product p: productList){
            if(p.getId().equals(id)){
                productList.remove(p);
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }


}
