package fr.doranco.ecommerce.vue;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "articleBean")
@SessionScoped
public class ArticleBean implements Serializable  {
	

	private static final long serialVersionUID = 1L;

private String articleId;
	
	@ManagedProperty(name = "nom", value = "")
	private String nom;
	
	@ManagedProperty(name = "description", value = "")
	private String description;
	
	@ManagedProperty(name = "prix", value = "")
	private String prix;
	
	@ManagedProperty(name = "remise", value = "")
	private String remise;
	
	@ManagedProperty(name = "stock", value = "")
	private String stock;
	
	@ManagedProperty(name = "isVendable", value = "")
	private String isVendable;
	
	
	
}
