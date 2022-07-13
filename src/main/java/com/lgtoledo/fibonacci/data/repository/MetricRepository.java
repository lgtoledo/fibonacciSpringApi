package com.lgtoledo.fibonacci.data.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lgtoledo.fibonacci.data.model.Metric;
import com.lgtoledo.fibonacci.data.queryDto.MetricFrequencyDto;

public interface MetricRepository extends CrudRepository<Metric, Long> {

  public Iterable<Metric> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

  public Iterable<Metric> findBynTerm(long nTerm);

  public Iterable<Metric> findBynTermAndTimestampBetween(long nTerm, LocalDateTime start, LocalDateTime end);

  @Query(value = "SELECT n_term as nTerm, COUNT(n_term) AS frequency FROM Metric GROUP BY n_term ORDER BY frequency DESC LIMIT 3", nativeQuery = true)
  public Iterable<MetricFrequencyDto> find3MostFrequent();
}

