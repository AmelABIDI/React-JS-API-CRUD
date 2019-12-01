package io.BahiaSoft.springbootstarter.Produit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Produit")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column(name = "Designation")
	@Size(max = 40)
	private String Designation;
	
	@Column(name = "PrixUnitaire")
	private double PrixUnitaire;
	
	public Produit(int id, String designation, double prixUnitaire) {
		super();
		Id = id;
		Designation = designation;
		PrixUnitaire = prixUnitaire;
	}
	public Produit() {
		
	}
	@Override
	public String toString() {
		return "Produit [Id=" + Id + ", Designation=" + Designation + ", PrixUnitaire=" + PrixUnitaire + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public double getPrixUnitaire() {
		return PrixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		PrixUnitaire = prixUnitaire;
	}
	

}
