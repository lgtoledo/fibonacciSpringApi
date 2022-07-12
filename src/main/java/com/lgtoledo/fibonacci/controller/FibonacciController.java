package com.lgtoledo.fibonacci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lgtoledo.fibonacci.data.model.Term;
import com.lgtoledo.fibonacci.service.TermService;
import com.nimbusds.jose.shaded.json.JSONObject;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {
  
  @Autowired
  private TermService termService;

  @GetMapping(value="/{n}", produces="application/json")
  public Term fibonacci(@PathVariable int n) throws Exception {
   
    if (n < 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ingrese un valor mayor o igual a cero");
    if (n > 92) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ingrese un valor menor o igual a 92 para evitar overflow del tipo -long-");
    
    try {
      Term t = this.termService.getTerm(n);
      return t;
    }catch (Exception e) {
      throw new ResponseStatusException(
           HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener n-term de fibonacci.", e);
    }
  }
  
  @GetMapping(value="/reset", produces="application/json")
  public String reset() {
    try {
      this.termService.reset();
      JSONObject entity = new JSONObject();
      entity.put("message", "Contenido de la Base de datos borrado correctamente");
      return entity.toJSONString();
      
    }catch (Exception e) {
      throw new ResponseStatusException(
           HttpStatus.INTERNAL_SERVER_ERROR, "Error al limpiar la base de datos.", e);
    }
  }

}