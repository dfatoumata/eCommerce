package fr.doranco.ecommerce.model;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.doranco.ecommerce.entity.Utilisateur;
import fr.doranco.ecommerce.enums.Genre;
import fr.doranco.ecommerce.enums.TypeUtilisateur;
import fr.doranco.ecommerce.model.dao.IUtilisateurDao;
import fr.doranco.ecommerce.model.dao.UtilisateurDao;
import fr.doranco.ecommerce.utils.Dates;

public class UtilisateurDaoTest {

	IUtilisateurDao utilisateurDao = new UtilisateurDao();
	
	@Before
	public void setUp() throws Exception {

//		utilisateur.setGenre(Genre.M.toString());
//		utilisateur.setNom("Tata");
//		utilisateur.setPrenom("TITI");
//		utilisateur.setEmail("tototititata@gmail.com");
//		utilisateur.setTelephone("0768473179");;
//		utilisateur.setDateNaissance(Dates.convertStringToDateUtil("19/09/1995"));
//		utilisateur.setProfil(TypeUtilisateur.CLIENT.toString());
//		
//		
//		utilisateurException.setGenre(Genre.M.toString());
//		utilisateurException.setNom("Tata");
//		utilisateurException.setEmail("tototititata@gmail.com");
//		utilisateurException.setTelephone("0768473179");;
//		utilisateurException.setDateNaissance(Dates.convertStringToDateUtil("19/09/1995"));
//		utilisateurException.setProfil(TypeUtilisateur.CLIENT.toString());
	}         
	

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NullPointerException.class)
	public void testAddUtilisateurException1() throws Exception {
		
		 utilisateurDao.add(null);
	}

	@Test(expected = NullPointerException.class)
	public void testAddUtilisateurException2() throws Exception {
		
		Utilisateur user = new Utilisateur();
		utilisateurDao.add(user);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUtilisateurArgumentException() throws Exception {
		
		Utilisateur user = new Utilisateur();
		user.setGenre("");
		user.setNom("");
		user.setPrenom("");
		user.setEmail("");
		user.setTelephone("");
		user.setDateNaissance(Dates.convertStringToDateUtil("19/09/1995"));
		user.setProfil("");
		utilisateurDao.add(user);
		
	}
	
	@Test
	public void testAddUtilisateur() throws Exception {
		
		Utilisateur user = new Utilisateur();
		user.setGenre(Genre.M.toString());
		user.setNom("tata");
		user.setPrenom("titi");
		user.setEmail("tototititata@gmail.com");
		user.setTelephone("0768473179");
		user.setDateNaissance(Dates.convertStringToDateUtil("19/09/1995"));
		user.setProfil(TypeUtilisateur.CLIENT.toString());
		//récupérer last id (select max(id))
		utilisateurDao.add(user);
		assertNotNull(user);
		assertNotNull(user.getId());
		assertTrue(user.getId() > 0);
		
	}

	@Test
	public void testUpdateUtilisateur() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveUtilisateur() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUtilisateurs() {
		fail("Not yet implemented");
	}

}
