package com.theer.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class UploadService {
    private final ServletContext servletContext;

    public UploadService(ServletContext servletContext) {

        this.servletContext = servletContext;
    }

    public String handleSaveUploadFile(MultipartFile file, String tagetFolder) {
        String rootPath = this.servletContext.getRealPath("/resources/images");
        String finalName = "";
        try {
            // Lấy dữ liệu bytes từ file được upload
            byte[] bytes;
            bytes = file.getBytes();

            // Lấy đường dẫn thực tới thư mục lưu ảnh trong thư mục webapp

            // Tạo thư mục 'avatar' nếu chưa tồn tại
            File dir = new File(rootPath + File.separator + "tagetFolder");
            if (!dir.exists())
                dir.mkdirs();
            // Tạo file mới trên server với tên có gắn timestamp để tránh trùng
            finalName = dir.getAbsolutePath() + File.separator + System.currentTimeMillis() + "-"
                    + file.getOriginalFilename();
            File serverFile = new File(finalName);

            // Ghi dữ liệu file vào server
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalName;
    }
}
