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
@Table(name = "dm_media_folder")
@Data
public class DmMediaFolder {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "rel_path")
    private String relPath;
}
