package com.techshop.techshopsearch.serviceImpl;

import com.techshop.techshopsearch.repositoty.ProductRepository;
import com.techshop.techshopsearch.service.ProductService;
import com.techshop.techshopsearch.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author mahmud
 */
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional getById(Long id) {
        return productRepository.findById(id);
    }
}
