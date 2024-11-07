package com.sirtaf.chatapi.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class UserDTO {
    private UUID id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private LocalDateTime createdAt;
}
