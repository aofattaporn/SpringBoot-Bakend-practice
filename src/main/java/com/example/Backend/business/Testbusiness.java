package com.example.Backend.business;

import com.example.Backend.exception.BaseException;
import com.example.Backend.exception.FileException;
import com.example.Backend.exception.UserException;
import com.example.Backend.model.MregisterRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class Testbusiness {

    public String register(MregisterRequest request) throws BaseException {
        // valid null request
        if (request == null) {
            throw UserException.requestNull();
        }
        // validate email
        else if (Objects.isNull(request.getEmail())) {
            throw UserException.emailNull();
        }

        // validate...
        return "Hello world";
    }

    public String uploadProfilePicture(MultipartFile file) throws BaseException {
        if (file == null) {
            throw FileException.fileNull();
        }
        if (file.getSize() > 1048576 * 2) {
            throw FileException.fileMaxSize();
        }
        String contentType = file.getContentType();
        if (contentType == null) {
            throw FileException.fileunSupported();
        }
        List<String> supportedTypes = Arrays.asList("image/jpeg", "image/png");
        if (!supportedTypes.contains(contentType)) {
            throw FileException.fileunSupported();
        }

        // TODO : uploade file storage (AWS s3, etc...)
        try {
            byte[] bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Hello Attaporn";
    }

}
