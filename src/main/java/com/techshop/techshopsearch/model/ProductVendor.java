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
@Table(name = "vendor")
@Data
public class ProductVendor {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "shop_name")
    private String name;

    @Column(name = "slug")
    private String slug;
}
