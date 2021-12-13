/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exampleG8.Reto2Ciclo4.controller;


import com.exampleG8.Reto2Ciclo4.model.Clothe;
import com.exampleG8.Reto2Ciclo4.service.ProductService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author raque
 */
@RestController
@RequestMapping("/api/clothe/")
public class ProductController {
    
    @Autowired
    private ProductService ProdService;
    
    @GetMapping("/all")
    public List<Clothe> list() {
        return ProdService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional <Clothe> getProduct(@PathVariable String ref) {
        return ProdService.getByRef(ref);
    }
    
    @PostMapping("/new")
    public ResponseEntity<Clothe> saveProduct(@RequestBody Clothe prod) {
        Clothe newProduct = ProdService.save(prod);
        
        return new ResponseEntity(newProduct, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Clothe> updateProduct(@RequestBody Clothe prod) {
        Clothe upProduct = ProdService.update(prod);
        
        return new ResponseEntity(upProduct, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteProduct(@PathVariable("reference") String ref) {
        
        return ProdService.delete(ref);
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}
