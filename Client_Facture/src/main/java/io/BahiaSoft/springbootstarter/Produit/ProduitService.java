package io.BahiaSoft.springbootstarter.Produit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitService {
	
	@Autowired
	private ProduitRepository produitrepository;
	
	List<Produit> produits = new ArrayList<>(Arrays.asList(
			new Produit(1,"Produit1",360.50),
			new Produit(2,"Produit2",2200.00),
			new Produit(3,"Produit3",3000.00),
			new Produit(4,"Produit4",750.00),
			new Produit(5,"Produit5",1500.20)
			));

	public List<Produit> GetAllProduits(){
		List<Produit> produits = new ArrayList<>();
		produitrepository.findAll().forEach(produits::add);
		return produits;
	}
	
	public Optional<Produit> getProduit(int id) {
		//return produits.stream().filter(p -> p.getId()==id).findFirst().get();
		return produitrepository.findById(id);
	}
	
	public void addProduit(Produit produit) {
		
		produitrepository.save(produit);
	}
	
	public void updateProduit(int id, Produit produit) {
		/*for(int i=0;i<produits.size();i++) {
			Produit p = produits.get(i);
			if(p.getId()==id) {
				produits.set(i, produit);
				return;
			}
		}*/
		produitrepository.save(produit);
	}
	
	public void deleteProduit(int id) {
		//produits.removeIf(p -> p.getId()==id);
		produitrepository.deleteById(id);
	}

}
