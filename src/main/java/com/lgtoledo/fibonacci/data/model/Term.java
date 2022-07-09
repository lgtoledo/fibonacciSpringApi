package com.lgtoledo.fibonacci.data.model;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Term {

  @Id
  private Long id;
  private Long value;

  public Term() {
  }

  public Term(long id, long value) {
    this.id = id;
    this.value = value;
  }
  

  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }

  public Long getValue() {
    return value;
  }

  public void setValue(Long value) {
    this.value = value;
  }
  
  @Override
  public String toString() {
    return "Term [id=" + id + ", value=" + value + "]";
  }
}
