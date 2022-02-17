package com.dawes;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dawes.modelo.LineaParadaVO;
import com.dawes.modelo.LineaVO;
import com.dawes.modelo.ParadaVO;
import com.dawes.servicios.LineaParadaServicios;
import com.dawes.servicios.LineaServicios;
import com.dawes.servicios.ParadaServicios;

@SpringBootTest
public class AplicacionBusesApplicationTests {
	
	@Autowired
	LineaServicios ls;
	@Autowired
	ParadaServicios ps;
	@Autowired
	LineaParadaServicios lps;
	

	@Test
	public void test01() {
		ls.save(new LineaVO(0, "1", "Hospital de Cabueñes / Cerillero"));
	}
	
	@Test
	public void test02() {
		ps.save(new ParadaVO(0, "Tanatorio"));
	}
	
	@Test
	public void test03() {
		lps.save(new LineaParadaVO(0, LocalDate.now(), ls.findById(1).get(), ps.findById(1).get()));
	}

}
