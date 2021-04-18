package com.AbstractCnS.entity;

import com.AbstractCnS.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class JwtUtilTest {

    private static final String SECRET = "12345678901234567890123456789012";

    @Autowired
    private JwtUtil jwtUtil;

    @BeforeEach
    public void setUp() {
        jwtUtil = new JwtUtil(SECRET);
    }

    @Test
    public void createToken() {

        String email = "admin@exmaple.com";
        String name = "Administrator";

        String token = jwtUtil.createToken(email, name);

       System.out.println(token);
        assertThat(token).contains(".");
    }
}