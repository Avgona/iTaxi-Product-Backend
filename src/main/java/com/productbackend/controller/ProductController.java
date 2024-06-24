package com.productbackend.controller;

import com.productbackend.controller.req.ProductRequest;
import com.productbackend.entity.Product;
import com.productbackend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }


    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable long id) {
        return service.getById(id);
    }

    @PostMapping
    public List<Product> save(@Valid @RequestBody ProductRequest request) {
        return service.save(request);
    }

    @DeleteMapping("/{id}")
    public List<Product> deleteById(@PathVariable long id) {
        return service.deleteById(id);
    }
}
