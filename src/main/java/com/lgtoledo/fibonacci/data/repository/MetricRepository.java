package com.lgtoledo.fibonacci.data.repository;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;

import com.lgtoledo.fibonacci.data.model.Metric;

public interface MetricRepository extends CrudRepository<Metric, Long> {

  public Iterable<Metric> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

  public Iterable<Metric> findBynTerm(int nTerm);

  public Iterable<Metric> findBynTermAndTimestampBetween(int nTerm, LocalDateTime start, LocalDateTime end);

}

