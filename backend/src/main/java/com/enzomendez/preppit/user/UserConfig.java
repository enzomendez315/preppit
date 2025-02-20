package com.enzomendez.preppit.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository userRepository) {
        return args -> {
            User enzo = new User(
                    "Enzo",
                    "Mendez",
                    "enzomendez",
                    "enzo@gmail.com",
                    "password"
            );

            User said = new User(
                    "Said",
                    "Mendez",
                    "saidmendez",
                    "said@gmail.com",
                    "password"
            );

            userRepository.saveAll(List.of(enzo, said));
        };
    }
}
