package com.sirtaf.chatapi.mappers;

import com.sirtaf.chatapi.dtos.UserDTO;
import com.sirtaf.chatapi.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User userDtoToUser(UserDTO dto);
    UserDTO userToUserDto(User user);
}
