package com.example.Backend.mapper;

import com.example.Backend.entity.User;
import com.example.Backend.model.MregisterResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    MregisterResponse toRegisterResponse(User user);
}
