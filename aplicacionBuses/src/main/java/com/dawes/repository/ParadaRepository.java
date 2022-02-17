package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ParadaVO;

@Repository
public interface ParadaRepository extends CrudRepository<ParadaVO, Integer> {

}
