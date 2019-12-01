package io.BahiaSoft.springbootstarter.LigneFacture;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.BahiaSoft.springbootstarter.Facture.Facture;
import io.BahiaSoft.springbootstarter.Produit.Produit;

@CrossOrigin(maxAge = 3600)
@RestController
public class LigneFactureController {
	@Autowired
	private LigneFactureService lignesfactureservice;
	

	//recuperer toutes les lignes d'une facture donnée
	@RequestMapping("/clients/{idclient}/factures/{idfacture}/lignesfacture")
	public List<LigneFacture> GetAllLignesFacture(@PathVariable int idfacture){
		return lignesfactureservice.GetFactureAllLignesFacture(idfacture);	
	}
	
	//récuperer une ligne donnée d'une facture donnée d'un client
	@RequestMapping("/clients/{idclient}/factures/{idfacture}/lignesfacture/{idlignefacture}")
	public Optional<LigneFacture> getLigne(@PathVariable int idlignefacture) {
		return lignesfactureservice.getLigneFacture(idlignefacture);
	}
	
	//Ajouter une ligne de facture
	@RequestMapping(method = RequestMethod.POST, value="/clients/{idclient}/factures/{idfacture}/lignesfacture")
		public void addLigneFacture(@RequestBody LigneFacture lignefacture, @PathVariable int idfacture, int idProduit) {
			lignefacture.setFacture(new Facture(idfacture,"",0));
			lignefacture.setIdProduit(new Produit(idProduit,"",0.0));
			lignesfactureservice.addLigneFacture(lignefacture);
		}
	

	//Mise à jour d'une ligne de facture
	@RequestMapping(method = RequestMethod.PUT, value="/clients/{idclient}/factures/{idfacture}/lignesfacture/{idlignefacture}")
	public void updateligne(@RequestBody LigneFacture lignefacture, @PathVariable int idfacture, int idProduit) {
		lignefacture.setFacture(new Facture(idfacture,"",0));
		lignefacture.setIdProduit(new Produit(idProduit,"",0.0));
		lignesfactureservice.updateLigneFacture(lignefacture);
		
	}
	
	//Suppression d'une ligne de facture
	@RequestMapping(method= RequestMethod.DELETE, value="/clients/{idclient}/factures/{idfacture}/lignesfacture/{idlignefacture}")
	public void deleteligne(@PathVariable int idlignefacture) {
		lignesfactureservice.deleteLigneFacture(idlignefacture);
		
	}
	
}

	







	
	


