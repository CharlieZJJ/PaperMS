package com.database.paperms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResearchDirection implements Serializable {

    private static final long serialVersionUID = 1L;

    private String rdId;

    private String rdName;

}
