package com.htp.stock.domain.to;

public class OperationCodes {

    private static final long serialVersionUID;

    static {
        serialVersionUID = 1L;
    }

    private Integer operationCodeId;
    private String purpose;

    public OperationCodes() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getOperationCodeId() {
        return operationCodeId;
    }

    public void setOperationCodeId(Integer operationCodeId) {
        this.operationCodeId = operationCodeId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
