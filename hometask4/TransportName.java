package com.htp.hometask4;

public class TransportName {
    private String transName;

    public TransportName() {
    }

    public TransportName(String transName) {
        this.transName = transName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransportName that = (TransportName) o;

        return transName != null ? transName.equals(that.transName) : that.transName == null;
    }

    @Override
    public int hashCode() {
        return transName != null ? transName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TransportName{" +
                "transName='" + transName + '\'' +
                '}';
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }
}
