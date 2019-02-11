package com.htp.stock.domain.vo;

import java.io.Serializable;

public class ShipmentVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long shipmentId;
    private String shipmentDate;
    private Integer recepientCompanyId;
    private Integer productCatalogId;
    private Double shipmentQuantity;
    private Double shipmentPrice;
    private String invoiceNumber;
    private Integer proxyNumber;
    private Long shipmentUserId;
    private String recepientEmployeeName;
    private Integer operationCodeId;

    private String recepientCompanyName;
    private String productCatalogName;
    private String productCatalogUnit;
    private String shipmentUserSurname;
    private String operationCodePurpose;

    public ShipmentVO() {
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

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
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

    public String getRecepientCompanyName() {
        return recepientCompanyName;
    }

    public void setRecepientCompanyName(String recepientCompanyName) {
        this.recepientCompanyName = recepientCompanyName;
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

    public String getShipmentUserSurname() {
        return shipmentUserSurname;
    }

    public void setShipmentUserSurname(String shipmentUserSurname) {
        this.shipmentUserSurname = shipmentUserSurname;
    }

    public String getOperationCodePurpose() {
        return operationCodePurpose;
    }

    public void setOperationCodePurpose(String operationCodePurpose) {
        this.operationCodePurpose = operationCodePurpose;
    }
}
