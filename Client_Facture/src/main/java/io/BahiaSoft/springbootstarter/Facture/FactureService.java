package io.BahiaSoft.springbootstarter.Facture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactureService {
	
	@Autowired
	private FactureRepository facturerepository;
	
	/*List<Facture> factures = new ArrayList<>(Arrays.asList(
			new Facture(1,"13/08/2019",1),
			new Facture(2,"21/09/2019",2),
			new Facture(3,"05/11/2019",3)
			));*/

	public List<Facture> GetAllFactures(int idclient){
		List<Facture> factures = new ArrayList<>();
		facturerepository.findByClientId(idclient)
		.forEach(factures::add);
		return factures;
	}
	
	public Optional<Facture> getFacture(int id) {
		//return factures.stream().filter(f -> f.getId()==id).findFirst().get();
		return facturerepository.findById(id);
	}
	
	public void addFacture(Facture facture) {
		
		facturerepository.save(facture);
	}
	
	public void updateFacture(int id, Facture facture) {
		/*for(int i=0;i<factures.size();i++) {
			Facture f = factures.get(i);
			if(f.getId()==id) {
				factures.set(i, facture);
				return;
			}
		}*/
		facturerepository.save(facture);
	}
	
	public void deleteFacture(int id) {
		//factures.removeIf(f -> f.getId()==id);
		facturerepository.deleteById(id);
	}

}
