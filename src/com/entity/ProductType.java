package com.entity;

import com.annotation.Entity;


@SuppressWarnings("serial")
@Entity
public class ProductType{

    private String productTypeName;

    private String productTypeCode;

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }
}
