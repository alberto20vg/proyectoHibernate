package com.accesodatos.hibernate.ProyectoHibernateAnotaciones;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.sun.tools.sjavac.client.PortFileInaccessibleException;

public class TablaProfesores {

	public static void selectProfesor(SessionFactory sf) {
		Session conn = sf.openSession();

		Query q = conn.createQuery("From Profesor");

		List<Profesor> p = q.list();
		Iterator<Profesor> iter = p.iterator();

		while (iter.hasNext()) {
			Profesor prof = iter.next();
			System.out.println("\nId: " + prof.getIdProfesor());
			System.out.println("Nombre: " + prof.getNombreProfesor());
			if (prof.getIdCentro()!= null)
				System.out.println("Id centro: " + prof.getIdCentro().getIdCentro());

			List<Imparte> ListaImparte = prof.getImparte();
			System.out.println("Alumnos:");
			if (ListaImparte.isEmpty()) {
				System.out.println("Este Profesor no tiene alumnos");
			}
			for (Imparte imparte : ListaImparte) {
				System.out.println("\tId: " + imparte.getIdAlumno().getIdAlum() + ", "
						+ imparte.getIdAlumno().getNombreAlum() + " " + imparte.getIdAlumno().getApellidoAlum());
			}
		}
		conn.close();
	}

	public static void insertProfesor(SessionFactory sf) {
		Session conn = sf.openSession();

		Scanner sc = new Scanner(System.in);
		try {
			Profesor p = new Profesor();
			System.out.println("Indique el nombre del profesor");
			String nombreProfesor = sc.nextLine();
			p.setNombreProfesor(nombreProfesor);

			System.out.println("Indique el telefono del profesor");
			Integer tlfProfesor = sc.nextInt();
			p.setTelefono(tlfProfesor);
			sc.nextLine();

			System.out.println("¿Quiere asignarle un centro? Y/N");
			String decision = sc.nextLine();
			if (decision.equals("Y") || decision.equals("y")) {
				System.out.println("Indique el centro del profesor");
				Integer centroProfesor = sc.nextInt();
				Centro c = conn.load(Centro.class, centroProfesor);
				p.setIdCentro(c);
				sc.nextLine();
			}

			conn.getTransaction().begin();
			conn.save(p);
			conn.getTransaction().commit();

			System.out.println("Profesor creado.");
		} catch (EntityNotFoundException e) {
			System.out.println("El Centro no existe.");
		}

		conn.close();
	}

	public static void updateProfesores(SessionFactory sf) {
		Session conn = sf.openSession();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Modificar el centro del profesor");
			System.out.println("Indique el id del profesor:");
			Integer idProfesor = sc.nextInt();

			Profesor p = conn.load(Profesor.class, idProfesor);

			System.out.println("Indique el id del centro nuevo:");
			Integer idCentro = sc.nextInt();

			Centro c = conn.load(Centro.class, idCentro);
			p.setIdCentro(c);

			conn.getTransaction().begin();
			conn.saveOrUpdate(p);
			conn.getTransaction().commit();

			System.out.println("Profesor modificado");
		} catch (EntityNotFoundException e) {
			System.out.println("El Profesor o el Centro no existe.");
		}
		conn.close();
	}

	public static void deleteProfesor(SessionFactory sf) {
		Session conn = sf.openSession();
		Scanner sc = new Scanner(System.in);

		try {
			conn.getTransaction().begin();

			System.out.println("Indique el id del profesor que quiere borrar:");
			Integer idProfesor = sc.nextInt();
			Profesor p = conn.load(Profesor.class, idProfesor);

			conn.delete(p);
			conn.getTransaction().commit();

			System.out.println("Profesor eliminado.");
		} catch (EntityNotFoundException e) {
			System.out.println("El profesor no existe.");
		}

		conn.close();
	}

}
