package com.andrei.securitydemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

public class PasswordEncoderTest {

	@Test
	public void passwordEncoderTest() {

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String encode = passwordEncoder.encode("password123");

		System.out.println(encode);
	}

}
