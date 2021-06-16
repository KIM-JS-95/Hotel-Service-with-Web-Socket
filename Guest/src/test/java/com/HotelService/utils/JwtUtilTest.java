package com.HotelService.utils;

import com.HotelService.entity.JwtUtil;
import io.jsonwebtoken.Claims;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class JwtUtilTest {

    private static final String SECRET = "12345678901234567890123456789012";

    private JwtUtil jwtUtil;

    @BeforeEach
    public void setUp() {
        jwtUtil = new JwtUtil(SECRET);
    }

    @Test
    public void createToken() {
        String token = jwtUtil.createToken("John","adb1234@gmail.com");

        Assertions.assertThat(token).contains(".");
    }

    @Test
    public void getCalims() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJlbWFpbCI6ImFkYjEyMzRAZ21haWwuY29tIiwibmFtZSI6IkpvaG4iLCJwaG9uZW51bSI6IjAxMC0xMjM0LTU2NzgifQ." +
                "COyZY-zBPKJ_o7sAh5lNSWk16wcPsCQvenDtfKsf_98";

        Claims claims = jwtUtil.getClaims(token);

        Assertions.assertThat(claims.get("email", String.class)).isEqualTo("adb1234@gmail.com");
        Assertions.assertThat(claims.get("name")).isEqualTo("John");
    }

}