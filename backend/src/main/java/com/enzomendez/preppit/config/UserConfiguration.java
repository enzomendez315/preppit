package com.enzomendez.preppit.config;

import com.enzomendez.preppit.user.Role;
import com.enzomendez.preppit.user.User;
import com.enzomendez.preppit.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfiguration {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository userRepository) {
        return args -> {
            User enzo = new User(
                    "Enzo",
                    "Mendez",
                    "enzomendez",
                    "enzo@gmail.com",
                    "password",
                    Role.USER
            );

            User said = new User(
                    "Said",
                    "Mendez",
                    "saidmendez",
                    "said@gmail.com",
                    "password",
                    Role.USER
            );

            userRepository.saveAll(List.of(enzo, said));
        };
    }
}
