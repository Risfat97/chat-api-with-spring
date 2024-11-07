package com.sirtaf.chatapi.controllers;

import com.sirtaf.chatapi.dtos.UserDTO;
import com.sirtaf.chatapi.entities.User;
import com.sirtaf.chatapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    public static final String USER_PATH = "/api/v1/user";

    @PostMapping(USER_PATH)
    public ResponseEntity createUser(@RequestBody User user) {
        UserDTO savedUser = userService.save(user).orElse(null);

        if (savedUser == null) {
            return new ResponseEntity(HttpStatusCode.valueOf(400));
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", USER_PATH + "/" + savedUser.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = USER_PATH)
    public List<UserDTO> getAll() {
        return userService.findAll();
    }
}
