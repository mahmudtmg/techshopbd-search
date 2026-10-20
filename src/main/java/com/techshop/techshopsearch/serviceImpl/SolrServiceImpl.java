package com.techshop.techshopsearch.serviceImpl;

import com.techshop.techshopsearch.model.DmPage;
import com.techshop.techshopsearch.model.DmPageTranslation;
import com.techshop.techshopsearch.model.ProductDmMedia;
import com.techshop.techshopsearch.service.DMPageService;
import com.techshop.techshopsearch.service.DmPageTranslationService;
import org.apache.commons.lang3.StringUtils;
import com.techshop.techshopsearch.model.Product;
import com.techshop.techshopsearch.model.SearchData;
import com.techshop.techshopsearch.model.SolrData;
import com.techshop.techshopsearch.service.SolrService;
import com.techshop.techshopsearch.solrConfiguration.SolrConfiguration;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import static com.techshop.techshopsearch.solrConfiguration.SolrConfiguration.*;

@Service(value = "solrService")
public class SolrServiceImpl implements SolrService {

    private DMPageService dmPageService;
    private DmPageTranslationService dmPageTranslationService;

    @Autowired
    public SolrServiceImpl(DMPageService dmPageService, DmPageTranslationService dmPageTranslationService) {
        this.dmPageService = dmPageService;
        this.dmPageTranslationService = dmPageTranslationService;
    }

