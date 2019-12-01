import axios from 'axios'

const Id = 1
const PRODUIT_API_URL = 'http://localhost:8080'
//const Produit_API_URL = `${PRODUIT_API_URL}/produits/${{Id}}`

class ProduitDataService {

    retrieveAllProduits() {
        return axios.get(`${PRODUIT_API_URL}/produits`);
    }

    deleteProduit(id) {
        //console.log('executed service')
        return axios.delete(`${PRODUIT_API_URL}/produits/${id}`);
    }

    retrieveProduit(id) {
        return axios.get(`${PRODUIT_API_URL}/produits/${id}`);
    }

    updateProduit(id, produit) {
        return axios.put(`${PRODUIT_API_URL}/produits/${id}`, produit);
    }
  
    createProduit(produit) {
        return axios.post(`${PRODUIT_API_URL}/produits/`, produit);
    }


}



export default new ProduitDataService()
