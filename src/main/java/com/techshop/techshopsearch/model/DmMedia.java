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
@Table(name = "dm_media")
@Data
public class DmMedia {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "file")
    private String file;

    @OneToOne
    @JoinColumn(name = "dm_media_folder_id")
    private DmMediaFolder dmMediaFolder;
}
