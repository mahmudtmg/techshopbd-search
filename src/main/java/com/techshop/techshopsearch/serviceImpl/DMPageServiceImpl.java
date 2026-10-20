package com.techshop.techshopsearch.serviceImpl;

import com.techshop.techshopsearch.model.DmPage;
import com.techshop.techshopsearch.model.Product;
import com.techshop.techshopsearch.repositoty.DmPageRepository;
import com.techshop.techshopsearch.service.DMPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mahmud
 */
@Service(value = "dMPageService")
public class DMPageServiceImpl implements DMPageService {

    private DmPageRepository dmPageRepository;

    @Autowired
    public DMPageServiceImpl(DmPageRepository dmPageRepository) {
        this.dmPageRepository = dmPageRepository;
    }

    @Override
    public DmPage getByProductAndModule(Product product, String module) {
        return dmPageRepository.getByProductAndModule(product, module);
    }
}
