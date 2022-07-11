package com.lgtoledo.fibonacci;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lgtoledo.fibonacci.controller.FibonacciController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private FibonacciController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}