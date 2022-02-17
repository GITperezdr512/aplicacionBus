package com.dawes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.LineaVO;
import com.dawes.modelo.ParadaVO;

@Repository
public interface LineaRepository extends CrudRepository<LineaVO, Integer> {
	
	@Query("SELECT lp.parada FROM LineaParadaVO lp WHERE lp.linea = ?1")
	List<ParadaVO> paradasDeLinea(LineaVO linea);
	
	@Query("SELECT p FROM ParadaVO p WHERE p NOT IN (SELECT lp.parada FROM LineaParadaVO lp WHERE lp.linea = ?1)")
	List<ParadaVO> paradasNoDeLinea(LineaVO linea);
}
