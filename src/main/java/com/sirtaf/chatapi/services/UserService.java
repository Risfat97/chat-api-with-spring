package com.sirtaf.chatapi.services;

import com.sirtaf.chatapi.dtos.UserDTO;
import com.sirtaf.chatapi.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<UserDTO> findAll();
    Optional<UserDTO> findById(UUID userId);
    Optional<UserDTO> save(User user);
    boolean deleteById(UUID userId);
    Optional<UserDTO> updateById(UUID userId, UserDTO user);
}
