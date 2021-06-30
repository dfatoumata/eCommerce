package fr.doranco.ecommerce.main;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.hibernate.Session;

import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.entity.pojo.Commande;
import fr.doranco.ecommerce.entity.pojo.Params;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.ecommerce.model.HibernateConnector;
import fr.doranco.ecommerce.model.dao.CommandeDao;
import fr.doranco.ecommerce.model.dao.ICommandeDao;
import fr.doranco.ecommerce.model.dao.IUtilisateurDao;
import fr.doranco.ecommerce.model.dao.ParamsDao;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;
import fr.doranco.ecommerce.utils.CryptageDesPbeBlowfish;
import fr.doranco.ecommerce.utils.Dates;
import fr.doranco.ecommerce.utils.GenerateKey;

public class Main {
	
	
	static IUtilisateurDao UtilisateurDao = new UtilisateurDao();
	static ICommandeDao cmdDao = new CommandeDao();
	
	public static void main(String[] args) {
		
		try {

			Session session = HibernateConnector.getInstance().getSession();
			System.out.println("Contexte Hibernate démarré avec succès.");
			System.out.println(session);

			String algorithm = AlgorithmesCryptagePrincipal.DES.getAlgorithme();
			SecretKey cleCryptage = GenerateKey.getKey(algorithm, 56);
			byte[] cleCryptageBytes = cleCryptage.getEncoded();
			Params params = new Params();
			
			params.setCleCrypatage(cleCryptageBytes);
			ParamsDao paramsDao = new ParamsDao();
			
			paramsDao.add(params);
			intialiser();
			System.out.println(session);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void intialiser() throws Exception {
		
		Adresse adresse1 = new Adresse(12, "Rue Lafayette", "Paris", "75000");
		Adresse adresse2 = new Adresse(6, "Boulevard Blaise Pascal", "Lyon", "69000");
		Adresse adresse3 = new Adresse(12, "Rue Lafayette", "Paris", "75000");
		Adresse adresse4 = new Adresse(6, "Boulevard Blaise Pascal", "Rennes", "35000");
		Adresse adresse5 = new Adresse(12, "Rue Paul Lafargue", "Paris", "75000");
		Adresse adresse6 = new Adresse(6, "Boulevard Blaise Pascal", "Rennes", "35000");
		
		String algorithm = AlgorithmesCryptagePrincipal.DES.getAlgorithme();
		ParamsDao paramsDao = new ParamsDao();
		Params params = paramsDao.get(Params.class, 1);
		
		SecretKey cleCryptage = new SecretKeySpec(params.getCleCrypatage(), algorithm);
		
		byte[] motDePasseCrypte = CryptageDesPbeBlowfish.encrypt(algorithm, "test", cleCryptage);
		byte[] motDePasseCrypte2 = CryptageDesPbeBlowfish.encrypt(algorithm, "test123", cleCryptage);	
		Utilisateur Utilisateur = new Utilisateur("Mme","Fatou", "Diarra", Dates.convertStringToDateUtil("18/06/1940"), true, "C","dfatoumata57@yahoo.fr",motDePasseCrypte);
		Utilisateur Utilisateur2 = new Utilisateur("M.","toto", "tata",  Dates.convertStringToDateUtil("18/06/1940"), true, "A","dfatoumata57@outlook.fr",motDePasseCrypte2);
		Commande commande = new Commande(10, Dates.convertStringToDateUtil("10/05/2021"), Dates.convertStringToDateUtil("18/05/2021"), 25.0,50.0, 40.0);
		
		
		Commande commande2 = new Commande(14, Dates.convertStringToDateUtil("18/05/2021"), Dates.convertStringToDateUtil("25/05/2021"), 25.0,50.0, 40.0);
		Commande commande3 = new Commande(10, Dates.convertStringToDateUtil("10/05/2021"), Dates.convertStringToDateUtil("18/05/2021"), 25.0,50.0, 40.0);
		Commande commande4 = new Commande(14, Dates.convertStringToDateUtil("18/05/2021"), Dates.convertStringToDateUtil("25/05/2021"), 25.0,50.0, 40.0);
		Commande commande5 = new Commande(10, Dates.convertStringToDateUtil("10/05/2021"), Dates.convertStringToDateUtil("18/05/2021"), 25.0,50.0, 40.0);
		Commande commande6 = new Commande(14, Dates.convertStringToDateUtil("18/05/2021"), Dates.convertStringToDateUtil("25/05/2021"), 25.0,50.0, 40.0);
		
		
		adresse1.setUtilisateur(Utilisateur);
		Utilisateur.getAdresses().add(adresse1);						
		commande.setUtilisateur(Utilisateur);
		Utilisateur.getCommandes().add(commande);
		
		adresse2.setUtilisateur(Utilisateur2); 
		Utilisateur2.getAdresses().add(adresse2);			
		commande2.setUtilisateur(Utilisateur2);	
		Utilisateur2.getCommandes().add(commande2);

		adresse3.setUtilisateur(Utilisateur2); 
		Utilisateur2.getAdresses().add(adresse3);			
		commande3.setUtilisateur(Utilisateur2);	
		Utilisateur2.getCommandes().add(commande3);
		
		adresse4.setUtilisateur(Utilisateur2); 
		Utilisateur2.getAdresses().add(adresse4);			
		commande4.setUtilisateur(Utilisateur2);	
		Utilisateur2.getCommandes().add(commande4);
		
		adresse5.setUtilisateur(Utilisateur2); 
		Utilisateur2.getAdresses().add(adresse5);			
		commande5.setUtilisateur(Utilisateur2);	
		Utilisateur2.getCommandes().add(commande5);
		
		adresse6.setUtilisateur(Utilisateur); 
		Utilisateur.getAdresses().add(adresse6);			
		commande6.setUtilisateur(Utilisateur);	
		Utilisateur.getCommandes().add(commande6);
		
		UtilisateurDao.add(Utilisateur);
		UtilisateurDao.add(Utilisateur2);
	}

}
