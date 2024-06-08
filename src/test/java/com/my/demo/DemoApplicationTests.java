package com.my.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	int port;

	@Test
	void testHello() throws Exception {
		assertThat(restTemplate.getForObject("http://localhost:" + port, String.class), is("Hello World!"));
	}
}
