package ru.suntcova.diploma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.suntcova.diploma.entity.Role;
import ru.suntcova.diploma.entity.User;
import ru.suntcova.diploma.repositories.UserRepository;

@SpringBootApplication
public class DiplomaNewApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiplomaNewApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder encoder) {
//        return args -> {
//            if (userRepository.count() == 0) {
//                userRepository.save(User.builder()
//                        .login("user")
//                        .password(encoder.encode("user"))
//                        .role(Role.USER)
//                        .build());
//                userRepository.save(User.builder()
//                        .login("admin")
//                        .password(encoder.encode("admin"))
//                        .role(Role.ADMIN)
//                        .build());
//            }
//        };
//    }

}
