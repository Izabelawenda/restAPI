package com.store.restAPI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Test
	// todo: the test actually fails if there is no MySQL available. It is possible to start HP (in memory database) just for testing.
	// I believe it can be achieved by adding one more "application.properties" file to test/resources folder
	// more details: with examples how to achieve it: https://www.baeldung.com/spring-testing-separate-data-source
	void contextLoads() {
	}

}
