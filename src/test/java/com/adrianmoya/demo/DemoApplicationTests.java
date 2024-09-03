package com.adrianmoya.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.adrianmoya.demo.controller.DemoController;

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

}
