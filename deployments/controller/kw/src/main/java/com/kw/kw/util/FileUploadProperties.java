package com.kw.kw.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.text.SimpleDateFormat;

@Configuration
@ConfigurationProperties("file")
@Getter
public class FileUploadProperties {
    @Value("${file.image_upload_path}")
    private String imageUploadPath;
    public String makeStoredPath(String fileExt){
        Long nano = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmSS.sss");
        String currentDate = simpleDateFormat.format(nano);
        String storedPath = this.imageUploadPath + currentDate + fileExt;
        return storedPath;
    }
}
