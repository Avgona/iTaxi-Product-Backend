package com.productbackend.repository;

import com.productbackend.entity.Product;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
    }

}
