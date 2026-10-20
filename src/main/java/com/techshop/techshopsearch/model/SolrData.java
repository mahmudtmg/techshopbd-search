package com.techshop.techshopsearch.model;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;
import java.util.List;

/**
 * @author mahmud
 */

/**
 * This is required to create index and managed-schema.
 * <p>
 * Properties and data types of managed-schema are created depending on this class.
 */
@Data
public class SolrData {

    @Field("id")
    private String id;
//    @Field("product_name")
    @Field("product_name")
    private String productName;
    @Field("model_no")
    private String modelNo;
    @Field("price")
    private Double price;
    @Field("unit_cost")
    private List<Double> unitCost;
    @Field("quantity")
    private List<Long >quantity;
    @Field("discount_rate_1")
    private Double discountRate1;
    @Field("discount_rate_2")
    private List<Double >discountRate2;
    @Field("out_of_stock_quantity")
    private List<Long >outofstockQuantity;
    @Field("is_new")
    private List<Boolean> isNew;
    @Field("new_start_date")
    private List<Date> newStartDate;
    @Field("new_end_date")
    private List<Date >newEndDate;
    @Field("is_active")
    private List<Boolean> isActive;
    @Field("selling_qty")
    private List<Long >sellingQty;
    @Field("is_internal")
    private List<Boolean> isInternal;
    @Field("moq")
    private List<Long >moq;
    @Field("selling_price")
    private Double sellingPrice;
    @Field("special_price")
    private List<Double> specialPrice;
    @Field("discount_rate_1_price")
    private List<Double> discountRate1Price;
    @Field("discount_rate_2_price")
    private List<Double> discountRate2Price;
    @Field("special_start_date")
    private List<Date> specialStartDate;
    @Field("special_end_date")
    private List<Date> specialEndDate;
    @Field("is_group_price")
    private List<Boolean> isGroupPrice;
    @Field("product_vat")
    private List<Double> productVat;
    @Field("gross_profit_rate")
    private List<Double> grossProfitRate;
    @Field("gross_discount_rate_1")
    private List<Double> grossDiscountRate1;
    @Field("gross_discount_rate_2")
    private List<Double> grossDiscountRate2;
    @Field("product_stock")
    private List<String> productStock;
    @Field("supplier_stock")
    private List<Boolean> supplierStock;
    @Field("image_id")
    private List<Long> imageId;
    @Field("summary")
    private List<String> summary;
    @Field("description")
    private List<String> description;
    @Field("specification")
    private List<String> specification;


    @Field("product_category_name")
    private List<String> productCategoryName;
    @Field("product_category_id")
    private List<Long> productCategoryID;
    @Field("product_category_slug")
    private List<String> productCategorySlug;
    @Field("product_brand_name")
    private String productBrandName;
    @Field("product_brand_id")
    private List<Long> productBrandID;
    @Field("product_brand_slug")
    private List<String> productBrandSlug;
    @Field("product_supplier_name")
    private List<String> productSupplierName;
    @Field("product_supplier_id")
    private List<Long> productSupplierID;
    @Field("product_supplier_slug")
    private List<String> productSupplierSlug;
    @Field("product_vendor_name")
    private List<String> productVendorName;
    @Field("product_vendor_id")
    private List<Long> productVendorID;
    @Field("product_vendor_slug")
    private List<String> productVendorSlug;
    @Field("product_type")
    private List<String> productType;

    @Field("product_image_file")
    private List<String> productImageFile;
    @Field("product_image_rel_path")
    private List<String> productImageRelPath;
    @Field("product_slug")
    private List<String> productSlug;
    @Field("average_rating")
    private List<Double> averageRating;
    @Field("no_of_reviews")
    private List<Long> noOfReviews;
    @Field("product_warranty_name")
    private String productWarrantyName;
    @Field("product_warranty_id")
    private List<Integer> productWarrantyID;

    @Field("searchbucket")
    private List<String> searchBucket;
}