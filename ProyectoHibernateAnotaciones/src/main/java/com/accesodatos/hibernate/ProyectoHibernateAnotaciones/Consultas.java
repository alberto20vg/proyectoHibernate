package com.accesodatos.hibernate.ProyectoHibernateAnotaciones;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Consultas {

	public static void select1(SessionFactory sf) {
		Session conn = sf.openSession();
//SELECT alumno.nombreAlumno FROM alumno WHERE alumno.idAlumno = (SELECT idAlumno FROM imparte WHERE asignatura LIKE 'android')
		Query q = conn.createQuery(
				"FROM Alumno as a WHERE a.idAlum IN (SELECT i.alumno FROM Imparte as i WHERE i.asignatura LIKE 'android')");
		List<Alumno> p = q.list();
		Iterator<Alumno> iter = p.iterator();

		while (iter.hasNext()) {
			Alumno alum = iter.next();
			System.out.println(alum.getNombreAlum());

		}
		conn.close();
	}

	public static void select2(SessionFactory sf) {
		Session conn = sf.openSession();
//		SELECT COUNT(*) FROM profesor WHERE profesor.idCentro is null
		Query q = conn.createQuery("SELECT COUNT(*) FROM Profesor as p WHERE p.centro IS NULL");
		List<Integer> p = q.list();
		Iterator<Integer> iter = p.iterator();

		int aux = 0;
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		conn.close();
	}

	public static void select3(SessionFactory sf) {
		Session conn = sf.openSession();
//		SELECT c.nombreCentro, 
//		a.nombreAlumno
//		FROM centro AS c
//		INNER JOIN profesor AS p ON p.idCentro = c.idCentro
//		INNER JOIN imparte AS i ON i.idProfesor = p.idProfesor
//		INNER JOIN alumno AS a ON i.idAlumno = a.idAlumno
//		GROUP BY c.idCentro

//		SELECT c.nombreCentro

		Query q = conn.createQuery("FROM Centro c INNER JOIN Profesor p ON p.centro = c.idCentro"
				+ " INNER JOIN Imparte i ON i.profesor = p.idProfesor" + " INNER JOIN Alumno a ON i.alumno = a.idAlum");
		List lista = q.list();
		Iterator iter = lista.iterator();

		while (iter.hasNext()) {
			Object[] par = (Object[]) iter.next();
			Centro c = (Centro) par[0];
			Profesor p = (Profesor) par[1];
			Imparte i = (Imparte) par[2];
			Alumno a = (Alumno) par[3];
			
			System.out.println(c.getNombreCentro()+" "+p.getNombreProfesor()+" "+ a.getNombreAlum());

		}
		conn.close();
	}

}
