package com.entity;

import com.annotation.Entity;

@SuppressWarnings("serial")
@Entity
public class ProductBean {

    private Product product;
    private ProductType productType;

    public ProductBean(Product product, ProductType productType) {
        this.product = product;
        this.productType = productType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
