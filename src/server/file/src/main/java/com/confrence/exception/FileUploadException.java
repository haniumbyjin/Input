package com.confrence.exception;

public class FileUploadException extends RuntimeException {
    public FileUploadException(String msg, Exception e){
        super(msg);
    }
}
