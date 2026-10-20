package com.techshop.techshopsearch.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author mahmud
 */
@Entity
@Table(name = "dm_page")
@Data
public class DmPage {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "module")
    private String module;
    @OneToOne
    @JoinColumn(name = "record_id")
    private Product product;
}
