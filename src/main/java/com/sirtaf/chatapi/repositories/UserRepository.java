package com.sirtaf.chatapi.repositories;

import com.sirtaf.chatapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
