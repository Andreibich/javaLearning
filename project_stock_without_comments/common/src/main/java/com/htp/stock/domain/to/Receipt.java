package com.htp.stock.domain.to;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Receipt implements Serializable {

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

@Override
public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(receiptId, receipt.receiptId) &&
        Objects.equals(receiptDate, receipt.receiptDate) &&
        Objects.equals(supplierId, receipt.supplierId) &&
        Objects.equals(productCatalogId, receipt.productCatalogId) &&
        Objects.equals(receiptQuantity, receipt.receiptQuantity) &&
        Objects.equals(receiptPrice, receipt.receiptPrice) &&
        Objects.equals(invoiceNumber, receipt.invoiceNumber) &&
        Objects.equals(receiptUserId, receipt.receiptUserId) &&
        Objects.equals(supplierName, receipt.supplierName) &&
        Objects.equals(productCatalogName, receipt.productCatalogName) &&
        Objects.equals(productCatalogUnit, receipt.productCatalogUnit) &&
        Objects.equals(receiptUserSurname, receipt.receiptUserSurname);
        }

@Override
public int hashCode() {

        return Objects.hash(receiptId, receiptDate, supplierId, productCatalogId, receiptQuantity, receiptPrice, invoiceNumber, receiptUserId, supplierName, productCatalogName, productCatalogUnit, receiptUserSurname);
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
        ", supplierName=" + supplierName +
        ", productCatalogName=" + productCatalogName +
        ", productCatalogUnit=" + productCatalogUnit +
        ", receiptUserSurname=" + receiptUserSurname +
        '}';
        }
        }
