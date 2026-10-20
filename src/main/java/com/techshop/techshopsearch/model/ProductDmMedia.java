package com.techshop.techshopsearch.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author mahmud
 */
@Entity
@Table(name = "product_dm_media")
@Data
public class ProductDmMedia {

    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="dm_record_id")
    private Product product;
    @OneToOne
    @JoinColumn(name = "dm_media_id")
    private DmMedia dmMedia;
}
