package com.lgtoledo.fibonacci.data.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lgtoledo.fibonacci.data.model.Metric;

public interface MetricRepository extends CrudRepository<Metric, Long> {

  public Iterable<Metric> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

  public Iterable<Metric> findBynTerm(long nTerm);

  public Iterable<Metric> findBynTermAndTimestampBetween(long nTerm, LocalDateTime start, LocalDateTime end);

  @Query(value = "SELECT n_term, COUNT(n_term) AS freq FROM Metric GROUP BY n_term ORDER BY freq DESC LIMIT 3", nativeQuery = true)
  public Iterable<Object> find3MostFrequent();
}

