import React, { Component } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import FactureDataService from '../service/FactureDataService';
class FactureComponent extends Component {

        constructor(props) {
            super(props)

        this.state = {
            id: this.props.match.params.id,
            date: '',
            
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
        FactureDataService.retrieveFacture(this.state.id)
            .then(response => this.setState({
                date:response.data.date
            }))
    }

    onSubmit(values) {
      
        let facture = {
            id: this.state.id,
            date: values.date,
            targetDate: values.targetDate
        }

        if (this.state.id === -1) {
            FactureDataService.createFacture( facture)
                .then(() => this.props.history.push('/clients/1/factures'))
        } else {
            FactureDataService.updateClient( this.state.id, facture)
                .then(() => this.props.history.push('/clients/1/factures'))
        }

        console.log(values);
    }

    validate(values) {
        let errors = {}
        if (!values.date) {
            errors.date = 'Enter a date'
        } else if (values.date.length < 3) {
            errors.date = 'Enter 8 Characters in date'
        }
    
        return errors
    }

    render() {
      
        let { date, id } = this.state
        return (
            <div>
            <h3>Facture</h3>
            <div className="container">
                <Formik
                    initialValues={{ id, date }}
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
                                    <label>Date Facture</label>
                                    <Field className="form-control" type="Date" name="date" />
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
export default FactureComponent