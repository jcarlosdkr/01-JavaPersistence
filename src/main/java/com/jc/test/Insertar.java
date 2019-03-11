package com.jc.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import com.jc.domain.Tramite;
import com.jc.util.HibernateUtil;

public class Insertar {

	public static void main(String[] args){
		Session session = HibernateUtil.getSessionFactoty().openSession();

		session.beginTransaction();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		
		Tramite tramite = new Tramite("Avaluo", new Timestamp(date.getTime()));
		
		// Salvar el Tramite   
		session.save(tramite); // insert into Tramite (tipoTramite, fechaTramite) values (?, ?)

		session.getTransaction().commit();
		session.close();
	}
	
}
