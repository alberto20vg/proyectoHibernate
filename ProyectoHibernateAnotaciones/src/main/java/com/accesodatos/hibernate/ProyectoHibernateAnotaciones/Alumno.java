package com.accesodatos.hibernate.ProyectoHibernateAnotaciones;

import java.io.Serializable;
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

@Entity
@Table(name = "alumno")

public class Alumno implements Serializable {



	@Id
	@Column(name = "idAlumno", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlum;

	@Column(name = "nombreAlumno")
	private String nombreAlum;

	@Column(name = "apellidoAlumno ")
	private String apellidoAlum;


	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Imparte> leImparten = new ArrayList<Imparte>();

	public List<Imparte> getLeImparten() {
		return leImparten;
	}


	public void setLeImparten(List<Imparte> leImparten) {
		this.leImparten = leImparten;
	}
	
	public Integer getIdAlum() {
		return idAlum;
	}


	public void setIdAlum(Integer idAlum) {
		this.idAlum = idAlum;
	}


	public String getNombreAlum() {
		return nombreAlum;
	}


	public void setNombreAlum(String nombre) {
		this.nombreAlum = nombre;
	}


	public String getApellidoAlum() {
		return apellidoAlum;
	}


	public void setApellidoAlum(String apellido) {
		this.apellidoAlum = apellido;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidoAlum == null) ? 0 : apellidoAlum.hashCode());
		result = prime * result + ((idAlum == null) ? 0 : idAlum.hashCode());
		result = prime * result + ((nombreAlum == null) ? 0 : nombreAlum.hashCode());
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
		Alumno other = (Alumno) obj;
		if (apellidoAlum == null) {
			if (other.apellidoAlum != null)
				return false;
		} else if (!apellidoAlum.equals(other.apellidoAlum))
			return false;
		if (idAlum == null) {
			if (other.idAlum != null)
				return false;
		} else if (!idAlum.equals(other.idAlum))
			return false;
		if (nombreAlum == null) {
			if (other.nombreAlum != null)
				return false;
		} else if (!nombreAlum.equals(other.nombreAlum))
			return false;
		return true;
	}






	
	
}
