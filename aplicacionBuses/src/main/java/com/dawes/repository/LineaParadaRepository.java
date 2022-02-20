package com.dawes.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.LineaParadaVO;
import com.dawes.modelo.LineaVO;
import com.dawes.modelo.ParadaVO;

@Repository
public interface LineaParadaRepository extends CrudRepository<LineaParadaVO, Integer> {
	Optional<LineaParadaVO> findByLineaAndParada(LineaVO linea, ParadaVO parada);
}
