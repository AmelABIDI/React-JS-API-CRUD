package io.BahiaSoft.springbootstarter.Facture;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.BahiaSoft.springbootstarter.Client.Client;

@Entity
@Table(name="Facture")
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Date")
	private String Date;
	
	@ManyToOne
	private Client client;
	
	public Facture(int id, String date, int idClient) {
		super();
		this.id = id;
		Date = date;
		this.client = new Client(idClient,"","","","");
	}
	public Facture() {
		
	}
	@Override
	public String toString() {
		return "Facture [Id=" + id + ", Date=" + Date + ", IdClient=" + client.toString() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Client getIdClient() {
		return client;
	}
	public void setIdClient(Client idClient) {
		client = idClient;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	

}
