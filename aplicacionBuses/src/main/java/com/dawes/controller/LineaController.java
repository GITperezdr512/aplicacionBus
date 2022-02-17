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

	@RequestMapping("")
	public String verLineas(Model model) {
		model.addAttribute("listaLineas", ls.findAll());
		return "lineas/lineas";
	}
	
	@RequestMapping("/insertar")
	public String insertar(Model model) {
		model.addAttribute("lineaForm", new LineaVO());
		return "lineas/opciones/formInserta";
	}
	
	@PostMapping("/insertar/submit")
	public String nuevaLineaSubmit(@ModelAttribute("lineaForm") LineaVO linea) {
		ls.save(linea);
		return "redirect:/lineas";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {

		LineaVO linea = ls.findById(id).get();
		
		model.addAttribute("lineaForm", linea);
		
		return "lineas/opciones/formEdita";
	}
	
	@RequestMapping("/editar/submit")
	public String editarLineaSubmit(@ModelAttribute("lineaForm") LineaVO linea) {
		ls.save(linea);
		return "redirect:/lineas";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		ls.deleteById(id);
		return "redirect:/lineas";
	}
	
	@GetMapping("/paradas/{id}")
	public String verParadas(@PathVariable int id, Model model) {
		List<LineaParadaVO> lineas = ls.findById(id).get().getParadas();
		model.addAttribute("listaParadas", lineas);
		
		List<LineaParadaVO> lineasFaltan;
		
		List<>
		
		model.addAttribute("paradasFaltan", model);
		
		return "lineasParadas/lista";
	}
}