    @Override
    public void solrIndexProduct(Product product) throws IOException, SolrServerException {
        SolrInputDocument solrInputDocument = new SolrInputDocument();
        solrInputDocument.addField(ID, product.getId());
        solrInputDocument.addField(PRODUCT_NAME, product.getProductName());
        solrInputDocument.addField(MODEL_NO, StringUtils.isNotBlank(product.getModelNo()) ? product.getModelNo() : "");
        solrInputDocument.addField(PRICE, product.getPrice() != null ? product.getPrice() : 0.0);
        solrInputDocument.addField(UNIT_COST, product.getUnitCost() != null ? product.getUnitCost() : 0.0);
        solrInputDocument.addField(QUANTITY, product.getQuantity() != null ? product.getQuantity() : 0L);
        solrInputDocument.addField(DISCOUNT_RATE_1, product.getDiscountRate1() != null ? product.getDiscountRate1() : 0.0);
        solrInputDocument.addField(DISCOUNT_RATE_2, product.getDiscountRate2() != null ? product.getDiscountRate2() : 0.0);
        solrInputDocument.addField(OUT_OF_STOCK_QUANTITY, product.getOutofstockQuantity() != null ? product.getOutofstockQuantity() : 0);
        solrInputDocument.addField(IS_NEW, product.getIsNew() != null ? product.getIsNew() : "");
        solrInputDocument.addField(NEW_START_DATE, product.getNewStartDate() != null ? product.getNewStartDate() : "");
        solrInputDocument.addField(NEW_END_DATE, product.getNewEndDate() != null ? product.getNewEndDate() : "");
        solrInputDocument.addField(IS_ACTIVE, product.getIsActive() != null ? product.getIsActive() : "");
        solrInputDocument.addField(SELLING_QTY, product.getSellingQty() != null ? product.getSellingQty() : 0L);
        solrInputDocument.addField(IS_INTERNAL, product.getIsInternal() != null ? product.getIsInternal() : "");
        solrInputDocument.addField(MOQ, product.getMoq() != null ? product.getMoq() : 0L);
        solrInputDocument.addField(SELLING_PRICE, product.getSellingPrice() != null ? product.getSellingPrice() : 0.0);
        solrInputDocument.addField(SPECIAL_PRICE, product.getSpecialPrice() != null ? product.getSpecialPrice() : 0.0);
        solrInputDocument.addField(DISCOUNT_RATE_1_PRICE, product.getDiscountRate1Price() != null ? product.getDiscountRate1Price() : 0.0);
        solrInputDocument.addField(DISCOUNT_RATE_2_PRICE, product.getDiscountRate2Price() != null ? product.getDiscountRate2Price() : 0.0);
        solrInputDocument.addField(SPECIAL_START_DATE, product.getSpecialStartDate() != null ? product.getSpecialStartDate() : "");
        solrInputDocument.addField(SPECIAL_END_DATE, product.getSpecialEndDate() != null ? product.getSpecialEndDate() : "");
        solrInputDocument.addField(IS_GROUP_PRICE, product.getIsGroupPrice() != null ? product.getIsGroupPrice() : "");
        solrInputDocument.addField(PRODUCT_VAT, product.getProductVat() != null ? product.getProductVat() : 0.0);
        solrInputDocument.addField(GROSS_PROFIT_RATE, product.getGrossProfitRate() != null ? product.getGrossProfitRate() : 0.0);
        solrInputDocument.addField(GROSS_DISCOUNT_RATE_1, product.getGrossDiscountRate1() != null ? product.getGrossDiscountRate1() : 0.0);
        solrInputDocument.addField(GROSS_DISCOUNT_RATE_2, product.getGrossDiscountRate2() != null ? product.getGrossDiscountRate2() : 0.0);
        solrInputDocument.addField(PRODUCT_STOCK, StringUtils.isNotBlank(product.getProductStock()) ? product.getProductStock() : "");
        solrInputDocument.addField(SUPPLIER_STOCK, product.getSupplierStock() != null ? product.getSupplierStock() : "");
        solrInputDocument.addField(SUMMARY, StringUtils.isNotBlank(product.getSummary()) ? product.getSummary() : "");
        solrInputDocument.addField(DESCRIPTION, StringUtils.isNotBlank(product.getDescription()) ? product.getDescription() : "");
        solrInputDocument.addField(SPECIFICATION, StringUtils.isNotBlank(product.getSpecification()) ? product.getSpecification() : "");
        solrInputDocument.addField(IMAGE_ID, product.getDmMedia() != null ? product.getDmMedia().getFile() : "");
        try {
            solrInputDocument.addField(PRODUCT_TYPE, StringUtils.isNotBlank(product.getProductType()) ? product.getProductType() : "");
            solrInputDocument.addField(PRODUCT_CATEGORY_NAME, product.getProductCategory().getName() != null ? product.getProductCategory().getName() : "");
            solrInputDocument.addField(PRODUCT_CATEGORY_SLUG, product.getProductCategory().getSlug() != null ? product.getProductCategory().getSlug() : "");
            List<Long> categoryId = new ArrayList<>();
            if(product.getProductCategory() != null) {
                categoryId.add(product.getProductCategory().getId());

                if (product.getProductCategory().getRootId() != null) {
                    categoryId.add(product.getProductCategory().getRootId());
                }
            }
            solrInputDocument.addField(PRODUCT_CATEGORY_ID, product.getProductCategory() != null ? categoryId : "");

        } catch (NullPointerException e) {

        }
        String brand = "";
        try {
            solrInputDocument.addField(PRODUCT_BRAND_NAME, StringUtils.isNotBlank(product.getProductBrand().getName()) ? product.getProductBrand().getName() : "");
            solrInputDocument.addField(PRODUCT_BRAND_SLUG, StringUtils.isNotBlank(product.getProductBrand().getSlug()) ? product.getProductBrand().getSlug() : "");
            brand = product.getProductBrand().getName();
            solrInputDocument.addField(PRODUCT_BRAND_ID, product.getProductBrand().getId() != null ? product.getProductBrand().getId() : "");

        } catch (NullPointerException e) {

        }
        try {
            solrInputDocument.addField(PRODUCT_SUPPLIER_NAME, StringUtils.isNotBlank(product.getProductSupplier().getName()) ? product.getProductSupplier().getName() : "");
            solrInputDocument.addField(PRODUCT_SUPPLIER_SLUG, StringUtils.isNotBlank(product.getProductSupplier().getSlug()) ? product.getProductSupplier().getSlug() : "");
            solrInputDocument.addField(PRODUCT_SUPPLIER_ID, product.getProductSupplier().getId() != null ? product.getProductSupplier().getId() : "");
        } catch (NullPointerException e) {

        }
        try {
            solrInputDocument.addField(PRODUCT_VENDOR_NAME, StringUtils.isNotBlank(product.getProductVendor().getName()) ? product.getProductVendor().getName() : "");
            solrInputDocument.addField(PRODUCT_VENDOR_SLUG, StringUtils.isNotBlank(product.getProductVendor().getSlug()) ? product.getProductVendor().getSlug() : "");
            solrInputDocument.addField(PRODUCT_VENDOR_ID, product.getProductVendor().getId() != null ? product.getProductVendor().getId() : "");
        } catch (NullPointerException e) {

        }
        try {
            List<String> files = new ArrayList<>();
            for (ProductDmMedia productDmMedia : product.getProductDmMedia()) {
                files.add(productDmMedia.getDmMedia().getFile());
            }
            solrInputDocument.addField(PRODUCT_IMAGE_FILE, files);
        } catch (NullPointerException e) {

        }
        try {
            List<String> relPaths = new ArrayList<>();
            for (ProductDmMedia productDmMedia : product.getProductDmMedia()) {
                relPaths.add(productDmMedia.getDmMedia().getDmMediaFolder().getRelPath());
            }
            solrInputDocument.addField(PRODUCT_IMAGE_REL_PATH, relPaths);
        } catch (NullPointerException e) {

        }
        try {
            solrInputDocument.addField(PRODUCT_SLUG, product.getSlug());

            solrInputDocument.addField(AVERAGE_RATING, product.getAverageRating() != null ? product.getAverageRating() : 0.0);
            solrInputDocument.addField(NO_OF_REVIEWS, product.getNoOfReviews() != null ? product.getNoOfReviews() : 0L);

            solrInputDocument.addField(PRODUCT_WARRANTY_NAME, StringUtils.isNotBlank(product.getProductWarranty().getName()) ? product.getProductWarranty().getName() : "");
            solrInputDocument.addField(PRODUCT_WARRANTY_ID, product.getProductWarranty().getId() != null ? product.getProductWarranty().getId() : "");
        } catch (NullPointerException e) {

        }

        solrInputDocument.addField(SEARCH_BUCKET,
                product.getProductName() + ", " + product.getSlug() + ", " +
                        (StringUtils.isNotBlank(product.getModelNo()) ? product.getModelNo() : "") + ", " +
                        brand + ", " +
                        removeHtmlTags((StringUtils.isNotBlank(product.getSummary()) ? product.getSummary() : "")) + ", " + /*removeHtmlTags(product.getDescription()) + ", " +*/
                        removeHtmlTags((StringUtils.isNotBlank(product.getSpecification()) ? product.getSpecification() : ""))
        );
        SOLR_CLIENT.add(solrInputDocument);
    }

