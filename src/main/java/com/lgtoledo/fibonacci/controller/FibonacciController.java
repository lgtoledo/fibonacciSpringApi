package com.lgtoledo.fibonacci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgtoledo.fibonacci.service.TermService;

@RestController
public class FibonacciController {
  
  @Autowired
  TermService termService;

  @RequestMapping("/")
  public String Index() {
    return "Hola";
  }

  @RequestMapping("/fibonacci/{n}")
  public String fibonacci(@PathVariable int n) {
    if (n < 0) return "Error 1: Ingrese un valor mayor o igual a cero";

    if (n > 92) return "Error 2: Ingrese un valor menor o igual a 92 para evitar overflow del tipo -long-";
    
    return String.valueOf(termService.getTerm(n).getValue());
  }
  
  @RequestMapping("/fibonacci/reset")
  public String reset() {
    try {
      termService.reset();
      return "Contenido de la Base de datos borrado correctamente";
    } catch (Exception e) {
      return "Error al limpiar la base de datos:" + "\n" + e.getMessage();
    }
  }

}