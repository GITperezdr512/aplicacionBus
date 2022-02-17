package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dawes.modelo.LineaParadaVO;
import com.dawes.servicios.LineaServicios;

@RequestMapping("/lineasParadas")
public class LineaParadaController {
	
	@Autowired
	LineaServicios ls;

	@GetMapping("/insertar/{id}")
	public String unirLineaParada(@PathVariable int idLinea, Model model) {
		model.addAttribute("lineaParadas", new LineaParadaVO(ls.findById(idLinea).get()));
		
		return "/lineas/paradas/{id}";
	}
	
	
}
