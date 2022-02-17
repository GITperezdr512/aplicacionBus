package com.dawes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lineas")
@Data
@NoArgsConstructor
public class LineaVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idlinea;
	@Column(unique = true, nullable = false)
	private String denCorta;
	@Column(unique = true, nullable = false)
	private String denLarga;
	@OneToMany(mappedBy = "linea", cascade = CascadeType.REMOVE)
	private List<LineaParadaVO> paradas;
	
	public LineaVO(int idlinea, String denCorta, String denLarga) {
		this.idlinea = idlinea;
		this.denCorta = denCorta;
		this.denLarga = denLarga;
		this.paradas = new ArrayList<LineaParadaVO>();
	}
	
	
}
