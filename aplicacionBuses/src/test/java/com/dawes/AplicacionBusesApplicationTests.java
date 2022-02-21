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
		ls.save(new LineaVO(0, "1", "Hospital de Cabueñes"));
		ls.save(new LineaVO(0, "10", "Calzada"));
		ls.save(new LineaVO(0, "12", "Cerillero"));
		ps.save(new ParadaVO(0, "Tanatorio"));
		ps.save(new ParadaVO(0, "Gota de Leche"));
		ps.save(new ParadaVO(0, "Ronda exterior"));
		lps.save(new LineaParadaVO(0, LocalDate.now(), ls.findById(1).get(), ps.findById(1).get()));
		lps.save(new LineaParadaVO(0, LocalDate.now(), ls.findById(1).get(), ps.findById(2).get()));
		lps.save(new LineaParadaVO(0, LocalDate.now(), ls.findById(1).get(), ps.findById(3).get()));
		lps.save(new LineaParadaVO(0, LocalDate.now(), ls.findById(2).get(), ps.findById(1).get()));
		lps.save(new LineaParadaVO(0, LocalDate.now(), ls.findById(2).get(), ps.findById(2).get()));
		lps.save(new LineaParadaVO(0, LocalDate.now(), ls.findById(3).get(), ps.findById(1).get()));
		ps.deleteById(2);
	}

}
