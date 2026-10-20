package com.techshop.techshopsearch.solrConfiguration;

import com.techshop.techshopsearch.model.SolrData;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

/**
 * @author mahmud
 */
public final class SolrConfiguration {
    private static final String SOLR_CORE = "techshopsearch";
    private static final String SOLR_HOST = "http://127.0.0.1:8983/solr/" + SOLR_CORE;
    public static final String FUZZINESS = " ~0.6";
    public static final SolrClient SOLR_CLIENT = new HttpSolrClient.Builder(SOLR_HOST).build();
    public static final int START_FROM = 1;
    public static final int AUTO_COMPLETE_DATA_LIMIT = 15;
    public static final int BROWSE_PAGE_DATA_LIMIT = 36;
    public static final int FACET_DATA_LIMIT = 10;
    public static final int DATA_LIMIT_FOR_ATOMIC_UPDATE = 500000;

    public static final String ID = "id";
    public static final String PRODUCT_NAME = "product_name";
    public static final String MODEL_NO = "model_no";
    public static final String PRICE = "price";
    public static final String UNIT_COST = "unit_cost";
    public static final String QUANTITY = "quantity";
    public static final String DISCOUNT_RATE_1 = "discount_rate_1";
    public static final String DISCOUNT_RATE_2 = "discount_rate_2";
    public static final String OUT_OF_STOCK_QUANTITY = "out_of_stock_quantity";
    public static final String IS_NEW = "is_new";
    public static final String NEW_START_DATE = "new_start_date";
    public static final String NEW_END_DATE = "new_end_date";
    public static final String IS_ACTIVE = "is_active";
    public static final String SELLING_QTY = "selling_qty";
    public static final String IS_INTERNAL = "is_internal";
    public static final String MOQ = "moq";
    public static final String SELLING_PRICE = "selling_price";
    public static final String SPECIAL_PRICE = "special_price";
    public static final String DISCOUNT_RATE_1_PRICE = "discount_rate_1_price";
    public static final String DISCOUNT_RATE_2_PRICE = "discount_rate_2_price";
    public static final String SPECIAL_START_DATE = "special_start_date";
    public static final String SPECIAL_END_DATE = "special_end_date";
    public static final String IS_GROUP_PRICE = "is_group_price";
    public static final String PRODUCT_VAT = "product_vat";
    public static final String GROSS_PROFIT_RATE = "gross_profit_rate";
    public static final String GROSS_DISCOUNT_RATE_1 = "gross_discount_rate_1";
    public static final String GROSS_DISCOUNT_RATE_2 = "gross_discount_rate_2";
    public static final String PRODUCT_STOCK = "product_stock";
    public static final String SUPPLIER_STOCK = "supplier_stock";
    public static final String IMAGE_ID = "image_id";
    public static final String SUMMARY = "summary";
    public static final String DESCRIPTION = "description";
    public static final String SPECIFICATION = "specification";

    public static final String PRODUCT_CATEGORY_NAME = "product_category_name";
    public static final String PRODUCT_CATEGORY_ID = "product_category_id";
    public static final String PRODUCT_CATEGORY_SLUG = "product_category_slug";
    public static final String PRODUCT_BRAND_NAME = "product_brand_name";
    public static final String PRODUCT_BRAND_ID = "product_brand_id";
    public static final String PRODUCT_BRAND_SLUG = "product_brand_slug";
    public static final String PRODUCT_SUPPLIER_NAME = "product_supplier_name";
    public static final String PRODUCT_SUPPLIER_ID = "product_supplier_id";
    public static final String PRODUCT_SUPPLIER_SLUG = "product_supplier_slug";
    public static final String PRODUCT_TYPE = "product_type";

    public static final String PRODUCT_VENDOR_NAME = "product_vendor_name";
    public static final String PRODUCT_VENDOR_ID = "product_vendor_id";
    public static final String PRODUCT_VENDOR_SLUG = "product_vendor_slug";

    public static final String PRODUCT_IMAGE_FILE = "product_image_file";
    public static final String PRODUCT_IMAGE_REL_PATH = "product_image_rel_path";
    public static final String PRODUCT_SLUG = "product_slug";
    public static final String AVERAGE_RATING = "average_rating";
    public static final String NO_OF_REVIEWS = "no_of_reviews";
    public static final String PRODUCT_WARRANTY_NAME = "product_warranty_name";
    public static final String PRODUCT_WARRANTY_ID = "product_warranty_id";


    public static final String SEARCH_BUCKET = "searchBucket";
}