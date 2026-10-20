package com.techshop.techshopsearch.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mahmud
 */
@Entity
@Table(name = "dm_page_translation")
@Data
public class DmPageTranslation {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "slug")
    private String slug;
}
