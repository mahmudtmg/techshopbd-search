package com.techshop.techshopsearch.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @author mahmud
 */

/**
 * This model is required to retrieve data from database.
 */
@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String productName;
    @Column(name = "model_no")
    private String modelNo;
    @Column(name = "price")
    private Float price;
    @Column(name = "unit_cost")
    private Float unitCost;
    @Column(name = "qunatity")
    private Long quantity;
    @Column(name = "discount_rate1")
    private Float discountRate1;
    @Column(name = "discount_rate2")
    private Float discountRate2;
    @Column(name = "outofstock_qunatity")
    private Long outofstockQuantity;
    @Column(name = "is_new")
    private Boolean isNew;
    @Column(name = "new_start_date")
    private Date newStartDate;
    @Column(name = "new_end_date")
    private Date newEndDate;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "selling_qty")
    private Long sellingQty;
    @Column(name = "is_internal")
    private Boolean isInternal;
    @Column(name = "moq")
    private Long moq;
    @Column(name = "selling_price")
    private Float sellingPrice;
    @Column(name = "special_price")
    private Float specialPrice;
    @Column(name = "discount_rate1_price")
    private Float discountRate1Price;
    @Column(name = "discount_rate2_price")
    private Float discountRate2Price;
    @Column(name = "special_start_date")
    private Date specialStartDate;
    @Column(name = "special_end_date")
    private Date specialEndDate;
    @Column(name = "is_group_price")
    private Boolean isGroupPrice;
    @Column(name = "product_vat")
    private Float productVat;
    @Column(name = "gross_profit_rate")
    private Float grossProfitRate;
    @Column(name = "gross_discount_rate1")
    private Float grossDiscountRate1;
    @Column(name = "gross_discount_rate2")
    private Float grossDiscountRate2;
    @Column(name = "product_stock")
    private String productStock;
    @Column(name = "supplier_stock")
    private Boolean supplierStock;
    @Column(name = "summary")
    private String summary;
    @Column(name = "description", columnDefinition = "longtext")
    private String description;
    @Column(name = "specification", columnDefinition = "longtext")
    private String specification;
    @Column(name = "slug")
    private String slug;
    @Column(name = "average_rating")
    private Float averageRating;
    @Column(name = "no_of_reviews")
    private Integer noOfReviews;
    @Column(name = "product_type")
    private String productType;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private DmMedia dmMedia;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_brand_id")
    private ProductBrand productBrand;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "warranty_id")
    private ProductWarranty productWarranty;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    private ProductSupplier productSupplier;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_id")
    private ProductVendor productVendor;
    @OneToMany(mappedBy = "product")
    private List<ProductDmMedia> productDmMedia;
}