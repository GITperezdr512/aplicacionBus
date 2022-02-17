package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.LineaParadaVO;

@Repository
public interface LineaParadaRepository extends CrudRepository<LineaParadaVO, Integer> {

}
