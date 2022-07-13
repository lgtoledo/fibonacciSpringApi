package com.lgtoledo.fibonacci.data.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Metric {

  @Id
  @GeneratedValue
  private Long id;

  private long nTerm;

  //@Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime timestamp;

  public Metric() {
  }

  public Metric(long nTerm, LocalDateTime timestamp) {
    this.nTerm = nTerm;
    this.timestamp = timestamp;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public long getnTerm() {
    return nTerm;
  }

  public void setnTerm(int nTerm) {
    this.nTerm = nTerm;
  }

  public java.time.LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(java.time.LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
  

}
