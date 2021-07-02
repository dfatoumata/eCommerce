package fr.doranco.ecommerce.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateConnector {

	private static HibernateConnector instance;
	private static SessionFactory sessionFactory;

	private HibernateConnector() {

		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}

	}

	public Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}

	public static synchronized HibernateConnector getInstance() throws HibernateException {
		if (instance == null) {
			instance = new HibernateConnector();
		}
		return instance;
	}

	public static void shutdown() throws HibernateException {
		if (sessionFactory != null && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
		instance = null;
	}
}
