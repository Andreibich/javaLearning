package com.htp.stock.domain.vo;

import java.io.Serializable;

public class ReceiptVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long receiptId;
    private String receiptDate;
    private Integer supplierId;
    private Integer productCatalogId;
    private Double receiptQuantity;
    private Double receiptPrice;
    private String invoiceNumber;
    private Long receiptUserId;

    private String supplierName;
    private String productCatalogName;
    private String productCatalogUnit;
    private String receiptUserSurname;


    public ReceiptVO() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getProductCatalogId() {
        return productCatalogId;
    }

    public void setProductCatalogId(Integer productCatalogId) {
        this.productCatalogId = productCatalogId;
    }

    public Double getReceiptQuantity() {
        return receiptQuantity;
    }

    public void setReceiptQuantity(Double receiptQuantity) {
        this.receiptQuantity = receiptQuantity;
    }

    public Double getReceiptPrice() {
        return receiptPrice;
    }

    public void setReceiptPrice(Double receiptPrice) {
        this.receiptPrice = receiptPrice;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Long getReceiptUserId() {
        return receiptUserId;
    }

    public void setReceiptUserId(Long receiptUserId) {
        this.receiptUserId = receiptUserId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getProductCatalogName() {
        return productCatalogName;
    }

    public void setProductCatalogName(String productCatalogName) {
        this.productCatalogName = productCatalogName;
    }

    public String getProductCatalogUnit() {
        return productCatalogUnit;
    }

    public void setProductCatalogUnit(String productCatalogUnit) {
        this.productCatalogUnit = productCatalogUnit;
    }

    public String getReceiptUserSurname() {
        return receiptUserSurname;
    }

    public void setReceiptUserSurname(String receiptUserSurname) {
        this.receiptUserSurname = receiptUserSurname;
    }
}