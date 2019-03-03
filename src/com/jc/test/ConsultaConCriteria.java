package com.jc.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.jc.domain.Tramite;
import com.jc.domain.Tramite_;
import com.jc.util.HibernateUtil;

public class ConsultaConCriteria {

	public static void main(String[] args){
		Session session = HibernateUtil.getSessionFactoty().openSession();
		session.beginTransaction();	
		
		// Es una fabrica para las piezas individuales del criterio
		CriteriaBuilder builder = session.getCriteriaBuilder();
		// Define funcionalidades para la capa superior de las consultas
		CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);

		// Definir el timpo de entidad que retorna la consulta
		Root<Tramite> root = criteria.from(Tramite.class);
		
		// Construyendo la consulta
		criteria.select(root); // SELECT * FROM 
		
		List<Tramite> tramites = session.createQuery(criteria).getResultList();

		System.out.println();
		
		for(Tramite trams : tramites){
			System.out.println(trams);
		}
		
		System.out.println();
		
//		criteria.where(builder.equal(root.get("idTramite"), 2));
		// para no tener en hardcore se utiliza jpamodelgen y podamos tener esto Tramite_.idTramite 
		criteria.where(builder.equal(root.get(Tramite_.idTramite), 2));
		tramites = session.createQuery(criteria).getResultList();
		
		for(Tramite trams : tramites){
			System.out.println(trams);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
}
