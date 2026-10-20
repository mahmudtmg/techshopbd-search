package com.techshop.techshopsearch.controller;

import com.techshop.techshopsearch.model.SearchData;
import com.techshop.techshopsearch.model.SolrData;
import com.techshop.techshopsearch.service.ProductService;
import com.techshop.techshopsearch.model.Product;
import com.techshop.techshopsearch.service.SolrService;
import com.techshop.techshopsearch.solrConfiguration.SolrConfiguration;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static com.techshop.techshopsearch.solrConfiguration.SolrConfiguration.AUTO_COMPLETE_DATA_LIMIT;

/**
 * @author mahmud
 */
@RestController
@RequestMapping("/solrcontroller")
public class SolrController {

    private ProductService productService;
    private SolrService solrService;

    public SolrController(ProductService productService, SolrService solrService) {
        this.productService = productService;
        this.solrService = solrService;
    }

    @GetMapping("/indexproducts")
    public String getProducts() {
        List<Product> products = productService.getProducts();

        try {
            for (Product product : products) {
                solrService.solrIndexProduct(product);
            }
            solrService.solrSave();
            return "Indexed " + solrService.totalIndexedRecord() + " documents";
        } catch (SolrServerException | IOException e) {
            return "Not Indexed. Please check if Solr is running. " + e.getMessage();
        }
    }

    @GetMapping("/searchresult")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public SearchData searchResult(@RequestParam(value = "term") String term,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") Integer page
    ) throws IOException, SolrServerException {
        SearchData searchData = solrService.solrAutoComplete(term, page, AUTO_COMPLETE_DATA_LIMIT);
        return searchData;
    }

    @GetMapping("/totalindexed")
    public Long totalIndexed() throws IOException, SolrServerException {
        return solrService.totalIndexedRecord();
    }

    @GetMapping("/deleteIndex")
    public String deleteIndex() {
        return solrService.deleteAllIndexed() ? "Removed all documents" : "Can not delete documents";
    }
}
