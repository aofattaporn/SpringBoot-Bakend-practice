package com.example.Backend.business;

import com.example.Backend.entity.User;
import com.example.Backend.exception.BaseException;
import com.example.Backend.exception.FileException;
import com.example.Backend.exception.UserException;
import com.example.Backend.mapper.UserMapper;
import com.example.Backend.model.MloginRequest;
import com.example.Backend.model.MregisterRequest;
import com.example.Backend.model.MregisterResponse;
import com.example.Backend.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class Userbusiness {

    // Injection UserService
    private final UserService userService;
    private final UserMapper userMapper;

    public Userbusiness(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    // register response
    public MregisterResponse register(MregisterRequest request) throws BaseException {
        User user = userService.create(request.getEmail(), request.getPassword(), request.getName());
        MregisterResponse model = userMapper.toRegisterResponse(user);

        return model;

    }

    // login response
    public String login(MloginRequest request) throws UserException   {
        // validate request

        // validate database
        Optional<User> opt = userService.findByEmail(request.getEmail());
        if( opt.isEmpty() ){
            throw UserException.loginFailEmailNotFound();
        }
        User user = opt.get();
        if ( !userService.matchPassword(request.getPassword(), user.getPassword())){
            throw UserException.loginFailPasswordIncorrect();
        }

        // TODO: generate JWT
        String token = "JWT TO DO";

        return token;
    }


    // uploadProfilePicture
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
