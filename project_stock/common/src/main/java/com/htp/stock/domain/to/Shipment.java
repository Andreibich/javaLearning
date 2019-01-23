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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shipment shipment = (Shipment) o;

        if (shipmentId != null ? !shipmentId.equals(shipment.shipmentId) : shipment.shipmentId != null) return false;
        if (shipmentDate != null ? !shipmentDate.equals(shipment.shipmentDate) : shipment.shipmentDate != null)
            return false;
        if (recepientCompanyId != null ? !recepientCompanyId.equals(shipment.recepientCompanyId) : shipment.recepientCompanyId != null)
            return false;
        if (productCatalogId != null ? !productCatalogId.equals(shipment.productCatalogId) : shipment.productCatalogId != null)
            return false;
        if (shipmentQuantity != null ? !shipmentQuantity.equals(shipment.shipmentQuantity) : shipment.shipmentQuantity != null)
            return false;
        if (shipmentPrice != null ? !shipmentPrice.equals(shipment.shipmentPrice) : shipment.shipmentPrice != null)
            return false;
        if (invoiceNumber != null ? !invoiceNumber.equals(shipment.invoiceNumber) : shipment.invoiceNumber != null)
            return false;
        if (proxyNumber != null ? !proxyNumber.equals(shipment.proxyNumber) : shipment.proxyNumber != null)
            return false;
        if (shipmentUserId != null ? !shipmentUserId.equals(shipment.shipmentUserId) : shipment.shipmentUserId != null)
            return false;
        if (recepientEmployeeName != null ? !recepientEmployeeName.equals(shipment.recepientEmployeeName) : shipment.recepientEmployeeName != null)
            return false;
        return operationCodeId != null ? operationCodeId.equals(shipment.operationCodeId) : shipment.operationCodeId == null;
    }

    @Override
    public int hashCode() {
        int result = shipmentId != null ? shipmentId.hashCode() : 0;
        result = 31 * result + (shipmentDate != null ? shipmentDate.hashCode() : 0);
        result = 31 * result + (recepientCompanyId != null ? recepientCompanyId.hashCode() : 0);
        result = 31 * result + (productCatalogId != null ? productCatalogId.hashCode() : 0);
        result = 31 * result + (shipmentQuantity != null ? shipmentQuantity.hashCode() : 0);
        result = 31 * result + (shipmentPrice != null ? shipmentPrice.hashCode() : 0);
        result = 31 * result + (invoiceNumber != null ? invoiceNumber.hashCode() : 0);
        result = 31 * result + (proxyNumber != null ? proxyNumber.hashCode() : 0);
        result = 31 * result + (shipmentUserId != null ? shipmentUserId.hashCode() : 0);
        result = 31 * result + (recepientEmployeeName != null ? recepientEmployeeName.hashCode() : 0);
        result = 31 * result + (operationCodeId != null ? operationCodeId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId=" + shipmentId +
                ", shipmentDate=" + shipmentDate +
                ", recepientCompanyId=" + recepientCompanyId +
                ", productCatalogId=" + productCatalogId +
                ", shipmentQuantity=" + shipmentQuantity +
                ", shipmentPrice=" + shipmentPrice +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", proxyNumber=" + proxyNumber +
                ", shipmentUserId=" + shipmentUserId +
                ", recepientEmployeeName='" + recepientEmployeeName + '\'' +
                ", operationCodeId=" + operationCodeId +
                '}';
    }
}
