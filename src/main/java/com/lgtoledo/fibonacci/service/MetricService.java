package com.lgtoledo.fibonacci.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgtoledo.fibonacci.data.model.Metric;
import com.lgtoledo.fibonacci.data.queryDto.MetricFrequencyDto;
import com.lgtoledo.fibonacci.data.repository.MetricRepository;

@Service
public class MetricService {

  @Autowired
  private MetricRepository repository;

  public Iterable<Metric> getMetrics(long nTerm, LocalDateTime start, LocalDateTime end) {
    return repository.findBynTermAndTimestampBetween(nTerm, start, end);
  }

  public Iterable<Metric> getMetrics(LocalDateTime start, LocalDateTime end) {
    return repository.findByTimestampBetween(start, end);
  }

  public Iterable<Metric> getMetrics(long nTerm) {
    return repository.findBynTerm(nTerm);
  }

  public Iterable<Metric> getMetrics() {
    return repository.findAll();
  }
  
  public Iterable<MetricFrequencyDto> get3MostFrequent(){
    return repository.find3MostFrequent();
  }


  public void reset() {
    repository.deleteAll();
  }

  public void save(Metric metric) {
    repository.save(metric);
  }



}
