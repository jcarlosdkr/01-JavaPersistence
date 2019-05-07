package com.jc.test;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jc.domain.Tramite;
import com.jc.domain.Tramite_;
import com.jc.util.HibernateUtil;

public class CosultarConAND {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactoty().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			// Es una fabrica para las piezas individuales del criterio
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Define funcionalidades para la capa superior de las consultas
			CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);

			// Definir el timpo de entidad que retorna la consulta
			Root<Tramite> root = criteria.from(Tramite.class);

			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date parseDate = sdf.parse("2019-05-06 22:11:23");
			
			// Construyebdo la consulta
			criteria.select(root)
				.where(builder.and(
							builder.like(root.get(Tramite_.tipoTramite), "%crédito%"),
							builder.lessThan(root.<Timestamp> get(Tramite_.fechaCreacion), new Timestamp(parseDate.getTime()))
							)
					);

			List<Tramite> tramites = session.createQuery(criteria).getResultList();
			
			for(Tramite tram : tramites){
				System.out.println(tram.toString());
			}


			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				e.getMessage();
			}
		} finally {
			session.close();
		}

	}
	
}
