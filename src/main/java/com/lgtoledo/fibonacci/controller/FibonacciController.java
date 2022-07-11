package com.lgtoledo.fibonacci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgtoledo.fibonacci.data.model.Term;
import com.lgtoledo.fibonacci.service.TermService;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {
  
  @Autowired
  TermService termService;

  @RequestMapping("/")
  public String index() {
    return "Hola";
  }

  @GetMapping("/{n}")
  public Term fibonacci(@PathVariable int n) {
    //if (n < 0) return "Error 1: Ingrese un valor mayor o igual a cero";

    //if (n > 92) return "Error 2: Ingrese un valor menor o igual a 92 para evitar overflow del tipo -long-";
    
    return this.termService.getTerm(n);
  }
  
  @GetMapping("/reset")
  public String reset() {
    try {
      this.termService.reset();
      return "Contenido de la Base de datos borrado correctamente";
    } catch (Exception e) {
      return "Error al limpiar la base de datos:" + "\n" + e.getMessage();
    }
  }

}