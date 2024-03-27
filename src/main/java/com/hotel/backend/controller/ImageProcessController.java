package com.hotel.backend.controller;

import com.hotel.backend.dto.ImageUploadResultDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
@RestController
@CrossOrigin(origins = "http://localhost:8081") // 프론트서버
public class ImageProcessController {

    private final String IMAGE_SERVER = "http://localhost:3081"; // 백엔드서버
    private final String PATH = "C:/image/";

    @PostMapping("/api/admin/board/write/upload")
    public ImageUploadResultDto uploadImage(@RequestParam("image") MultipartFile file) throws IOException {

        String uuid = UUID.randomUUID().toString();

        int extractorIndex = file.getOriginalFilename().lastIndexOf(".");
        String extractor = file.getOriginalFilename().substring(extractorIndex);
        String saveFileName = uuid + extractor;

        File folder = new File(PATH);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        FileCopyUtils.copy(file.getBytes(), new File(PATH + saveFileName));

        String accessUrl = IMAGE_SERVER + "/image?name=" + saveFileName;

        ImageUploadResultDto ImageUploadResultDto = new ImageUploadResultDto();
        ImageUploadResultDto.setStatus(200);
        ImageUploadResultDto.setImageAccessUrl(accessUrl);

        return ImageUploadResultDto;
    }

    @GetMapping("/image")
    public ResponseEntity<Resource> downloadImage(HttpServletRequest request) {

        String imageName = request.getParameter("name");
        Resource resource = new FileSystemResource(PATH + imageName);

        HttpHeaders header = new HttpHeaders();
        try {
            Path filePath = Paths.get(PATH + imageName);
            header.add("Content-Type", Files.probeContentType(filePath));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
    }


}