package com.techshop.techshopsearch.repositoty;

import com.techshop.techshopsearch.model.DmPageTranslation;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mahmud
 */
public interface DmPageTranslationRepository extends CrudRepository<DmPageTranslation, Long> {
    DmPageTranslation getById(Long id);
}
