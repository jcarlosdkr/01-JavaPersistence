package com.jc.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tramite")
public class Tramite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTramite")
	private int idTramite;
	@Column(name = "tipoTramite")
	private String tipoTramite;
	@Column(name = "fechaTramite")
	private Timestamp fechaCreacion;

	public Tramite() {

	}

	public Tramite(String tipoTramite, Timestamp fechaCreacion) {
		this.tipoTramite = tipoTramite;
		this.fechaCreacion = fechaCreacion;
	}
	
	public int getIdTramite() {
		return idTramite;
	}

	public void setIdTramite(int idTramite) {
		this.idTramite = idTramite;
	}

	public String getTipoTramite() {
		return tipoTramite;
	}

	public void setTipoTramite(String tipoTramite) {
		this.tipoTramite = tipoTramite;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tramite [idTramite=");
		builder.append(idTramite);
		builder.append(", tipoTramite=");
		builder.append(tipoTramite);
		builder.append(", fechaCreacion=");
		builder.append(fechaCreacion);
		builder.append("]");
		return builder.toString();
	}

	
	
}
