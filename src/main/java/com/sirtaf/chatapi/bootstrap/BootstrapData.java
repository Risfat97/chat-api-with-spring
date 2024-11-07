package com.sirtaf.chatapi.bootstrap;

import com.sirtaf.chatapi.entities.User;
import com.sirtaf.chatapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {
    private final UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    public void loadUserData() {
        if (userRepository.count() == 0) {
            List<User> users = new ArrayList<>();

            users.add(createUser("John", "Doe", "johndoe", "john.doe@example.com", "test1234"));
            users.add(createUser("Jane", "Doe", "janedoe", "jane.doe@example.com", "test1234"));
            users.add(createUser("Henry", "Ford", "henryford", "henry.ford@example.com", "test1234"));
            users.add(createUser("Nicolas", "Tesla", "ntesla", "ntesla@example.com", "test1234"));
            users.add(createUser("Mike", "Ross", "mross", "mross@example.com", "test1234"));

            userRepository.saveAll(users);
        }
    }

    private User createUser(String firstname, String lastname, String username, String email, String password) {
        return User.builder()
                .firstname(firstname)
                .lastname(lastname)
                .username(username)
                .email(email)
                .password(password)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
