package com.sirtaf.chatapi.repositories;

import com.sirtaf.chatapi.bootstrap.BootstrapData;
import com.sirtaf.chatapi.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Rollback
    @Transactional
    @Test
    void testSaveUser() {
        User user = User.builder()
                .firstname("John")
                .lastname("Doe")
                .username("johndoe")
                .email("john.doe@example.com")
                .createdAt(LocalDateTime.now())
                .password("test1234")
                .build();

        User savedUser = userRepository.save(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isNotNull();
    }
    @Test
    void testSaveInvalidUser() {
        User user = User.builder()
                .firstname("Test")
                .lastname("Test")
                .build();

        assertThrows(DataIntegrityViolationException.class, () -> {
            userRepository.save(user);
        });
    }

    @Test
    void testSaveUserDuplicateUsername() throws Exception {
        BootstrapData bootstrapData = new BootstrapData(userRepository);
        bootstrapData.run(null);
        String username = "johndoe";

        User user1 = User.builder()
                .firstname("Test")
                .lastname("Test")
                .username(username)
                .email("test@example.com")
                .createdAt(LocalDateTime.now())
                .password("test1234")
                .build();

        assertThrows(DataIntegrityViolationException.class, () -> {
            userRepository.save(user1);
        });
    }

    @Test
    void testSaveUserDuplicateEmail() throws Exception {
        BootstrapData bootstrapData = new BootstrapData(userRepository);
        bootstrapData.run(null);
        String email = "john.doe@example.com";

        User user1 = User.builder()
                .firstname("Test")
                .lastname("Test")
                .username("test")
                .email(email)
                .createdAt(LocalDateTime.now())
                .password("test1234")
                .build();

        assertThrows(DataIntegrityViolationException.class, () -> {
            userRepository.save(user1);
        });
    }
}
