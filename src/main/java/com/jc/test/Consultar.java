package com.jc.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.jc.domain.Tramite;
import com.jc.util.HibernateUtil;

public class Consultar {

	public static void main(String[] args){
		Session session = HibernateUtil.getSessionFactoty().openSession();
		session.beginTransaction();
		
		// Realizar consultas a la base de datos con condiciones con HQL
		
		Query<Tramite> query = session.createQuery("from Tramite where tipoTramite = :parametro").setParameter("parametro", "Avaluo");
		List<Tramite> tramites = query.getResultList();
		
		for(Tramite trams : tramites){
			System.out.println(trams);
		}
		
		System.out.println();
		// Realizar una consulta de toda la tabla con HQL
		
		tramites = session.createQuery("from Tramite").getResultList();
		for(Tramite trams : tramites){
			System.out.println(trams);
		}
		
		System.out.println();

		

		session.getTransaction().commit();
		session.close();
	}
	
}
