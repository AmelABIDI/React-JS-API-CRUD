import React, { Component } from 'react';
import FactureDataService from '../service/FactureDataService'
class ListFacturesComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            id1: this.props.match.params.id,
            factures: [],
            message: null
        }
        this.refreshFactures = this.refreshFactures.bind(this)
        this.deleteFactureClicked = this.deleteFactureClicked.bind(this)
        this.updateFactureClicked = this.updateFactureClicked.bind(this)
        //this.LignesFactureClicked = this.LignesFactureClickeds.bind(this)
        this.addFactureClicked = this.addFactureClicked.bind(this)
    }

    componentDidMount() {
        this.refreshFactures(this.id1);
    }

    refreshFactures(id1) {
        FactureDataService.retrieveAllFactures(id1)
            .then(
                response => {
                    console.log(response);
                    this.setState({ factures: response.data })
                }
            )
    }

    deleteFactureClicked(id1,id) {
        FactureDataService.deleteFacture( id1, id)
            .then(
                response => {
                    this.setState({ message: `Delete of facture ${id} Successful` })
                    this.refreshClients()
                }
            )
    
    }

    updateFactureClicked(id1,id) {
        console.log('update ' + id)
        this.props.history.push(`/clients/${id1}/factures/${id}`)
    }

    addFactureClicked(id1) {
        this.props.history.push(`/clients/${id1}/factures/-1`)
    }

  /*  LignesFactureClicked(id1,id){
        this.props.history.push(`/clients/${id1}/factures/${id}/lignesfacture`)
    }*/

    render() {
     
        return (
            <div className="container">
                <h3>All Factures</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Date</th>
                                
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                        {
                                this.state.factures.map(
                                    facture =>
                                        <tr key={facture.id}>
                                            <td>{facture.id}</td>
                                            <td>{facture.date}</td>
                                            
                                            <td><button className="btn btn-warning"
                                             onClick={() => this.deleteFactureClicked(facture.id)}>Delete</button></td>
                                            <td><button className="btn btn-success" 
                                            onClick={() => this.updateFactureClicked(facture.id)}>Update</button></td>
                                           
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-success" onClick={this.addClientClicked}>Add</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default ListFacturesComponent