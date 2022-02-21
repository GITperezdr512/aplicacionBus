package com.dawes.serviciosImpl;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dawes.modelo.LineaVO;
import com.dawes.modelo.ParadaVO;
import com.dawes.repository.LineaRepository;
import com.dawes.servicios.LineaServicios;

@Service
public class LineaServiciosImpl implements LineaServicios {
	@Autowired
	LineaRepository lr;

	@Override
	public <S extends LineaVO> S save(S entity) {
		try {
			return lr.save(entity);
		} catch (DataIntegrityViolationException e) {
			return entity;
		}


	}

	@Override
	public <S extends LineaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return lr.saveAll(entities);
	}

	@Override
	public Optional<LineaVO> findById(Integer id) {
		return lr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return lr.existsById(id);
	}

	@Override
	public Iterable<LineaVO> findAll() {
		return lr.findAll();
	}

	@Override
	public Iterable<LineaVO> findAllById(Iterable<Integer> ids) {
		return lr.findAllById(ids);
	}

	@Override
	public long count() {
		return lr.count();
	}

	@Override
	public void deleteById(Integer id) {
		lr.deleteById(id);
	}

	@Override
	public void delete(LineaVO entity) {
		lr.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		lr.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends LineaVO> entities) {
		lr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		lr.deleteAll();
	}

	@Override
	public List<ParadaVO> paradasDeLinea(LineaVO linea) {
		return lr.paradasDeLinea(linea);
	}

	@Override
	public List<ParadaVO> paradasNoDeLinea(LineaVO linea) {
		return lr.paradasNoDeLinea(linea);
	}
	
	
}
