package io.BahiaSoft.springbootstarter.Client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Nom")
	@Size(max = 40)
	private String Nom;
	
	@Column(name = "Prenom")
	@Size(max = 40)
	private String Prenom;
	
	@Column(name = "Adresse")
	private String Adresse;
	
	@Column(name = "Ville")
	private String Ville;
	
	public Client(int id, String nom, String prenom, String adress, String ville) {
		super();
		this.id = id;
		Nom = nom;
		Prenom = prenom;
		Adresse = adress;
		Ville = ville;
	}
	public Client() {
		
	}
	@Override
	public String toString() {
		return "Client [Id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Adress=" + Adresse + ", Ville=" + Ville
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getAdress() {
		return Adresse;
	}
	public void setAdress(String adress) {
		Adresse = adress;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}

}
