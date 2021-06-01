package com.accesodatos.hibernate.ProyectoHibernateAnotaciones;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@IdClass(AlumnoImparteId.class)
public class Imparte implements Serializable{
	
	@Id
	@ManyToOne()
	@JoinColumn(name="idAlumno",foreignKey = @ForeignKey(name = "fk1_imparte"), insertable = false, updatable = false)
	private Alumno alumno;

	@Id

	@ManyToOne()
	@JoinColumn(name="idProfesor",foreignKey = @ForeignKey(name = "fk2_imparte"), insertable = false, updatable = false)
	private Profesor profesor;

	@Column(name="asignatura")
	private String asignatura;

	public Alumno getIdAlumno() {
		return alumno;
	}


	public String getAsignatura() {
		return asignatura;
	}


	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}


	public void setIdAlumno(Alumno id_alumno) {
		this.alumno = id_alumno;
	}

	public Profesor getIdProfesor() {
		return profesor;
	}

	public void setIdProfesor(Profesor id_profesor) {
		this.profesor = id_profesor;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
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
		Imparte other = (Imparte) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		return true;
	}
}

