package com.htp.stock.domain.to;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Shipment implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return Objects.equals(shipmentId, shipment.shipmentId) &&
                Objects.equals(shipmentDate, shipment.shipmentDate) &&
                Objects.equals(recepientCompanyId, shipment.recepientCompanyId) &&
                Objects.equals(productCatalogId, shipment.productCatalogId) &&
                Objects.equals(shipmentQuantity, shipment.shipmentQuantity) &&
                Objects.equals(shipmentPrice, shipment.shipmentPrice) &&
                Objects.equals(invoiceNumber, shipment.invoiceNumber) &&
                Objects.equals(proxyNumber, shipment.proxyNumber) &&
                Objects.equals(shipmentUserId, shipment.shipmentUserId) &&
                Objects.equals(recepientEmployeeName, shipment.recepientEmployeeName) &&
                Objects.equals(operationCodeId, shipment.operationCodeId) &&
                Objects.equals(recepientCompanyName, shipment.recepientCompanyName) &&
                Objects.equals(productCatalogName, shipment.productCatalogName) &&
                Objects.equals(productCatalogUnit, shipment.productCatalogUnit) &&
                Objects.equals(shipmentUserSurname, shipment.shipmentUserSurname) &&
                Objects.equals(operationCodePurpose, shipment.operationCodePurpose);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shipmentId, shipmentDate, recepientCompanyId, productCatalogId, shipmentQuantity, shipmentPrice, invoiceNumber, proxyNumber, shipmentUserId, recepientEmployeeName, operationCodeId, recepientCompanyName, productCatalogName, productCatalogUnit, shipmentUserSurname, operationCodePurpose);
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId=" + shipmentId +
                ", shipmentDate='" + shipmentDate + '\'' +
                ", recepientCompanyId=" + recepientCompanyId +
                ", productCatalogId=" + productCatalogId +
                ", shipmentQuantity=" + shipmentQuantity +
                ", shipmentPrice=" + shipmentPrice +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", proxyNumber=" + proxyNumber +
                ", shipmentUserId=" + shipmentUserId +
                ", recepientEmployeeName='" + recepientEmployeeName + '\'' +
                ", operationCodeId=" + operationCodeId +
                ", recepientCompanyName='" + recepientCompanyName + '\'' +
                ", productCatalogName='" + productCatalogName + '\'' +
                ", productCatalogUnit='" + productCatalogUnit + '\'' +
                ", shipmentUserSurname='" + shipmentUserSurname + '\'' +
                ", operationCodePurpose='" + operationCodePurpose + '\'' +
                '}';
    }
}
