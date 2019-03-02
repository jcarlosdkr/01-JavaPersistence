package com.jc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionfactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Para Hiberante 5.x
			// Crear SessionFactory desde hibernate.cfg.xml
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
			return metadata.getSessionFactoryBuilder().build();
		} catch (Throwable ex) {
			System.err.println("**** Creaci�n de SessionFactory fall�. " + ex.getMessage());
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactoty() {
		return sessionfactory;
	}

}
