package com.htp.stock.domain.to;

import java.io.Serializable;

public class Companies implements Serializable {
    private static final long serialVersionUID;

    static {
        serialVersionUID = 1L;
    }

    private Long companyId;
    private String companyName;
    private String city;
    private String address;

    public Companies() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Companies companies = (Companies) o;

        if (companyId != null ? !companyId.equals(companies.companyId) : companies.companyId != null) return false;
        if (companyName != null ? !companyName.equals(companies.companyName) : companies.companyName != null)
            return false;
        if (city != null ? !city.equals(companies.city) : companies.city != null) return false;
        return address != null ? address.equals(companies.address) : companies.address == null;
    }

    @Override
    public int hashCode() {
        int result = companyId != null ? companyId.hashCode() : 0;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Companies{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
