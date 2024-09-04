package com.adrianmoya.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.adrianmoya.demo.controller.DemoController;
import com.adrianmoya.demo.model.ProcessResponse;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	// The hello() method returns the string "Hello" when accessed via HTTP GET request
    @Test
    public void test_hello_returns_hello_string() {
        DemoController controller = new DemoController();
        String response = controller.hello();
        assertEquals("Hello", response);
    }

		@Test
		public void test_post_request_success() {
			DemoController controller = new DemoController();
			ResponseEntity<ProcessResponse> response = controller.process();
			assertTrue(response.getStatusCode().is2xxSuccessful());
			assertNotNull(response.getBody());
			assertEquals("Hello", response.getBody().message());
		}
}
