package fr.doranco.ecommerce.main;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.validation.constraints.NotEmpty;

import org.hibernate.Session;

import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.Categorie;
import fr.doranco.ecommerce.entity.pojo.Commande;
import fr.doranco.ecommerce.entity.pojo.Params;
import fr.doranco.ecommerce.entity.pojo.Utilisateur;
import fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.ecommerce.model.HibernateConnector;
import fr.doranco.ecommerce.model.dao.ArticleDao;
import fr.doranco.ecommerce.model.dao.CategorieDao;
import fr.doranco.ecommerce.model.dao.CommandeDao;
import fr.doranco.ecommerce.model.dao.IArticleDao;
import fr.doranco.ecommerce.model.dao.ICategorieDao;
import fr.doranco.ecommerce.model.dao.ICommandeDao;
import fr.doranco.ecommerce.model.dao.IUtilisateurDao;
import fr.doranco.ecommerce.model.dao.ParamsDao;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;
import fr.doranco.ecommerce.utils.CryptageDesPbeBlowfish;
import fr.doranco.ecommerce.utils.Dates;
import fr.doranco.ecommerce.utils.GenerateKey;

public class Main {
	static ICategorieDao categorieDao = new CategorieDao();
	static IArticleDao articleDao = new ArticleDao();
	static IUtilisateurDao UtilisateurDao = new UtilisateurDao();
	static ICommandeDao cmdDao = new CommandeDao();
	
	public static void main(String[] args) {
		
		try {

			Session session = HibernateConnector.getInstance().getSession();
			System.out.println("Contexte Hibernate démarré avec succès.");
			System.out.println(session);

			intialiser();
			
			System.out.println(session);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void intialiser() throws Exception {
		Categorie categorie1 = new Categorie("Alimentaire",20);
		categorieDao.add(categorie1);
		Categorie categorie2 = new Categorie("Beaute",0);
		categorieDao.add(categorie2);
		Categorie categorie3 = new Categorie("Textile",30);
		categorieDao.add(categorie3);
		
		Article article1 = new Article("Fromage","Fromage emmental",3.90,0,300,true);
		article1.setCategorie(categorie1);
		
		Article article2 = new Article("Lait","Lait entier 1L",1.50,0,250,true);
		article2.setCategorie(categorie1);
		
		
		Article article3 = new Article("Crème solaire","Crème solaire 100ml , SPF 50",30.90,20,100,true);
		article3.setCategorie(categorie2);
		
		Article article4 = new Article("Lingette","Lingette démaquillante lavable 100pc",7.9,0,100,true);
		article4.setCategorie(categorie2);
		
		
		
		Article article5 = new Article("Bonnet","Bonnet coton femme",10.50,50,20,true);
		article5.setCategorie(categorie3);
		
		Article article6= new Article("Pantalon","Pontalon fluide femme",20.9,30,20,false);
		article6.setCategorie(categorie3);
		
		articleDao.add(article1);
		
		articleDao.add(article2);
		
		articleDao.add(article3);
		
		articleDao.add(article4);
		
		articleDao.add(article5);
		
		articleDao.add(article6);
		
		
		
	}

}
