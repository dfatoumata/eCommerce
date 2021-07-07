package fr.doranco.ecommerce.main;
import javax.crypto.SecretKey;

import org.hibernate.Session;

import fr.doranco.ecommerce.entity.pojo.Params;
import fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.ecommerce.model.HibernateConnector;
import fr.doranco.ecommerce.model.dao.ParamsDao;
import fr.doranco.ecommerce.utils.GenerateKey;


public class Main {

	public static void main(String[] args)  {
	
	Session session = null;

		session = HibernateConnector.getInstance().getSession();
			System.out.println(session);
			
//		String algorithm = AlgorithmesCryptagePrincipal.DES.getAlgorithme();
//         SecretKey cleCryptage = null;
//	try {
//			cleCryptage = GenerateKey.getKey(algorithm, 56);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            byte[] cleCryptageBytes = cleCryptage.getEncoded();
//            Params params = new Params();
//
//            params.setCleCrypatage(cleCryptageBytes);
//            ParamsDao paramsDao = new ParamsDao();
//
//            try {
//				paramsDao.add(params);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//	IUtilisateurDao userDao = new UtilisateurDao();
//
//	Adresse adresse1 = new Adresse(12, "Rue Lafayette", "Paris", "75000");
//	Adresse adresse2 = new Adresse(6, "Boulevard Blaise Pascal", "Lyon", "69000");
//	Adresse adresse3 = new Adresse(12, "Rue Lafayette", "Paris", "75000");
//	Adresse adresse4 = new Adresse(6, "Boulevard Blaise Pascal", "Rennes", "35000");
//	Adresse adresse5 = new Adresse(12, "Rue Paul Lafargue", "Paris", "75000");
//	Utilisateur user = new Utilisateur();
//	
//	String algorithm = fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal.DES.getAlgorithme();
//	SecretKey cleCryptage = new SecretKeySpec(user.getPassword(), algorithm);
//	byte[] passwordCrypte = user.getPassword();
//	String passwordDecrypte = fr.doranco.ecommerce.utils.CryptageDesPbeBlowfish.decrypt(algorithm, passwordCrypte, cleCryptage);
	
//	new Adresse(6, "Boulevard Blaise Pascal", "Rennes", "35000");
//	
//	Utilisateur Utilisateur = new Utilisateur("Mme","Fatou", "Diarra", Dates.convertStringToDateUtil("18/06/1940"), true, "C","dfatoumata57@yahoo.fr",passwordCrypte);
//	Utilisateur Utilisateur2 = new Utilisateur("M.","toto", "tata",  Dates.convertStringToDateUtil("18/06/1940"), true, "A","dfatoumata57@outlook.fr",passwordCrypte);
//	Commande commande = new Commande(10, Dates.convertStringToDateUtil("10/05/2021"), Dates.convertStringToDateUtil("18/05/2021"), 25.0,50.0, 40.0);
//	
//	
//	Commande commande2 = new Commande(14, Dates.convertStringToDateUtil("18/05/2021"), Dates.convertStringToDateUtil("25/05/2021"), 25.0,50.0, 40.0);
//	Commande commande3 = new Commande(10, Dates.convertStringToDateUtil("10/05/2021"), Dates.convertStringToDateUtil("18/05/2021"), 25.0,50.0, 40.0);
//	Commande commande4 = new Commande(14, Dates.convertStringToDateUtil("18/05/2021"), Dates.convertStringToDateUtil("25/05/2021"), 25.0,50.0, 40.0);
//	Commande commande5 = new Commande(10, Dates.convertStringToDateUtil("10/05/2021"), Dates.convertStringToDateUtil("18/05/2021"), 25.0,50.0, 40.0);
//	Commande commande6 = new Commande(14, Dates.convertStringToDateUtil("18/05/2021"), Dates.convertStringToDateUtil("25/05/2021"), 25.0,50.0, 40.0);
//	
//	
//	adresse1.setUtilisateur(Utilisateur);
//	Utilisateur.getAdresses().add(adresse1);						
//	commande.setUtilisateur(Utilisateur);
//	Utilisateur.getCommandes().add(commande);
//	
//	adresse2.setUtilisateur(Utilisateur2); 
//	Utilisateur2.getAdresses().add(adresse2);			
//	commande2.setUtilisateur(Utilisateur2);	
//	Utilisateur2.getCommandes().add(commande2);
//
//	adresse3.setUtilisateur(Utilisateur2); 
//	Utilisateur2.getAdresses().add(adresse3);			
//	commande3.setUtilisateur(Utilisateur2);	
//	Utilisateur2.getCommandes().add(commande3);
//	
//	adresse4.setUtilisateur(Utilisateur2); 
//	Utilisateur2.getAdresses().add(adresse4);			
//	commande4.setUtilisateur(Utilisateur2);	
//	Utilisateur2.getCommandes().add(commande4);
//	
//	adresse5.setUtilisateur(Utilisateur2); 
//	Utilisateur2.getAdresses().add(adresse5);			
//	commande5.setUtilisateur(Utilisateur2);	
//	Utilisateur2.getCommandes().add(commande5);
//	
//		
//	commande6.setUtilisateur(Utilisateur);	
//	Utilisateur.getCommandes().add(commande6);
//	
//	userDao.add(Utilisateur);
//	userDao.add(Utilisateur2);
//
//
//	
//	
//		
//
//			
//	//	System.out.println(userDao.getUsersOfVille("paris"));
//		//System.out.println("=====================================");
//	
//	
//	
//	}
//	catch (Exception e ) {
//		e.printStackTrace();
//	}
	}
}
