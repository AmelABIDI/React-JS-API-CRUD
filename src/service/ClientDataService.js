import axios from 'axios'

const Id = 1
const CLIENT_API_URL = 'http://localhost:8080'
//const Client_API_URL = `${CLIENT_API_URL}/clients/${{Id}}`

class ClientDataService {

    retrieveAllClients() {
        return axios.get(`${CLIENT_API_URL}/clients`);
    }

    deleteClient(id) {
        //console.log('executed service')
        return axios.delete(`${CLIENT_API_URL}/clients/${id}`);
    }

    retrieveClient(id) {
        return axios.get(`${CLIENT_API_URL}/clients/${id}`);
    }

    updateClient(id, client) {
        return axios.put(`${CLIENT_API_URL}/clients/${id}`, client);
    }
  
    createClient(client) {
        return axios.post(`${CLIENT_API_URL}/clients/`, client);
    }


}



export default new ClientDataService()
