package io.BahiaSoft.springbootstarter.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientrepository;
	
	/*List<Client> clients = new ArrayList<>(Arrays.asList(
			new Client(1,"Khaldi","Said","Cité les Palmiers, Bordj El Kiffan","Alger"),
			new Client(2,"BenMoussa","Mohammed","cité larbi ben m'hidi, Oran centre","Oran"),
			new Client(3,"Hanifi","Mustapha","14 Rue Salah Arrouri","Bejaia")
			));*/

	public List<Client> GetAllClients(){
		List<Client> clients= new ArrayList<>();
		clientrepository.findAll().forEach(clients::add);
		return clients;
	}
	
	public Optional<Client> getClient(int id) {
		//return clients.stream().filter(c -> c.getId()==id).findFirst().get();
		return clientrepository.findById(id);
	}
	
	public void addClient(Client client) {
		
		clientrepository.save(client);
	}
	
	public void updateClient(int id, Client client) {
		/*for(int i=0;i<clients.size();i++) {
			Client c = clients.get(i);
			if(c.getId()==id) {
				clients.set(i, client);
				return;
			}
		}*/
		
		clientrepository.save(client);
	}
	
	public void deleteClient(int id) {
		//clients.removeIf(c -> c.getId()==id);
		clientrepository.deleteById(id);
	}

}
