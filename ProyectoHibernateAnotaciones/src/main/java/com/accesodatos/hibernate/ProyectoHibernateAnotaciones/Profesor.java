package com.accesodatos.hibernate.ProyectoHibernateAnotaciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor implements Serializable {

	@Id
	@Column(name = "idProfesor ", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;

	@Column(name = "nombreProfesor ")
	private String nombreProfesor;

	@Column(name = "telefono")
	private Integer telefono;

	@ManyToOne
	@JoinColumn(name = "idCentro", foreignKey = @ForeignKey(name = "fk_centro"))
	private Centro centro;


	@OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Imparte> imparteA = new ArrayList<Imparte>();

	
	public List<Imparte> getImparte() {
		return imparteA;
	}

	public void setImparte(List<Imparte> imparte) {
		this.imparteA = imparte;
	}

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombre) {
		this.nombreProfesor = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Centro getIdCentro() {
		return centro;
	}

	public void setIdCentro(Centro idCentro) {
		this.centro = idCentro;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centro == null) ? 0 : centro.hashCode());
		result = prime * result + ((idProfesor == null) ? 0 : idProfesor.hashCode());
		result = prime * result + ((nombreProfesor == null) ? 0 : nombreProfesor.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (centro == null) {
			if (other.centro != null)
				return false;
		} else if (!centro.equals(other.centro))
			return false;
		if (idProfesor == null) {
			if (other.idProfesor != null)
				return false;
		} else if (!idProfesor.equals(other.idProfesor))
			return false;
		if (nombreProfesor == null) {
			if (other.nombreProfesor != null)
				return false;
		} else if (!nombreProfesor.equals(other.nombreProfesor))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

}