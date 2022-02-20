package com.dawes.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.LineaParadaVO;
import com.dawes.modelo.LineaVO;
import com.dawes.modelo.ParadaVO;
import com.dawes.repository.LineaParadaRepository;
import com.dawes.servicios.LineaParadaServicios;

@Service
public class LineaParadaServiciosImpl implements LineaParadaServicios {
	@Autowired
	LineaParadaRepository lrr;

	@Override
	public <S extends LineaParadaVO> S save(S entity) {
		return lrr.save(entity);
	}

	@Override
	public <S extends LineaParadaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return lrr.saveAll(entities);
	}

	@Override
	public Optional<LineaParadaVO> findById(Integer id) {
		return lrr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return lrr.existsById(id);
	}

	@Override
	public Iterable<LineaParadaVO> findAll() {
		return lrr.findAll();
	}

	@Override
	public Iterable<LineaParadaVO> findAllById(Iterable<Integer> ids) {
		return lrr.findAllById(ids);
	}

	@Override
	public long count() {
		return lrr.count();
	}

	@Override
	public void deleteById(Integer id) {
		lrr.deleteById(id);
	}

	@Override
	public void delete(LineaParadaVO entity) {
		lrr.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		lrr.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends LineaParadaVO> entities) {
		lrr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		lrr.deleteAll();
	}

	@Override
	public Optional<LineaParadaVO> findByLineaAndParada(LineaVO linea, ParadaVO parada) {
		return lrr.findByLineaAndParada(linea, parada);
	}

}
