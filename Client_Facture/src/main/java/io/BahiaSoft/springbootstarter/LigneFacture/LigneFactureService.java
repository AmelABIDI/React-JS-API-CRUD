package io.BahiaSoft.springbootstarter.LigneFacture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LigneFactureService {
	
	@Autowired
	private LigneFactureRepository lignefacturerepository;
	
	/*List<LigneFacture> lignefactures = new ArrayList<>(Arrays.asList(
			new LigneFacture(1,2,17),
			new LigneFacture(2,3,250),
			new LigneFacture(3,4,300),
			new LigneFacture(1,4,220),
			new LigneFacture(2,5,50),
			new LigneFacture(2,4,10),
			new LigneFacture(1,3,60),
			new LigneFacture(1,5,85),
			new LigneFacture(3,4,100)
			));*/	

	
	public List<LigneFacture> GetFactureAllLignesFacture(int idfacture){
		List<LigneFacture> lignesfacture = new ArrayList<>();
		lignefacturerepository.findByFactureId(idfacture)
		.forEach(lignesfacture::add);
		return lignesfacture;
		//return (List<LigneFacture>) lignefactures.stream().filter(lf -> lf.getIdFacture()==idFacture).findFirst().get();
	}
	
	public Optional<LigneFacture> getLigneFacture(int idlignefacture) {
		//return (lignefactures.stream().filter(f -> (f.getIdFacture()==idfacture&& f.getIdProduit()==idproduit)).findFirst().get());
		return lignefacturerepository.findById(idlignefacture);
	}
	
	public void addLigneFacture(LigneFacture lignefacture) {
		//lignefactures.add(facture);
		lignefacturerepository.save(lignefacture);
	}
	
	public void updateLigneFacture(LigneFacture lignefacture) {
		/*for(int i=0;i<lignefactures.size();i++) {
			LigneFacture f = lignefactures.get(i);
			if((f.getIdFacture()==idfacture)&&(f.getIdProduit()==idproduit)) {
				lignefactures.set(i, lignefacture);
				return;
			}
		}*/
		lignefacturerepository.save(lignefacture);
	}
	
	public void deleteLigneFacture(int id) {
		//lignefactures.removeIf(f -> (f.getIdFacture()==idfacture)&&(f.getIdProduit()==idproduit));
		
		lignefacturerepository.deleteById(id);
		
	}

}
