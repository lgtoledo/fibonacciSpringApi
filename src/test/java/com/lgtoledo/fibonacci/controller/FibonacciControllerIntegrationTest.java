package com.lgtoledo.fibonacci.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.lgtoledo.fibonacci.FibonacciApplication;
import com.lgtoledo.fibonacci.data.repository.TermRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = FibonacciApplication.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration
public class FibonacciControllerIntegrationTest {
  
  @Autowired
  private MockMvc mvc;

  @Autowired
  private TermRepository termRepository;
  
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
  public void testResetEndpoint() throws Exception{

    long count = termRepository.count();
    assertThat(count).isEqualTo(7);

    mvc.perform(get("/fibonacci/reset").contentType(MediaType.APPLICATION_JSON))
    .andDo(print())
    .andExpect(status().isOk())
    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    long countAfterReset = termRepository.count();
    assertThat(countAfterReset).isEqualTo(0);
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
