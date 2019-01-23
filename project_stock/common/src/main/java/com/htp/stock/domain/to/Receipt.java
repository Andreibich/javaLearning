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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        if (receiptId != null ? !receiptId.equals(receipt.receiptId) : receipt.receiptId != null) return false;
        if (receiptDate != null ? !receiptDate.equals(receipt.receiptDate) : receipt.receiptDate != null) return false;
        if (supplierId != null ? !supplierId.equals(receipt.supplierId) : receipt.supplierId != null) return false;
        if (productCatalogId != null ? !productCatalogId.equals(receipt.productCatalogId) : receipt.productCatalogId != null)
            return false;
        if (receiptQuantity != null ? !receiptQuantity.equals(receipt.receiptQuantity) : receipt.receiptQuantity != null)
            return false;
        if (receiptPrice != null ? !receiptPrice.equals(receipt.receiptPrice) : receipt.receiptPrice != null)
            return false;
        if (invoiceNumber != null ? !invoiceNumber.equals(receipt.invoiceNumber) : receipt.invoiceNumber != null)
            return false;
        return receiptUserId != null ? receiptUserId.equals(receipt.receiptUserId) : receipt.receiptUserId == null;
    }

    @Override
    public int hashCode() {
        int result = receiptId != null ? receiptId.hashCode() : 0;
        result = 31 * result + (receiptDate != null ? receiptDate.hashCode() : 0);
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (productCatalogId != null ? productCatalogId.hashCode() : 0);
        result = 31 * result + (receiptQuantity != null ? receiptQuantity.hashCode() : 0);
        result = 31 * result + (receiptPrice != null ? receiptPrice.hashCode() : 0);
        result = 31 * result + (invoiceNumber != null ? invoiceNumber.hashCode() : 0);
        result = 31 * result + (receiptUserId != null ? receiptUserId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptId=" + receiptId +
                ", receiptDate=" + receiptDate +
                ", supplierId=" + supplierId +
                ", productCatalogId=" + productCatalogId +
                ", receiptQuantity=" + receiptQuantity +
                ", receiptPrice=" + receiptPrice +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", receiptUserId=" + receiptUserId +
                '}';
    }
}
