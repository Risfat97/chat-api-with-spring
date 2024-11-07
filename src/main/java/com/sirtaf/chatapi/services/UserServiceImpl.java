package com.sirtaf.chatapi.services;

import com.sirtaf.chatapi.dtos.UserDTO;
import com.sirtaf.chatapi.entities.User;
import com.sirtaf.chatapi.exceptions.NotSavedException;
import com.sirtaf.chatapi.mappers.UserMapper;
import com.sirtaf.chatapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(UUID userId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> save(User user) {
        user.setCreatedAt(LocalDateTime.now());
        Optional<UserDTO> userSaved;

        try {
            userSaved = Optional.ofNullable(userMapper.userToUserDto(
                    userRepository.save(user)
            ));
        } catch(Exception e) {
            throw new NotSavedException("A user with this username or email exists already.");
        }

        return userSaved;
    }

    @Override
    public boolean deleteById(UUID userId) {
        return false;
    }

    @Override
    public Optional<UserDTO> updateById(UUID userId, UserDTO user) {
        return Optional.empty();
    }
}
