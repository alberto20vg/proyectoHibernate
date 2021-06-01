package com.accesodatos.hibernate.ProyectoHibernateAnotaciones;

import java.io.Serializable;

public class AlumnoImparteId implements Serializable {

	private Integer alumno;
	private Integer profesor;

	public AlumnoImparteId() {
	}

	public int getId_alumno() {
		return alumno;
	}

	public void setId_alumno(Integer id_alumno) {
		this.alumno = id_alumno;
	}

	public int getId_profesor() {
		return profesor;
	}

	public void setId_profesor(Integer id_profesor) {
		this.profesor = id_profesor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alumno;
		result = prime * result + profesor;
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
		AlumnoImparteId other = (AlumnoImparteId) obj;
		if (alumno != other.alumno)
			return false;
		if (profesor != other.profesor)
			return false;
		return true;
	}

}
