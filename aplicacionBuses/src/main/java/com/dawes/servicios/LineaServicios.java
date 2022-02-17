package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.LineaVO;

public interface LineaServicios {

	<S extends LineaVO> S save(S entity);

	<S extends LineaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<LineaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<LineaVO> findAll();

	Iterable<LineaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(LineaVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends LineaVO> entities);

	void deleteAll();

}