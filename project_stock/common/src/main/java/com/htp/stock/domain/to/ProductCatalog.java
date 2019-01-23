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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCatalog that = (ProductCatalog) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        return productUnit != null ? productUnit.equals(that.productUnit) : that.productUnit == null;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productUnit != null ? productUnit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductCatalog{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productUnit='" + productUnit + '\'' +
                '}';
    }
}
