package com.htp.stock.domain.to;

public class OperationCodes {

    private static final long serialVersionUID = 1L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationCodes that = (OperationCodes) o;

        if (operationCodeId != null ? !operationCodeId.equals(that.operationCodeId) : that.operationCodeId != null)
            return false;
        return purpose != null ? purpose.equals(that.purpose) : that.purpose == null;
    }

    @Override
    public int hashCode() {
        int result = operationCodeId != null ? operationCodeId.hashCode() : 0;
        result = 31 * result + (purpose != null ? purpose.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OperationCodes{" +
                "operationCodeId=" + operationCodeId +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
