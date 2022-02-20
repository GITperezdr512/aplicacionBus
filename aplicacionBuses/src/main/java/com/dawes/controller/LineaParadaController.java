package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.LineaParadaVO;
import com.dawes.servicios.LineaParadaServicios;
import com.dawes.servicios.LineaServicios;
import com.dawes.servicios.ParadaServicios;

@Controller
@RequestMapping("/lineasParadas")
public class LineaParadaController {
	
	@Autowired
	LineaServicios ls;
	@Autowired
	ParadaServicios ps;
	@Autowired
	LineaParadaServicios lps;

	// Recogemos la linea por URL y la parada por parametro desde el select del formulario
	@GetMapping("/insertar/{idLinea}")
	public String unirLineaParada(@PathVariable int idLinea, @RequestParam(value = "parada") int idParada, Model model) {
		lps.save(new LineaParadaVO(ls.findById(idLinea).get(), ps.findById(idParada).get()));
		
		return "redirect:/lineas/paradas/{idLinea}";
	}
	
	@GetMapping("/eliminar/{idLinea}")
	public String borrarLineaParada(@PathVariable int idLinea, @RequestParam int idParada, Model model) {
		lps.delete(lps.findByLineaAndParada(ls.findById(idLinea).get(), ps.findById(idParada).get()).get());
		
		return "redirect:/lineas/paradas/{idLinea}";
	}
}
