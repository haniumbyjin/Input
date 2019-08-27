package com.confrence.service;

import com.confrence.exception.FileUploadException;
import com.confrence.property.FileUploadProperties;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    private final Path fileLocation;

    @Autowired
    public FileService(FileUploadProperties prop){
        this.fileLocation = Paths.get(prop.getUploadDir()).toAbsolutePath().normalize();

        try{
            Files.createDirectories(this.fileLocation);
        }catch (Exception e){
            throw new FileUploadException("파일을 업로드할 디렉토리 생성 불가", e);
        }
    }
}
