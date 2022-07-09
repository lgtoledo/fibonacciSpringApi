package com.lgtoledo.fibonacci.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.lgtoledo.fibonacci.data.model.Term;

public interface TermRepository extends CrudRepository<Term, Long> {

}
