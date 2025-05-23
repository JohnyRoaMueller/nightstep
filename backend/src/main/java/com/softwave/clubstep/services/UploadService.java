package com.softwave.clubstep.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.Format;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.softwave.clubstep.domain.entities.UserAuth;

@Service
public class UploadService {

    Logger logger = LoggerFactory.getLogger(UploadService.class);
    
    public void addImages(List<MultipartFile> images, String username) throws IOException {
        for (MultipartFile image : images) {

            logger.info("addImages begins");

            String currentFileName = image.getOriginalFilename();
            if (currentFileName.startsWith("/uploads/host_images")) {
                logger.info("file '{}' already exists", currentFileName);
                continue;
            }
            logger.info("new file: {}", currentFileName);
            String newImagePath = String.format("./uploads/host_images/%s/%s", username, currentFileName);
            logger.info("newImagePath: ./uploads/host_images/{}/{}", username, currentFileName);


            String newDirPath = String.format("./uploads/host_images/%s", username);
            if (!new File(newDirPath).exists() && !new File(newDirPath).isDirectory()) {
                new File(newDirPath).mkdirs();
            }

            InputStream initialStream  = image.getInputStream();
            byte[] buffer = new byte[initialStream.available()];
            initialStream.read(buffer);



            File targetFile = new File(newImagePath);

            try (OutputStream outStream = new FileOutputStream(targetFile)) {
                outStream.write(buffer);
            }
        }
    }
}
