package com.database.paperms.entity;

public class FileEntity {
    String path;
    String file_name;
    String file_size;

    public FileEntity(String path, String file_name, String file_size) {
        this.path = path;
        this.file_name = file_name;
        this.file_size = file_size;
    }

    public FileEntity() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_size() {
        return file_size;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
    }
}