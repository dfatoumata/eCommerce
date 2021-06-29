package fr.doranco.ecommerce.main;

import org.hibernate.Session;

import fr.doranco.ecommerce.model.HibernateConnector;

public class Main {

	public static void main(String[] args) {
		
		try {
			Session session = HibernateConnector.getInstance().getSession();
			System.out.println("Contexte Hibernate d�marr� avec succ�s.");
			System.out.println(session);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
