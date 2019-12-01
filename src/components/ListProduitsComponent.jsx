import React, { Component } from 'react';
import ProduitDataService from '../service/ProduitDataService'
class ListProduitsComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            produits: [],
            message: null
        }
        this.refreshProduits = this.refreshProduits.bind(this)
        this.deleteProduitClicked = this.deleteProduitClicked.bind(this)
        this.updateProduitClicked = this.updateProduitClicked.bind(this)
        this.addProduitClicked = this.addProduitClicked.bind(this)
    }

    componentDidMount() {
        this.refreshProduits();
    }

    refreshProduits() {
        ProduitDataService.retrieveAllProduits()//HARDCODED
            .then(
                response => {
                    console.log(response);
                    this.setState({ produits: response.data })
                }
            )
    }

    deleteProduitClicked(id) {
        ProduitDataService.deleteProduit( id)
            .then(
                response => {
                    this.setState({ message: `Delete of Produit ${id} Successful` })
                    this.refreshProduits()
                }
            )
    
    }

    updateProduitClicked(id) {
        console.log('update ' + id)
        this.props.history.push(`/produits/${id}`)
    }

    addProduitClicked() {
        this.props.history.push(`/produits/-1`)
    }

    render() {
        return (
            <div className="container">
                <h3>All Produits</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Designation</th>
                                <th>Prix Unitaire</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                        {
                                this.state.produits.map(
                                    produit =>
                                        <tr key={produit.id}>
                                            <td>{produit.id}</td>
                                            <td>{produit.designation}</td>
                                            <td>{produit.prixUnitaire}</td>
                                            
                                            <td><button className="btn btn-warning"
                                             onClick={() => this.deleteProduitClicked(produit.id)}>Delete</button></td>
                                            <td><button className="btn btn-success" onClick={() => this.updateProduitClicked(produit.id)}>Update</button></td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-success" onClick={this.addProduitClicked}>Add</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default ListProduitsComponent