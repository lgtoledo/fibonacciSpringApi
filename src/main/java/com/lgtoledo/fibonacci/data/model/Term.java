package com.lgtoledo.fibonacci.data.model;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Term {

  @Id
  private Long n;
  private Long value;

  public Term() {
  }

  public Term(long n, long value) {
    this.n = n;
    this.value = value;
  }
  

  public Long getN() {
    return n;
  }
  
  public void setN(Long n) {
    this.n = n;
  }

  public Long getValue() {
    return value;
  }

  public void setValue(Long value) {
    this.value = value;
  }
  
}
