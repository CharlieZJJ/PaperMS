package com.database.paperms.entity;

import java.io.Serializable;
import java.math.BigInteger;

public class ResearchDirection implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigInteger rdId;

    private String rdName;

    public ResearchDirection(){
    }

    public ResearchDirection(BigInteger rdId, String rdName) {
        this.rdId = rdId;
        this.rdName = rdName;
    }

    public BigInteger getRdId() {
        return rdId;
    }

    public void setRdId(BigInteger rdId) {
        this.rdId = rdId;
    }

    public String getRdName() {
        return rdName;
    }

    public void setRdName(String rdName) {
        this.rdName = rdName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResearchDirection)) return false;

        ResearchDirection researchDirection = (ResearchDirection) o;

        if (!rdId.equals(researchDirection.rdId)) return false;
        return rdName.equals(researchDirection.rdName);
    }

    @Override
    public String toString() {
        return "ResearchDirection{" +
                "rdId=" + rdId +
                ", rdName='" + rdName +
                '}';
    }

    @Override
    public int hashCode() {
        int result = rdId.hashCode();
        result = 31 * result + rdName.hashCode();
        return result;
    }
}
