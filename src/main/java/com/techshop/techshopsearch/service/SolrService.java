package com.techshop.techshopsearch.service;

import com.techshop.techshopsearch.model.Product;
import com.techshop.techshopsearch.model.SearchData;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * @author mahmud
 */
public interface SolrService {
    void solrIndexProduct(Product product) throws IOException, SolrServerException;

    void solrSave() throws IOException, SolrServerException;

    SearchData solrAutoComplete(String term, int startFrom, int autoCompleteDataLimit) throws IOException, SolrServerException;

    Long totalIndexedRecord() throws IOException, SolrServerException;

    Boolean deleteAllIndexed();
}
