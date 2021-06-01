package com.accesodatos.hibernate.ProyectoHibernateAnotaciones;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class TablaAlumnos {

	/*
	 * este metodo muestra a todos los alumnos y la lista de los profesores que le
	 * imparten
	 */
	public static void selectAlumno(SessionFactory sf) {
		Session conn = sf.openSession();

		Query q = conn.createQuery("From Alumno");

		List<Alumno> a = q.list();
		Iterator<Alumno> iter = a.iterator();

		while (iter.hasNext()) {
			Alumno alum = iter.next();
			System.out.println("\nId: " + alum.getIdAlum());
			System.out.println("Nombre: " + alum.getNombreAlum());
			System.out.println("Apellido: " + alum.getApellidoAlum());

			List<Imparte> ListaImparte = alum.getLeImparten();
			System.out.println("Profesores:");
			if (ListaImparte.isEmpty()) {
				System.out.println("Este Alumno no tiene profesores");
			}
			for (Imparte imparte : ListaImparte) {
				System.out.println("\tId: "+imparte.getIdProfesor().getIdProfesor()+", " + imparte.getIdProfesor().getNombreProfesor());
			}

		}

		conn.close();
	}

	/*
	 * este metodo inserta un alumno en la base de datos
	 */

	public static void insertAlumno(SessionFactory sf) {
		Session conn = sf.openSession();

		Scanner sc = new Scanner(System.in);
		Alumno a = new Alumno();


		System.out.println("Indique el nombre del alumno");
		String nombreAlumno = sc.nextLine();
		a.setNombreAlum(nombreAlumno);

		System.out.println("Indique el apellido del alumno");
		String apellidoAlumno = sc.nextLine();
		a.setApellidoAlum(apellidoAlumno);

		conn.getTransaction().begin();
		conn.save(a);
		conn.getTransaction().commit();

		System.out.println("Alumno creado.");

		conn.close();
	}

	/*
	 * este metodo borra el alumno por id
	 */

	public static void deleteAlumno(SessionFactory sf) {
		Session conn = sf.openSession();
		Scanner sc = new Scanner(System.in);

		try {
			conn.getTransaction().begin();

			System.out.println("Indique el id del alumno que quiere borrar:");
			Integer idAlumno = sc.nextInt();
			Alumno a = conn.load(Alumno.class, idAlumno);

			conn.delete(a);
			conn.getTransaction().commit();

			System.out.println("Alumno eliminado.");
		} catch (EntityNotFoundException e) {
			System.out.println("El Alumno no existe.");
		}

		conn.close();
	}
}
