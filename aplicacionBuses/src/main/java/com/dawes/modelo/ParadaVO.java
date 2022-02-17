package com.dawes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paradas")
@Data
@NoArgsConstructor
public class ParadaVO {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idparada;
		@Column(unique = true, nullable = false)
		private String denominacion;
		@OneToMany(mappedBy = "parada", fetch = FetchType.LAZY)
		private List<LineaParadaVO> lineas;
		
		public ParadaVO(int idparada, String denominacion) {
			super();
			this.idparada = idparada;
			this.denominacion = denominacion;
			this.lineas = new ArrayList<LineaParadaVO>();
		}
		
		
}