    @Override
    public void solrSave() throws IOException, SolrServerException {
        SOLR_CLIENT.commit();
    }

    @Override
    public SearchData solrAutoComplete(String term, int startFrom, int autoCompleteDataLimit) throws IOException, SolrServerException {
        SearchData searchData = new SearchData();
        term = removeColonFromSearchTerm(term);
        if (term != null && !term.equals("")) {
            searchData = SearchDataForAutoCompleteMenu(searchData, term, startFrom, autoCompleteDataLimit);
        }
        return searchData;
    }

    @Override
    public Long totalIndexedRecord() throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery("*:*");
        query.setRows(0);
        return SOLR_CLIENT.query(query).getResults().getNumFound();
    }

    @Override
    public Boolean deleteAllIndexed() {
        Boolean isDeleted;
        try {
            SolrConfiguration.SOLR_CLIENT.deleteByQuery("*:*");
            isDeleted = true;
            solrSave();
        } catch (IOException | SolrServerException e) {
            isDeleted = false;
        }
        return isDeleted;
    }

    private String removeColonFromSearchTerm(String term) {
        return term.replace(":", " ");
    }

    private SearchData SearchDataForAutoCompleteMenu(SearchData searchData, String term, int startFrom, int autoCompleteDataLimit) throws IOException, SolrServerException {
        SolrQuery query;
        query = solrMainEngine(term, startFrom, autoCompleteDataLimit);
        searchData = getSearchDataWithoutFacet(searchData, query);
        searchData.setOffset((startFrom - 1) * AUTO_COMPLETE_DATA_LIMIT);
        searchData.setLimit(AUTO_COMPLETE_DATA_LIMIT);
        return searchData;
    }

    private SolrQuery solrMainEngine(String term, int page, int perpage) {
        SolrQuery query = new SolrQuery();
        query.setQuery(SEARCH_BUCKET + ":(" + breakPhrase(term) + ")");
        query.setParam("fl",
                ID,
                PRODUCT_NAME,
                MODEL_NO,
                PRICE,
                UNIT_COST,
                QUANTITY,
                DISCOUNT_RATE_1,
                DISCOUNT_RATE_2,
                OUT_OF_STOCK_QUANTITY,
                IS_NEW,
                NEW_START_DATE,
                NEW_END_DATE,
                IS_ACTIVE,
                SELLING_QTY,
                IS_INTERNAL,
                MOQ,
                SELLING_PRICE,
                SPECIAL_PRICE,
                DISCOUNT_RATE_1_PRICE,
                DISCOUNT_RATE_2_PRICE,
                SPECIAL_START_DATE,
                SPECIAL_END_DATE,
                IS_GROUP_PRICE,
                PRODUCT_VAT,
                GROSS_PROFIT_RATE,
                GROSS_DISCOUNT_RATE_1,
                GROSS_DISCOUNT_RATE_2,
                PRODUCT_STOCK,
                SUPPLIER_STOCK,
                SUMMARY,
                DESCRIPTION,
                SPECIFICATION,
                IMAGE_ID,
                PRODUCT_CATEGORY_NAME,
                PRODUCT_CATEGORY_ID,
                PRODUCT_CATEGORY_SLUG,
                PRODUCT_BRAND_NAME,
                PRODUCT_BRAND_ID,
                PRODUCT_BRAND_SLUG,
                PRODUCT_SUPPLIER_NAME,
                PRODUCT_SUPPLIER_ID,
                PRODUCT_SUPPLIER_SLUG,
                PRODUCT_VENDOR_NAME,
                PRODUCT_VENDOR_ID,
                PRODUCT_VENDOR_SLUG,
                PRODUCT_IMAGE_FILE,
                PRODUCT_IMAGE_REL_PATH,
                PRODUCT_SLUG,
                AVERAGE_RATING,
                NO_OF_REVIEWS,
                PRODUCT_TYPE,
                PRODUCT_WARRANTY_NAME,
                PRODUCT_WARRANTY_ID

        );
        query.setStart(perpage * (page - 1));
        query.setRows(perpage);
        query.set("defType", "edismax");
        return query;
    }

    private SearchData getSearchDataWithoutFacet(SearchData searchData, SolrQuery query) throws IOException, SolrServerException {
        QueryResponse response = SOLR_CLIENT.query(query);
        SolrDocumentList results = response.getResults();
        DocumentObjectBinder documentObjectBinder = new DocumentObjectBinder();
        List<SolrData> solrData = documentObjectBinder.getBeans(SolrData.class, results);
        if (solrData != null) {
            searchData.setDataList(solrData);
            searchData.setTotalSearchedRecord(response.getResults().getNumFound());
        }
        return searchData;
    }

    private String removeHtmlTags(String property) {
        if (StringUtils.isEmpty(property)) {
            return property;
        }
        property = property.replaceAll("\\<.*?\\>", "");
        property = property.replaceAll("(\r\n|\n)", ", ");
        property = property.replaceAll("&nbsp;", " ");
        property = property.replaceAll("&deg;", "");
        property = property.replaceAll("&dagger;", "");
        property = property.replaceAll("&ge;", "");
        property = property.replaceAll("&lt; ", "");
        property = property.replaceAll("&ndash;", ":");
        return property;
    }

    private String breakPhrase(String text) {
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        StringBuilder term = new StringBuilder();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                term.append("+").append(text.substring(firstIndex, lastIndex)).append(SolrConfiguration.FUZZINESS).append(" ");
            }
        }
        return term.toString();
    }
}