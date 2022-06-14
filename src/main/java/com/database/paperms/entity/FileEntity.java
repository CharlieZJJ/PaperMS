package com.database.paperms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileEntity {
    String path;

    String fileName;

    Double fileSize;
}