package com.htp.stock.domain.to;

import java.io.Serializable;
import java.sql.Date;

public class Receipt implements Serializable {

    private static final long serialVersionUID;

    static {
        serialVersionUID = 1L;
    }

    private Long receiptId;
    private Date receiptDate;
    private Integer supplierId;
    private Integer productCatalogId;
    private Double receiptQuantity;
    private Double receiptPrice;
    private String invoiceNumber;
    private Long receiptUserId;

    public Receipt() {
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

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
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
}
