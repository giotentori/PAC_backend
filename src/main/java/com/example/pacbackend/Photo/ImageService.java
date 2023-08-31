package com.example.pacbackend.Photo;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image findByFileName(String fileName) {
        Optional<Image> optionalImage = imageRepository.findByFileName(fileName);
        if(!optionalImage.isPresent())
            throw new IllegalStateException("Image not found");
        Image image = optionalImage.get();
        return image;
    }

    public String postImage (MultipartFile file) throws Exception {
        Image image = new Image();
        image.setFileName(file.getOriginalFilename());
        image.setMimeType(file.getContentType());
        image.setData(file.getBytes());
        image.setUriImage("http://localhost:8080/images/"+image.getFileName());
      

        imageRepository.save(image);
        return image.getUriImage();
    }

    public String postImage (Image image) throws Exception {
        imageRepository.save(image);
        return "http://localhost:8080/images/"+image.getFileName();
    }




}
