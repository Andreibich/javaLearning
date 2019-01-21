package com.htp.stock.domain.to;

import java.io.Serializable;

public class ProductCatalog implements Serializable {

    private static final long serialVersionUID;

    static {
        serialVersionUID = 1L;
    }

    private Long productId;
    private String productName;
    private String productUnit;

    public ProductCatalog() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }
}
