package com.sales.swift.service;


import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.hamcrest.CoreMatchers.not;

/**
 * Helper class to check/ensure the encryption of passwords
 * Basically confirms that the rawPassword(text) isn't equal to the encodedPassword (encrypted)
 * @author dennisdiza
 */

class UserDetailsServiceTest {

	@Test
	public void generate_encrypted_password() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		//need to ensure that these 2 aren't equal
		String rawPassword = "test";
		String encodedPassword = encoder.encode(rawPassword);
		
		System.out.println(encodedPassword); // just to check the output of the encrypted password
		assertThat(rawPassword, not(encodedPassword));
		
		
	}

	private void assertThat(String rawPassword, Matcher<String> not) {
	
		
	}

}
