package com.example.demo.upload_and_download.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;

@Getter
@Setter
public class FileMetaData {

    private String fileName;
    private String url;
    private String mime;
    private long size;
    private Resource resource;

    public FileMetaData(String fileName, String url, String mime, long size) {
        this.fileName = fileName;
        this.url = url;
        this.mime = mime;
        this.size = size;
    }
}
