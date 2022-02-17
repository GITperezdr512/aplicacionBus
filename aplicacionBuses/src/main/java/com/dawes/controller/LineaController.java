package com.dawes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dawes.modelo.LineaParadaVO;
import com.dawes.modelo.LineaVO;
import com.dawes.servicios.LineaServicios;

@Controller
@RequestMapping("/lineas")
public class LineaController {
	@Autowired
	LineaServicios ls;

	// Se ven todas las líneas
	@RequestMapping("")
	public String verLineas(Model model) {
		model.addAttribute("listaLineas", ls.findAll());
		return "lineas/lineas";
	}
	
	// Vienes de todas las líneas y va a formulario de inserción
	@RequestMapping("/insertar")
	public String insertar(Model model) {
		model.addAttribute("lineaForm", new LineaVO());
		return "lineas/opciones/formInserta";
	}
	
	// Viene de formulario de inserción, guarda línea y vuelve a todas las líneas
	@PostMapping("/insertar/submit")
	public String nuevaLineaSubmit(@ModelAttribute("lineaForm") LineaVO linea) {
		ls.save(linea);
		return "redirect:/lineas";
	}
	
	// Viene de todas las líneas y va a formulario de edición
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {

		LineaVO linea = ls.findById(id).get();
		
		model.addAttribute("lineaForm", linea);
		
		return "lineas/opciones/formEdita";
	}
	
	// Viene de formulario de edición, actualiza línea y va a todas las líneas
	@RequestMapping("/editar/submit")
	public String editarLineaSubmit(@ModelAttribute("lineaForm") LineaVO linea) {
		ls.save(linea);
		return "redirect:/lineas";
	}
	
	// Viene de todas las líneas, elimina y vuelve a todas las líneas
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		ls.deleteById(id);
		return "redirect:/lineas";
	}
	
	// Viene de todas las líneas y enseña la lista de paradas
	@GetMapping("/paradas/{id}")
	public String verParadas(@PathVariable int id, Model model) {
		
		model.addAttribute("listaParadas", ls.paradasDeLinea(ls.findById(id).get()));
//		model.addAttribute("paradasFaltan", ls.paradasDeLinea(ls.findById(id).get()));

		model.addAttribute("paradasFaltan", ls.paradasNoDeLinea(ls.findById(id).get()));
		
		return "lineas/opciones/lista";
	}
}
