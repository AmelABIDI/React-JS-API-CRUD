package io.BahiaSoft.springbootstarter.LigneFacture;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LigneFactureRepository extends CrudRepository<LigneFacture, Integer >{

	public List<LigneFacture> findByFactureId(int idfacture);

	
}
