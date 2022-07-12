package com.lgtoledo.fibonacci;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lgtoledo.fibonacci.data.model.Term;
import com.lgtoledo.fibonacci.data.repository.TermRepository;

@SpringBootApplication
public class FibonacciApplication {

	public static void main(String[] args) {
		SpringApplication.run(FibonacciApplication.class, args);
	}

	@Bean
  public CommandLineRunner init(TermRepository repository) {
    return (args) -> {
      // guardo los dos primeros terminos
      repository.save(new Term(0, 0));
      repository.save(new Term(1, 1));
			System.out.println();

    };
  }
}
