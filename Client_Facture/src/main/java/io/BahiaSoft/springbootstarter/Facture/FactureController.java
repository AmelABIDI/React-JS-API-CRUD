package io.BahiaSoft.springbootstarter.Facture;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.BahiaSoft.springbootstarter.Client.Client;
 
@CrossOrigin(maxAge = 3600)
@RestController
public class FactureController {
	@Autowired
	private FactureService factureservice;
	
	//Récuperer toutes les factures d'un client
	@RequestMapping("/clients/{idclient}/factures")
	public List<Facture> GetAllFactures(@PathVariable int idclient){
		return factureservice.GetAllFactures(idclient);	
	}
	
	//Récuperer une facture donnée d'un client donné
	@RequestMapping("/clients/{idclient}/factures/{idfacture}")
	public Optional<Facture> getFacture(@PathVariable int idfacture) {
		return factureservice.getFacture(idfacture);	
	}
	
	//Ajouter une facture à un client
	@RequestMapping(method = RequestMethod.POST, value="/clients/{idclient}/factures")
	public void addFacture(@RequestBody Facture facture, @PathVariable int idclient) {
		facture.setClient(new Client(idclient,"","","",""));
		factureservice.addFacture(facture);
	}

	//Mise à jour d'une facture
	@RequestMapping(method = RequestMethod.PUT, value="/clients/{id}/factures/{idfacture}")
	public void updateFacture(@RequestBody Facture facture,@PathVariable int idfacture,@PathVariable int idclient) {
		facture.setClient(new Client(idclient,"","","",""));
		factureservice.updateFacture(idfacture, facture);
	}
	
	//suppression d'une facture
	@RequestMapping(method = RequestMethod.DELETE, value="/clients/{idclient}/factures/{idfacture}")
	public void deleteFacture(@PathVariable int idfacture) {
		 factureservice.deleteFacture(idfacture);
	}


}













