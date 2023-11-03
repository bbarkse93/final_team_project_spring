package com.example.team_project.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.*;

@DataJpaTest
public class UserJPARepository_test {

    @Autowired
    private UserJPARepository_test userJPARepository;

    @Test
    public void mUpdateUser(int id, String username, String password) {
        // User user = userJPARepository.mUpdateUser(1, "ssar1", "1q2w3e4r@");

        System.out.println();
    }

}
