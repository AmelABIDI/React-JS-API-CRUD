import React, { Component } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import ProduitDataService from '../service/ProduitDataService';
class ProduitComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            designation: '',
            PrixUnitaire:0
           
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

        ProduitDataService.retrieveProduit(this.state.id)
            .then(response => this.setState({
                designation: response.data.designation, prixUnitaire: response.data.prixUnitaire
                
            }))
    }

    onSubmit(values) {

      
        let produit = {
            id: this.state.id,
            designation: values.designation,
            prixUnitaire: values.prixUnitaire,
            targetDate: values.targetDate
        }

        if (this.state.id === -1) {
            ProduitDataService.createProduit( produit)
                .then(() => this.props.history.push('/produits'))
        } else {
            ProduitDataService.updateProduit( this.state.id, produit)
                .then(() => this.props.history.push('/produits'))
        }

        console.log(values);
    }

    validate(values) {
        let errors = {}
        if (!values.designation) {
            errors.designation = 'Enter a designation'
        } else if (values.designation.length < 3) {
            errors.designation = 'Enter atleast 5 Characters in designation'
        }
    
        return errors
    }

    render() {
        let { designation,prixUnitaire, id } = this.state

        return (
            <div>
            <h3>Produit</h3>
            <div className="container">
                <Formik
                    initialValues={{ id, designation, prixUnitaire }}
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
                                    <label>Designation</label>
                                    <Field className="form-control" type="text" name="designation" />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Prix Unitaire</label>
                                    <Field className="form-control" type="text" name="prixUnitaire" />
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

export default ProduitComponent