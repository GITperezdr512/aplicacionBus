package com.dawes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mantenimiento")
public class MantenimientoController {

	@RequestMapping("")
	public String irMenu() {
		return "mantenimientos/mantenimiento";
	}
}
