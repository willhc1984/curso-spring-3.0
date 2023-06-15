package com.cursospring.exception;

import java.time.OffsetDateTime;
import java.util.List;

public class ExceptionError {
	
	private Integer status;
	private OffsetDateTime dataHora;
	private String titulo;
	private List<Error> errors;
	
	public ExceptionError() {}

	public ExceptionError(Integer status, OffsetDateTime dataHora, String titulo, List<Error> errors) {
		super();
		this.status = status;
		this.dataHora = dataHora;
		this.titulo = titulo;
		this.errors = errors;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public OffsetDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}	

}
