package com.lgtoledo.fibonacci.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgtoledo.fibonacci.data.model.Metric;
import com.lgtoledo.fibonacci.data.repository.MetricRepository;

@Service
public class MetricService {

  @Autowired
  private MetricRepository repository;

  public Iterable<Metric> getMetrics(int nTerm, LocalDateTime start, LocalDateTime end) {
    return repository.findBynTermAndTimestampBetween(nTerm, start, end);
  }

  public Iterable<Metric> getMetrics(LocalDateTime start, LocalDateTime end) {
    return repository.findByTimestampBetween(start, end);
  }

  public Iterable<Metric> getMetrics(int nTerm) {
    return repository.findBynTerm(nTerm);
  }

  public Iterable<Metric> getMetrics() {
    return repository.findAll();
  }

  public void reset() {
    repository.deleteAll();
  }

  public void save(Metric metric) {
    repository.save(metric);
  }



}
