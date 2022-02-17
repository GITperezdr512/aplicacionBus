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

	@RequestMapping("")
	public String irMenu() {
		init();
		return "mantenimientos/mantenimiento";
	}
	
	public void init(){
		ls.save(new LineaVO(0, "1", "Hospital de Cabueñes"));
		ls.save(new LineaVO(0, "10", "Calzada"));
		ps.save(new ParadaVO(0, "Tanatorio"));
		ps.save(new ParadaVO(0, "Gota de Leche"));
		lps.save(new LineaParadaVO(0, LocalDate.now(), ls.findById(1).get(), ps.findById(1).get()));
		lps.save(new LineaParadaVO(0, LocalDate.now(), ls.findById(2).get(), ps.findById(1).get()));
		lps.save(new LineaParadaVO(0, LocalDate.now(), ls.findById(2).get(), ps.findById(2).get()));
	}
}
