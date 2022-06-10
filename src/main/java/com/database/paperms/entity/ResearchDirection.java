package com.database.paperms.entity;

import java.io.Serializable;

public class ResearchDirection implements Serializable {

    private static final long serialVersionUID = 1L;

    private String rdId;

    private String rdName;

    public ResearchDirection() {
    }

    public ResearchDirection(String rdId, String rdName) {
        this.rdId = rdId;
        this.rdName = rdName;
    }

    public String getRdId() {
        return rdId;
    }

    public void setRdId(String rdId) {
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
