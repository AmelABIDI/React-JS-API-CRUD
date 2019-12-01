package io.BahiaSoft.springbootstarter.Produit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class ProduitController {
	
	@Autowired
	private ProduitService produitservice;
	
	@RequestMapping("/produits")
	public List<Produit> GetAllProduits(){
		return produitservice.GetAllProduits();
		
	}
	
	@RequestMapping("/produits/{id}")
	public Optional<Produit> getProduit(@PathVariable int id) {
		return produitservice.getProduit(id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/produits")
	public void addProduit(@RequestBody Produit produit) {
		
		produitservice.addProduit(produit);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/produits/{id}")
	public void updateFacture(@RequestBody Produit produit,@PathVariable int id) {
		
		produitservice.updateProduit(id, produit);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/produits/{id}")
	public void deleteProduit(@PathVariable int id) {
		
		 produitservice.deleteProduit(id);
	}


}
