package com.lgtoledo.fibonacci.data.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.lgtoledo.fibonacci.data.model.Term;

public interface TermRepository extends CrudRepository<Term, Long> {
  public Optional<Term> findByN(long n);
}
