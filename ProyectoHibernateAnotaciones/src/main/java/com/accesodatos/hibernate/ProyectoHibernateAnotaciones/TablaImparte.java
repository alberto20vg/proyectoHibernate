package com.accesodatos.hibernate.ProyectoHibernateAnotaciones;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class TablaImparte {
	/*
	 * este metodo muestra cada profesor con su alumno y la asignatura que imparte
	 */
	public static void selectProfesorAlumno(SessionFactory sf) {
		Session conn = sf.openSession();

		Query q = conn.createQuery("SELECT i.alumno FROM Imparte i");
		Query q1 = conn.createQuery("SELECT i.profesor FROM Imparte i");
		Query q2 = conn.createQuery("SELECT i.asignatura FROM Imparte i");

		List<Alumno> a = q.list();
		List<Profesor> p = q1.list();
		List<String> asg = q2.list();
		Iterator<Alumno> iterA = a.iterator();
		Iterator<Profesor> iterP = p.iterator();
		Iterator<String> iterASG = asg.iterator();

		while (iterA.hasNext()) {
			Alumno alum = iterA.next();
			Profesor prof = iterP.next();

			System.out.println(prof.getIdProfesor() + " " + prof.getNombreProfesor() + " - " + alum.getIdAlum() + " "
					+ alum.getNombreAlum() + " - " + iterASG.next());

		}

		conn.close();
	}

	/*
	 * este metodo crea la relacion entre un profesor y un alumno ya previamente
	 * creados y le asignas la asignatura
	 */
	public static void insertImparte(SessionFactory sf) {
		Session conn = sf.openSession();
		Scanner sc = new Scanner(System.in);
		try {
			Imparte i = new Imparte();

			System.out.println("Indique el id del profesor");
			Integer IdProfesor = sc.nextInt();
			Profesor p = conn.load(Profesor.class, IdProfesor);
			i.setIdProfesor(p);
			sc.nextLine();

			System.out.println("Indique el id del alumno");
			Integer idAlumno = sc.nextInt();
			Alumno a = conn.load(Alumno.class, idAlumno);
			i.setIdAlumno(a);
			sc.nextLine();

			System.out.println("Indique la asignatura");
			String asignatura = sc.nextLine();
			i.setAsignatura(asignatura);

			conn.getTransaction().begin();
			conn.save(i);
			conn.getTransaction().commit();

			System.out.println("Asignacion creada.");
		} catch (EntityNotFoundException e) {
			System.out.println("El profesor o el Alumno no existe.");
		}

		conn.close();
	}
//los borrados se hacen cuando eliminas el profesor o el alumno

}
