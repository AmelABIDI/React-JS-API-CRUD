package io.BahiaSoft.springbootstarter.LigneFacture;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import io.BahiaSoft.springbootstarter.Facture.Facture;
import io.BahiaSoft.springbootstarter.Produit.Produit;

@Entity
@Table(name="LigneFacture")
public class LigneFacture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idligneFacture;
	
	@ManyToOne
	private Produit idProduit;
	
	@Column(name = "Qte")
	private int Qte;
	
	@ManyToOne
	private Facture facture;
	
	public LigneFacture(int idligneFacture, int idFacture, int idProduit, int qte) {
		super();
		this.idligneFacture = idligneFacture;
		this.idProduit = new Produit(idProduit, "",0.0);
		Qte = qte;
		this.facture= new Facture(idFacture,"",0);
	}
	public LigneFacture() {
		
	}
	
	@Override
	public String toString() {
		return "LigneFacture [IdFacture=" + idligneFacture + ", IdProduit=" + idProduit + ", Qte=" + Qte + "]";
	}
	public int getIdligneFacture() {
		return idligneFacture;
	}
	public void setIdligneFacture(int idligneFacture) {
		this.idligneFacture = idligneFacture;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public Produit getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Produit idProduit) {
		this.idProduit = idProduit;
	}
	public int getQte() {
		return Qte;
	}
	public void setQte(int qte) {
		Qte = qte;
	}
	
}
