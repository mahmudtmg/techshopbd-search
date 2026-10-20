package com.techshop.techshopsearch.repositoty;

import com.techshop.techshopsearch.model.DmPage;
import com.techshop.techshopsearch.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mahmud
 */
public interface DmPageRepository extends CrudRepository<DmPage, Long> {
    DmPage getByProductAndModule(Product product, String module);
}
