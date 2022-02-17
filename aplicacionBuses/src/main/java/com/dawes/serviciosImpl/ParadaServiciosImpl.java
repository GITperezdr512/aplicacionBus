package com.dawes.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.ParadaVO;
import com.dawes.repository.ParadaRepository;
import com.dawes.servicios.ParadaServicios;

@Service
public class ParadaServiciosImpl implements ParadaServicios {
	@Autowired
	ParadaRepository pr;

	@Override
	public <S extends ParadaVO> S save(S entity) {
		return pr.save(entity);
	}

	@Override
	public <S extends ParadaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return pr.saveAll(entities);
	}

	@Override
	public Optional<ParadaVO> findById(Integer id) {
		return pr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return pr.existsById(id);
	}

	@Override
	public Iterable<ParadaVO> findAll() {
		return pr.findAll();
	}

	@Override
	public Iterable<ParadaVO> findAllById(Iterable<Integer> ids) {
		return pr.findAllById(ids);
	}

	@Override
	public long count() {
		return pr.count();
	}

	@Override
	public void deleteById(Integer id) {
		pr.deleteById(id);
	}

	@Override
	public void delete(ParadaVO entity) {
		pr.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		pr.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends ParadaVO> entities) {
		pr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		pr.deleteAll();
	}
}
