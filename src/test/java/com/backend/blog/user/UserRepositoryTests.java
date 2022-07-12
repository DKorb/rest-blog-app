package com.backend.blog.user;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class UserRepositoryTests {

    private static final String TEST_EMAIL = "test@test.java";
    private static final String TEST_NAME = "test_name";
    private static final String TEST_PASSWORD = "test123";
    private static final Integer TEST_AGE = 99;
    private static final String TEST_CITY = "test_city";
    private static final String TEST_DESCRIPTION = "test_description";

    private static final String TEST_USERNAME = "test_user";

    private static final String TEST_NEW_USERNAME = "new_test_user";

    private static final String NEW_TEST_NAME = "new_test_name";

    private static final String NEW_TEST_EMAIL = "new_test@test.java";


    @Autowired
    UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setup() {
        user = User.builder()
                .email(TEST_EMAIL)
                .gender(Gender.MALE)
                .name(TEST_NAME)
                .password(TEST_PASSWORD)
                .username(TEST_USERNAME)
                .userDetails(userDetails.builder()
                        .age(TEST_AGE)
                        .city(TEST_CITY)
                        .description(TEST_DESCRIPTION)
                        .build())
                .build();
    }

    @Test
    public void givenUserList_whenFindAll_thenReturnUserList() {

        //given
        userRepository.save(user);

        //when
        List<User> listAllUsers = userRepository.findAll();

        //then
        assertThat(listAllUsers).isNotNull();
        assertThat(listAllUsers.size()).isEqualTo(3);

    }

    @Test
    public void givenUserEmail_whenFindByEmail_thenReturnUserObject() {

        //given
        userRepository.save(user);

        //when
        var userByEmail = userRepository
                .findByEmail(user.getEmail()).get();

        //then
        assertThat(userByEmail).isNotNull();

    }

    @Test
    public void givenUsername_whenFindByUsername_thenReturnUserObject() {

        //given
        userRepository.save(user);

        //when
        var userByUserName = userRepository
                .findByUsername(user.getUsername()).get();

        //then
        assertThat(userByUserName).isNotNull();

    }

    @Test
    public void givenUserEmailAndUsername_whenFindByUsernameOrEmail_thenReturnUserObject() {

        //given
        userRepository.save(user);

        //when
        var userByUserNameOrEmail = userRepository
                .findByUsernameOrEmail(user.getUsername(), user.getEmail()).get();

        //then
        assertThat(userByUserNameOrEmail).isNotNull();

    }

    @Test
    public void givenUsername_whenUserExists_thenReturnTrue() {

        //given
        userRepository.save(user);

        //when
        var username = userRepository
                .existsByUsername(user.getUsername());

        //then
        assertThat(username).isTrue();

    }

    @Test
    public void givenEmail_whenUserExists_thenReturnTrue() {

        //given
        userRepository.save(user);

        //when
        var userEmail = userRepository
                .existsByEmail(user.getEmail());

        //then
        assertThat(userEmail).isTrue();

    }

    @Test
    public void givenUserObject_whenUpdateUser_thenReturnUpdatedUser() {

        // given
        userRepository.save(user);

        // when
        var userById = userRepository
                .findById(user.getId()).get();

        userById.setEmail(NEW_TEST_EMAIL);
        userById.setName(NEW_TEST_NAME);
        userById.setUsername(TEST_NEW_USERNAME);

        var updatedUser = userRepository.save(userById);

        //then
        assertThat(updatedUser.getEmail()).isEqualTo(NEW_TEST_EMAIL);
        assertThat(updatedUser.getName()).isEqualTo(NEW_TEST_NAME);
        assertThat(updatedUser.getUsername()).isEqualTo(TEST_NEW_USERNAME);
    }

}