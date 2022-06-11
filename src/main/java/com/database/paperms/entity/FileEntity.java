package com.database.paperms.entity;

public class FileEntity {
    String path;
    String fileName;
    Double fileSize;

    public FileEntity(String path, String fileName, Double fileSize) {
        this.path = path;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public FileEntity() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }
}