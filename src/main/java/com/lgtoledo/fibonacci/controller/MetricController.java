package com.lgtoledo.fibonacci.controller;

import java.time.LocalDateTime;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgtoledo.fibonacci.data.model.Metric;
import com.lgtoledo.fibonacci.data.queryDto.MetricFrequencyDto;
import com.lgtoledo.fibonacci.service.MetricService;
import com.nimbusds.jose.shaded.json.JSONObject;

@RestController
@RequestMapping("/metrics")
public class MetricController {
  
  @Autowired
  private MetricService metricService;

  // Retorna el ranking de los tres términos mas frecuentes
  @GetMapping(value="/", produces="application/json")
  public Iterable<MetricFrequencyDto> getMetrics() {
    Iterable<MetricFrequencyDto> metrics = metricService.get3MostFrequent();
    return metrics;
  }

  // Retorna las métricas para el n-term especificado
  @GetMapping(value="/term/{n}", produces="application/json")
  public String getMetrics(@PathVariable long n) {

    Iterable<Metric> metrics = metricService.getMetrics(n);
    int count = IterableUtils.size(metrics);
    
    JSONObject jsonResult = new JSONObject();
    jsonResult.put("Consultas al término n="+ n, count);
    jsonResult.put("metrics", metrics);
    return jsonResult.toJSONString();
  }

  // Retorna las métricas de la última hora para el n-term especificado
  @GetMapping(value="/term/{n}/lasthour", produces="application/json")
  public String getMetricsLastHour(@PathVariable long n) {
    
    LocalDateTime start = LocalDateTime.now().minusHours(1);
    LocalDateTime end = LocalDateTime.now();

    Iterable<Metric> metrics = metricService.getMetrics(n, start, end);
    int count = IterableUtils.size(metrics);

    JSONObject jsonResult = new JSONObject();
    jsonResult.put("Consultas al término n="+n, count);
    jsonResult.put("metrics", metrics);
    return jsonResult.toJSONString();
  }

}
