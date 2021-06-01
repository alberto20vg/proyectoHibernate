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
@Table(name="centro")
public class Centro implements Serializable{


	@Id
	@Column(name="idCentro", unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCentro;
	
	@Column(name="nombreCentro")
	private String nombreCentro;

	@Column(name="direccionCentro")
	private String direccion;
	
	
	@OneToMany(mappedBy="centro", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Profesor> profesores =new ArrayList<>();


	public Integer getIdCentro() {
		return idCentro;
	}


	public void setIdCentro(Integer id_centro) {
		this.idCentro = id_centro;
	}


	public String getNombreCentro() {
		return nombreCentro;
	}


	public void setNombreCentro(String nombre) {
		this.nombreCentro = nombre;
	}


	public String getDireccionCentro() {
		return direccion;
	}


	public void setDireccionCentro(String direccion) {
		this.direccion = direccion;
	}


	public List<Profesor> getProfesores() {
		return profesores;
	}


	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((idCentro == null) ? 0 : idCentro.hashCode());
		result = prime * result + ((nombreCentro == null) ? 0 : nombreCentro.hashCode());
		result = prime * result + ((profesores == null) ? 0 : profesores.hashCode());
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
		Centro other = (Centro) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (idCentro == null) {
			if (other.idCentro != null)
				return false;
		} else if (!idCentro.equals(other.idCentro))
			return false;
		if (nombreCentro == null) {
			if (other.nombreCentro != null)
				return false;
		} else if (!nombreCentro.equals(other.nombreCentro))
			return false;
		if (profesores == null) {
			if (other.profesores != null)
				return false;
		} else if (!profesores.equals(other.profesores))
			return false;
		return true;
	}


	
}
