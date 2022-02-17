package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dawes.modelo.ParadaVO;
import com.dawes.servicios.ParadaServicios;

@Controller
@RequestMapping("/paradas")
public class ParadaController {
	
	@Autowired
	ParadaServicios ps;

	@RequestMapping("")
	public String verLineas(Model model) {
		model.addAttribute("listaParadas", ps.findAll());
		return "paradas/paradas";
	}

	@RequestMapping("/insertar")
	public String insertar(Model model) {
		model.addAttribute("paradaForm", new ParadaVO());
		return "paradas/opciones/formInserta";
	}

	@PostMapping("/insertar/submit")
	public String nuevaParadaSubmit(@ModelAttribute("paradaForm") ParadaVO parada) {
		ps.save(parada);
		return "redirect:/paradas";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {

		ParadaVO parada = ps.findById(id).get();

		model.addAttribute("paradaForm", parada);

		return "paradas/opciones/formEdita";
	}

	@RequestMapping("/editar/submit")
	public String editarLineaSubmit(@ModelAttribute("paradaForm") ParadaVO parada) {
		ps.save(parada);
		return "redirect:/paradas";
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		ps.deleteById(id);
		return "redirect:/lineas";
	}
}
