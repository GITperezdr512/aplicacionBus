package com.dawes.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lineasParadas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaParadaVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idlineaparada;
	@Column(nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	@ManyToOne
	private LineaVO linea;
	@ManyToOne
	private ParadaVO parada;
	
	public LineaParadaVO(LineaVO linea, ParadaVO parada) {
		this.idlineaparada = 0;
		this.fecha = LocalDate.now();
		this.linea = linea;
		this.parada = parada;
	}
	
	
	
	
}
