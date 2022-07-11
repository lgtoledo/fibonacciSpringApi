package com.lgtoledo.fibonacci.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.lgtoledo.fibonacci.FibonacciApplication;
import com.lgtoledo.fibonacci.service.TermService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = FibonacciApplication.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
//@AutoConfigureTestDatabase
public class FibonacciControllerIntegrationTest {
  
  @Autowired
  private MockMvc mvc;

  @Autowired
  private TermService termService;

  
  @Test
	public void givenNTerm_whenGetNTerm_thenStatus200() throws Exception {
    mvc.perform(get("/fibonacci/6").contentType(MediaType.APPLICATION_JSON))
    .andDo(print())
    .andExpect(status().isOk())
    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
    //.andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))))
    .andExpect(jsonPath("n", is(6)))
    .andExpect(jsonPath("value", is(8)));
  }


  @Test
  public void testReset() {

  }

  @BeforeAll
  static void beforeClass() {
    
  }

  @BeforeEach
  void setUp() {
    
  }

  @AfterEach
  void tearDown() {
    
  }

  @AfterAll
  static void afterClass() {
    
  }

  
}
