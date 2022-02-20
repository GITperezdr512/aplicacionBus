package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.LineaParadaVO;
import com.dawes.modelo.LineaVO;
import com.dawes.modelo.ParadaVO;

public interface LineaParadaServicios {

	<S extends LineaParadaVO> S save(S entity);

	<S extends LineaParadaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<LineaParadaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<LineaParadaVO> findAll();

	Iterable<LineaParadaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(LineaParadaVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends LineaParadaVO> entities);

	void deleteAll();

	Optional<LineaParadaVO> findByLineaAndParada(LineaVO linea, ParadaVO parada);
}