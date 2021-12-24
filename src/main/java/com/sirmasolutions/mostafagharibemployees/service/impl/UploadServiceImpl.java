package com.sirmasolutions.mostafagharibemployees.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.sirmasolutions.mostafagharibemployees.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;



@Service
public class UploadServiceImpl implements UploadService {

	@Override
	public String uploadFile(MultipartFile file, String UPLOAD_DIR) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			Path path = Paths.get(UPLOAD_DIR + fileName);
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}

}