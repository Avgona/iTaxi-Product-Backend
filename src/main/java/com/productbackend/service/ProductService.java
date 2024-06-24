package com.productbackend.service;

import com.productbackend.controller.req.ProductRequest;
import com.productbackend.entity.Product;

import java.util.List;

public interface ProductService {


    List<Product> getAll();

    Product getById(Long id);

    List<Product> save(ProductRequest request);

    List<Product> deleteById(Long id);
}
