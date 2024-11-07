package com.sirtaf.chatapi.bootstrap;

import com.sirtaf.chatapi.entities.User;
import com.sirtaf.chatapi.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BootstrapDataTest {
    @Autowired
    UserRepository userRepository;

    BootstrapData bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapData(userRepository);
    }

    @Test
    void testRun() throws Exception {
        bootstrapData.run(null);

        assertThat(userRepository.count()).isEqualTo(5);

        User user = userRepository.findAll().get(0);
        assertThat(user.getUsername()).isEqualTo("johndoe");
    }
}
