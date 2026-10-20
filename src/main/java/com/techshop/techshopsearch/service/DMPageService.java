package com.techshop.techshopsearch.service;

import com.techshop.techshopsearch.model.DmPage;
import com.techshop.techshopsearch.model.Product;

/**
 * @author mahmud
 */
public interface DMPageService {
    DmPage getByProductAndModule(Product product, String module);
}
