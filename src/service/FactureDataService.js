import axios from 'axios'

const Id = 1
const CLIENT_API_URL = 'http://localhost:8080'
//const Client_API_URL = `${CLIENT_API_URL}/clients/${{Id}}`

class FactureDataService {

    retrieveAllFactures(id1) {
        return axios.get(`${CLIENT_API_URL}/clients/${id1}/factures`);
    }

    deleteFacture(id1, id2) {
        //console.log('executed service')
        return axios.delete(`${CLIENT_API_URL}/clients/${id1}/factures/${id2}`);
    }

    retrieveFacture(id1,id2) {
        return axios.get(`${CLIENT_API_URL}/clients/${id1}/factures/${id2}`);
    }

    updateFacture(id1,id2, Facture) {
        return axios.put(`${CLIENT_API_URL}/clients/${id1}/factures/${id2}`, Facture);
    }
  
    createFacture(id1,Facture) {
        return axios.post(`${CLIENT_API_URL}/clients/${id1}/factures`, Facture);
    }


}



export default new FactureDataService()
