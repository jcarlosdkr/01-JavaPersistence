package com.jc.test;

import java.sql.Timestamp;
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

public class CRUDCriteria {

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

			// Construyebdo la consulta
			// Se obtiene un solo registro con la consulta select * from tramite
			// where idTramite = 2
			criteria.select(root).where(builder.equal(root.get(Tramite_.idTramite), 4));

			// Ya que la consulta criteria solo devuelve un registro
			// Se regresa al nuevo objeto tramite y se modifica
			Tramite tramite = session.createQuery(criteria).getSingleResult();
			tramite.setTipoTramite("Avaluo");

			// Se creará otro trámite
			Date date = new Date();
			Tramite tramite2 = new Tramite("Nuevo Avaluo", new Timestamp(date.getTime()));

			// con persistencia se acualiza el nuevo tipoTramite
			// usando los métodos update hace la actualización
			// o si el registro es nuevo o se queire actualizar uno existente se
			// puede ocupar el método saveOrUpdate
			// session.update(tramite);
			session.saveOrUpdate(tramite);
			session.saveOrUpdate(tramite2);

			
			// Boorrar un registro
			
			session.delete(tramite);
			
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
