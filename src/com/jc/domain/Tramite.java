package com.jc.domain;

import java.sql.Timestamp;


public class Tramite {

	private int idTramite;
	private String tipoTramite;
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

}
