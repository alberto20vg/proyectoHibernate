package com.accesodatos.hibernate.ProyectoHibernateAnotaciones;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TablaCentros {

	/*
	 * este metodo te saca el centro que le indiques por id y los profesores que
	 * este asociados a el
	 */
	public static void selectCentro(SessionFactory sf) {
		Session conn = sf.openSession();

		Scanner sc = new Scanner(System.in);
		System.out.println("Indique el id del centro");
		Integer IdCentro = sc.nextInt();

		Centro c = conn.load(Centro.class, IdCentro);
		System.out.println("\nId: " + c.getIdCentro());
		System.out.println("Nombre: " + c.getNombreCentro());
		System.out.println("Direccion: " + c.getDireccionCentro());
		List<Profesor> ListaProfesores = c.getProfesores();

		System.out.println("Profesores:");
		if (ListaProfesores.isEmpty()) {
			System.out.println("Este centro no tiene profesores");
		}
		for (Profesor profesor : ListaProfesores) {
			System.out.println("\tId: " + profesor.getIdProfesor() + ", Nombre: " + profesor.getNombreProfesor());
		}

		conn.getTransaction().begin();
		conn.save(c);
		conn.getTransaction().commit();

		conn.close();
	}

	/*
	 * este metodo crea un centro
	 */

	public static void insertCentro(SessionFactory sf) {
		Session conn = sf.openSession();

		Scanner sc = new Scanner(System.in);
		Centro c = new Centro();
//		System.out.println("Indique el id del centro");
//		Integer IdCentro = sc.nextInt();
//		c.setIdCentro(IdCentro);
//		sc.nextLine();
		System.out.println("Indique el nombre del centro");
		String nombreCentro = sc.nextLine();
		c.setNombreCentro(nombreCentro);

		System.out.println("Indique la direccion del centro");
		String direccionCentro = sc.nextLine();
		c.setDireccionCentro(direccionCentro);

		conn.getTransaction().begin();
		conn.save(c);
		conn.getTransaction().commit();

		System.out.println("Centro creado.");

		conn.close();
	}

	/*
	 * este metodo te deja modificar el nombre del centro
	 */

	public static void updateCentro(SessionFactory sf) {
		Session conn = sf.openSession();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Indique el id del centro que quiere modificar:");
			Integer IdCentro = sc.nextInt();
			sc.nextLine();
			Centro c = conn.load(Centro.class, IdCentro);

			System.out.println("Indique el nombre nuevo del centro");
			String nombreCentro = sc.nextLine();
			c.setNombreCentro(nombreCentro);

			conn.getTransaction().begin();
			conn.saveOrUpdate(c);
			conn.getTransaction().commit();

			System.out.println("Centro modificado");
		} catch (EntityNotFoundException e) {
			System.out.println("El Centro no existe.");
		}
	}

	/*
	 * este metodo elimina el centro que le indiques por id
	 */

	public static void deleteCentro(SessionFactory sf) {
		Session conn = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Indique el id del centro que quiere borrar:");
		Integer IdCentro = sc.nextInt();
		sc.nextLine();

		try {
			conn.getTransaction().begin();
			Centro c = conn.load(Centro.class, IdCentro);
			conn.delete(c);
			conn.getTransaction().commit();

			System.out.println("Centro eliminado.");
		} catch (EntityNotFoundException e) {
			System.out.println("El centro no existe.");
		}

		conn.close();
	}
}
