package com.database.paperms.entity.vo;

import java.io.Serializable;
import java.util.Objects;

public class CitationLinkVO {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CitationLinkVO(String value) {
        this.value = value;
    }

    public CitationLinkVO() {
    }

}
