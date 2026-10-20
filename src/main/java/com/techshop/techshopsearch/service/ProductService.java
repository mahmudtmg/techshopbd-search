package com.techshop.techshopsearch.service;

import com.techshop.techshopsearch.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author mahmud
 */
public interface ProductService {
    List<Product> getProducts();

    Optional getById(Long id);
}
