package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.ParadaVO;

public interface ParadaServicios {

	<S extends ParadaVO> S save(S entity);

	<S extends ParadaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ParadaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ParadaVO> findAll();

	Iterable<ParadaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ParadaVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends ParadaVO> entities);

	void deleteAll();

}