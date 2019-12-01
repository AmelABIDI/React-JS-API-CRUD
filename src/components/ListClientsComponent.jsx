import React, { Component } from 'react';
import ClientDataService from '../service/ClientDataService'
class ListClientsComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            clients: [],
            message: null
        }
        this.refreshClients = this.refreshClients.bind(this)
        this.deleteClientClicked = this.deleteClientClicked.bind(this)
        this.updateClientClicked = this.updateClientClicked.bind(this)
        this.clientFacturesClicked = this.clientFacturesClicked.bind(this)
        this.addClientClicked = this.addClientClicked.bind(this)
    }

    componentDidMount() {
        this.refreshClients();
    }

    refreshClients() {
        ClientDataService.retrieveAllClients()
            .then(
                response => {
                    console.log(response);
                    this.setState({ clients: response.data })
                }
            )
    }

    deleteClientClicked(id) {
        ClientDataService.deleteClient( id)
            .then(
                response => {
                    this.setState({ message: `Delete of client ${id} Successful` })
                    this.refreshClients()
                }
            )
    
    }

    updateClientClicked(id) {
        console.log('update ' + id)
        this.props.history.push(`/clients/${id}`)
    }

    addClientClicked() {
        this.props.history.push(`/clients/-1`)
    }

    clientFacturesClicked(id){
        this.props.history.push(`/clients/${id}/factures`)
    }

    render() {
        return (
            <div className="container">
                <h3>All Clients</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nom</th>
                                <th>Prenom</th>
                                <th>Adresse</th>
                                <th>Ville</th>
                                <th>Delete</th>
                                <th>Update</th>
                                <th>Factures</th>
                            </tr>
                        </thead>
                        <tbody>
                        {
                                this.state.clients.map(
                                    client =>
                                        <tr key={client.id}>
                                            <td>{client.id}</td>
                                            <td>{client.nom}</td>
                                            <td>{client.prenom}</td>
                                            <td>{client.adress}</td>
                                            <td>{client.ville}</td>
                                            <td><button className="btn btn-warning"
                                             onClick={() => this.deleteClientClicked(client.id)}>Delete</button></td>
                                            <td><button className="btn btn-success" 
                                            onClick={() => this.updateClientClicked(client.id)}>Update</button></td>
                                            <td><button className="btn btn-success" 
                                            onClick={() => this.clientFacturesClicked(client.id)}>Factures</button></td>
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

export default ListClientsComponent