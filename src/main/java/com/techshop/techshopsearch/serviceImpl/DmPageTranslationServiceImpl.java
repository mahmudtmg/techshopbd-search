package com.techshop.techshopsearch.serviceImpl;

import com.techshop.techshopsearch.model.DmPageTranslation;
import com.techshop.techshopsearch.repositoty.DmPageTranslationRepository;
import com.techshop.techshopsearch.service.DmPageTranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mahmud
 */
@Service(value = "dmPageTranslationService")
public class DmPageTranslationServiceImpl implements DmPageTranslationService {

    private DmPageTranslationRepository dmPageTranslationRepository;

    @Autowired
    public DmPageTranslationServiceImpl(DmPageTranslationRepository dmPageTranslationRepository) {
        this.dmPageTranslationRepository = dmPageTranslationRepository;
    }

    @Override
    public DmPageTranslation getById(Long id) {
        return dmPageTranslationRepository.getById(id);
    }
}
