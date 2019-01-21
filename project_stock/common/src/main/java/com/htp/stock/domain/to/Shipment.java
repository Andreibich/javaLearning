package com.htp.stock.domain.to;

import java.io.Serializable;
import java.sql.Date;

public class Shipment implements Serializable {

    private static final long serialVersionUID;

    static {
        serialVersionUID = 1L;
    }

    private Long shipmentId;
    private Date shipmentDate;
    private Integer recepientCompanyId;
    private Integer productCatalogId;
    private Double shipmentQuantity;
    private Double shipmentPrice;
    private String invoiceNumber;
    private Integer proxyNumber;
    private Long shipmentUserId;
    private String recepientEmployeeName;
    private Integer operationCodeId;

    public Shipment() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public Integer getRecepientCompanyId() {
        return recepientCompanyId;
    }

    public void setRecepientCompanyId(Integer recepientCompanyId) {
        this.recepientCompanyId = recepientCompanyId;
    }

    public Integer getProductCatalogId() {
        return productCatalogId;
    }

    public void setProductCatalogId(Integer productCatalogId) {
        this.productCatalogId = productCatalogId;
    }

    public Double getShipmentQuantity() {
        return shipmentQuantity;
    }

    public void setShipmentQuantity(Double shipmentQuantity) {
        this.shipmentQuantity = shipmentQuantity;
    }

    public Double getShipmentPrice() {
        return shipmentPrice;
    }

    public void setShipmentPrice(Double shipmentPrice) {
        this.shipmentPrice = shipmentPrice;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Integer getProxyNumber() {
        return proxyNumber;
    }

    public void setProxyNumber(Integer proxyNumber) {
        this.proxyNumber = proxyNumber;
    }

    public Long getShipmentUserId() {
        return shipmentUserId;
    }

    public void setShipmentUserId(Long shipmentUserId) {
        this.shipmentUserId = shipmentUserId;
    }

    public String getRecepientEmployeeName() {
        return recepientEmployeeName;
    }

    public void setRecepientEmployeeName(String recepientEmployeeName) {
        this.recepientEmployeeName = recepientEmployeeName;
    }

    public Integer getOperationCodeId() {
        return operationCodeId;
    }

    public void setOperationCodeId(Integer operationCodeId) {
        this.operationCodeId = operationCodeId;
    }
}
