package com.lgtoledo.fibonacci.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgtoledo.fibonacci.data.model.Term;
import com.lgtoledo.fibonacci.data.repository.TermRepository;
import com.lgtoledo.fibonacci.data.model.Metric;

@Service
public class TermService {

  @Autowired
  private TermRepository repository;

  @Autowired
  private MetricService metricService;

  @Transactional
  public Term getTerm(long n) {
    
    Term term = new Term(n, calcFibonacci(n));

    metricService.save(new Metric(n, LocalDateTime.now()));

    return term;
  }

  @Transactional
  public void reset() {
    repository.deleteAll();
  }


  private long calcFibonacci(long n) {
    // Verifico si el número es 0 o 1
    if (n == 0) return 0;
    if (n == 1) return 1;

    Optional<Term> term = repository.findByN(n);
    if (term.isPresent()) {
      return term.get().getValue();
    }

    // Calculo el número
    long value = calcFibonacci(n-1) + calcFibonacci(n-2);
    Term t = new Term(n, value);
    repository.save(t);
    return value;
  }
  
  
}
