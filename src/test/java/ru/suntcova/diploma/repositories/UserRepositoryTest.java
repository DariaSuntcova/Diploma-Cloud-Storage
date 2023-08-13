package ru.suntcova.diploma.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import ru.suntcova.diploma.entity.Role;
import ru.suntcova.diploma.entity.User;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestPropertySource(locations = "classpath:application.properties")
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByLogin() {
        // given
        User user = new User(1L, "userTest", "testPassword", Role.USER);
        userRepository.save(user);
        // when
        Optional<User> optionalUser = userRepository.findByLogin("userTest");
        // then
        assertTrue(optionalUser.isPresent());
        assertThat(optionalUser.get()).isEqualTo(user);
    }

    @Test
    void testFindByLoginInvalidUser() {
        // when
        Optional<User> optionalUser = userRepository.findByLogin("userTestNew");
        // then
        assertThat(optionalUser.isPresent()).isEqualTo(false);
    }
}