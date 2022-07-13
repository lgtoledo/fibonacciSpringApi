package com.lgtoledo.fibonacci.data.queryModels;

public class MetricFrequency {

  private long nTerm;
  private long frequency;

  public MetricFrequency() {
  }

  public MetricFrequency(long nTerm, long frequency) {
    this.nTerm = nTerm;
    this.frequency = frequency;
  }

  public long getnTerm() {
    return nTerm;
  }

  public void setnTerm(long nTerm) {
    this.nTerm = nTerm;
  }

  public long getFrequency() {
    return frequency;
  }

  public void setFrequency(long frequency) {
    this.frequency = frequency;
  }
}
