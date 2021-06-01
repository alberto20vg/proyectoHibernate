package com.accesodatos.hibernate.ProyectoHibernateAnotaciones;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {

		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
		TablaCentros tc = new TablaCentros();
		
		TablaProfesores tp = new TablaProfesores();
		
		TablaAlumnos ta = new TablaAlumnos();
		
		TablaImparte ti = new TablaImparte();
		
		Consultas c = new Consultas();
		
//		tc.insertCentro(sf);
		
//		tc.selectCentro(sf);
		
//		tc.updateCentro(sf);
		
//		tc.deleteCentro(sf);
		
//		tp.insertProfesor(sf);
		
//		tp.selectProfesor(sf);
		
//		tp.updateCentro(sf);
		
//		tp.deleteProfesor(sf);
		
//		ta.insertAlumno(sf);
		
//		ta.selectAlumno(sf);
		
		
//		ta.deleteAlumno(sf);
		
//		ti.insertImparte(sf);

//		ti.selectProfesorAlumno(sf);

//		c.select1(sf);
		
//		c.select2(sf);
		
		c.select3(sf);

		sf.close();
	}


	
	
}
