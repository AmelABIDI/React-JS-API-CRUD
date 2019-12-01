import React, { Component } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import ClientDataService from '../service/ClientDataService';
class ClientComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            nom: '',
            prenom:'',
            adress:'',
            ville:''
        }

        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)

    }

    componentDidMount() {

        console.log(this.state.id)

        // eslint-disable-next-line
        if (this.state.id == -1) {
            return
        }

        ClientDataService.retrieveClient(this.state.id)
            .then(response => this.setState({
                nom: response.data.nom, prenom: response.data.prenom, 
                adress:response.data.adress, ville:response.data.ville
            }))
    }

    onSubmit(values) {

      
        let client = {
            id: this.state.id,
            nom: values.nom,
            prenom: values.prenom,
            adress: values.adress,
            ville: values.ville,
            targetDate: values.targetDate
        }

        if (this.state.id === -1) {
            ClientDataService.createClient( client)
                .then(() => this.props.history.push('/clients'))
        } else {
            ClientDataService.updateClient( this.state.id, client)
                .then(() => this.props.history.push('/clients'))
        }

        console.log(values);
    }

    validate(values) {
        let errors = {}
        if (!values.nom) {
            errors.nom = 'Enter a name'
        } else if (values.nom.length < 3) {
            errors.nom = 'Enter atleast 5 Characters in name'
        }
    
        return errors
    }

    render() {
        let { nom,prenom,adress,ville, id } = this.state

        return (
            <div>
            <h3>Client</h3>
            <div className="container">
                <Formik
                    initialValues={{ id, nom, prenom,adress,ville }}
                    onSubmit={this.onSubmit}
                    validateOnChange={false}
                    validateOnBlur={false}
                    validate={this.validate}
                    enableReinitialize={true}
                >
                    {
                        (props) => (
                            <Form>
                                <fieldset className="form-group">
                                    <label>Id</label>
                                    <Field className="form-control" type="text" name="id" disabled />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Nom</label>
                                    <Field className="form-control" type="text" name="nom" />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Prenom</label>
                                    <Field className="form-control" type="text" name="prenom" />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Adresse</label>
                                    <Field className="form-control" type="text" name="adress" />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Ville</label>
                                    <Field className="form-control" type="text" name="ville" />
                                </fieldset>
                                <button className="btn btn-success" type="submit">Save</button>
                            </Form>
                        )
                    }
                </Formik>

            </div>
        </div>
        )
  }

}

export default ClientComponent