package fr.doranco.ecommerce.control;

import fr.doranco.ecommerce.entity.dto.CommandeDto;
import fr.doranco.ecommerce.entity.pojo.Commande;
import fr.doranco.ecommerce.model.dao.CommandeDao;
import fr.doranco.ecommerce.model.dao.ICommandeDao;
import fr.doranco.ecommerce.utils.Dates;

public class CommandeMetier implements ICommandeMetier{

	ICommandeDao commandeDao = new CommandeDao();
	@Override
	public void addCommande(CommandeDto commandeDto) throws Exception {
		
		Commande commande = new Commande();
		/*private String id;
		private String numero;
		private String dateCreation;
		private String dateLivraison;
		private String totalRemise;
		private String fraisExpedition;
		private String totalGeneral;
		private String adresseFacturation;
		private String adresseLivraison;
		private String cartePaiementDefaut;
		private String utilisateur;
		private String lignesCommande ;*/
		commande.setNumero(Integer.parseInt(commandeDto.getNumero()));

		commande.setDateCreation(Dates.convertStringToDateUtil(commandeDto.getDateCreation()));
		
		commande.setDateCreation(Dates.convertStringToDateUtil(commandeDto.getDateLivraison()));
		
		commande.setTotalRemise(Double.parseDouble(commandeDto.getTotalRemise()));
		
		commande.setFraisExpedition(Double.parseDouble(commandeDto.getFraisExpedition()));
		
		commande.setTotalGeneral(Double.parseDouble(commandeDto.getTotalGeneral()));
		
		
		
		commandeDao.add(commande);
		
	}

	@Override
	public Commande getCommandeById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return commandeDao.get(Commande.class, id);
	}


	@Override
	public void updateCommande(Commande commande) throws Exception {
		commandeDao.update(commande);
		
	}

	@Override
	public void removeCommande(Commande commande) throws Exception {
		commandeDao.remove(commande);
		
	}

	
	
}
