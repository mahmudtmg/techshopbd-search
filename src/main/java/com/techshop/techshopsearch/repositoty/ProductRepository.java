package com.techshop.techshopsearch.repositoty;

import com.techshop.techshopsearch.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mahmud
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
}
