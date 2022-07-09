package com.lgtoledo.fibonacci.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgtoledo.fibonacci.data.model.Term;
import com.lgtoledo.fibonacci.data.repository.TermRepository;

@RestController
public class FibonacciController {
  long[] fibonacci = new long[93];
  
  TermRepository repository;

  @RequestMapping("/")
  public String Index() {
    return "Hola";
  }

  @RequestMapping("/fibonacci/{n}")
  public String fibonacci(@PathVariable int n) {
    if (n < 0) return "Error 1: Ingrese un valor mayor o igual a cero";

    if (n > 92) return "Error 2: Ingrese un valor menor o igual a 92 para evitar overflow del tipo -long-";
    
    repository.save(new Term(0, 0));

    return String.valueOf(calcFibonacci(n));
  }
  
  private long calcFibonacci(int n) {
    // Verifico si el número es 0 o 1
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }

    // Verifico si ya calculé el número
    if (n <= fibonacci.length) {
      return fibonacci[n];
    }else{
      // Calculo el número
      fibonacci[n] = calcFibonacci(n-1) + calcFibonacci(n-2);
      return fibonacci[n];
    }
  }

  

}