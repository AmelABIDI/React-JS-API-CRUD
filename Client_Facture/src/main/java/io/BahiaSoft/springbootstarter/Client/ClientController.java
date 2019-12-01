package io.BahiaSoft.springbootstarter.Client;

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
public class ClientController {
	
	@Autowired
	private ClientService clientservice;
	
	@RequestMapping("/clients")
	public List<Client> GetAllClients(){
		return clientservice.GetAllClients();
		
	}
	
	@RequestMapping("/clients/{id}")
	public Optional<Client> getClient(@PathVariable int id) {
		return clientservice.getClient(id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/clients")
	public void addClient(@RequestBody Client client) {
		
		clientservice.addClient(client);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/clients/{id}")
	public void updateClient(@RequestBody Client client,@PathVariable int id) {
		
		clientservice.updateClient(id, client);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/clients/{id}")
	public void deleteClient(@PathVariable int id) {
		
		 clientservice.deleteClient(id);
	}


}
