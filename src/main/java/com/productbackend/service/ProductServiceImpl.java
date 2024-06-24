package com.productbackend.service;

import com.productbackend.advisor.expections.NotFoundException;
import com.productbackend.controller.req.ProductRequest;
import com.productbackend.entity.Product;
import com.productbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        return repository.getProducts();
    }

    @Override
    public Product getById(Long id) {
        return repository.getProducts()
                .stream()
                .filter(product -> product.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public List<Product> save(ProductRequest request) {
        var id = (long) repository.getProducts().size() + 1;
        repository.getProducts().add(new Product(id, request.title(), request.price()));
        return repository.getProducts();
    }

    @Override
    public List<Product> deleteById(Long id) {
        repository.getProducts().removeIf(product -> product.getId().equals(id));
        return repository.getProducts();
    }
}
