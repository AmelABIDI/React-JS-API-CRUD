package io.BahiaSoft.springbootstarter.Facture;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FactureRepository extends CrudRepository<Facture, Integer> {

	public List<Facture> findByClientId(int idclient);
}
