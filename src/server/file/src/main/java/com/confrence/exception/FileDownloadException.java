package com.confrence.exception;

public class FileDownloadException extends  RuntimeException {
    public FileDownloadException(String msg){
        super(msg);
    }
}
