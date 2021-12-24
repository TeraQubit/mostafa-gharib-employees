package com.sirmasolutions.mostafagharibemployees.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
     String uploadFile(MultipartFile file, String UPLOAD_DIR) throws IOException;
}