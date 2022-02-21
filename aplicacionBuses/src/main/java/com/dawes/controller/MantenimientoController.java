package com.dawes.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dawes.modelo.LineaParadaVO;
import com.dawes.modelo.LineaVO;
import com.dawes.modelo.ParadaVO;
import com.dawes.servicios.LineaParadaServicios;
import com.dawes.servicios.LineaServicios;
import com.dawes.servicios.ParadaServicios;

@Controller
@RequestMapping("/mantenimiento")
public class MantenimientoController {
	@Autowired
	LineaServicios ls;
	@Autowired
	LineaParadaServicios lps;
	@Autowired
	ParadaServicios ps;
	static boolean vez = true;

	@RequestMapping("")
	public String irMenu() {

		return "mantenimientos/mantenimiento";
	}
}
