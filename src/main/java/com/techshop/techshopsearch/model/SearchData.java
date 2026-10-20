package com.techshop.techshopsearch.model;

import lombok.Data;

import java.util.List;

/**
 * @author mahmud
 */
@Data
public class SearchData {
    private Long totalSearchedRecord;
    private Integer limit;
    private Integer offset;
    private List<SolrData> dataList;
}
