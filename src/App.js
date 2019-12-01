import React, {Component} from 'react';
import { BrowserRouter as Router, Route , Switch} from 'react-router-dom'
import './App.css';
import InstructorApp from './components/InstructorApp';
import ListClientsComponent from './components/ListClientsComponent';
import ClientComponent from './components/ClientComponent';
import ListProduitsComponent from './components/ListProduitsComponent';
import ListFacturesComponent from './components/ListFacturesComponent';
import FactureComponent from './components/FactureComponent';
import ProduitComponent from './components/ProduitComponent';
//import axios from 'axios';
class App extends Component{
  constructor(props){
    super(props);
    this.state={
      items: [],
      isLoaded : false,
    }
  }

 
  render(){

      return (
        <div className="App">
          <header className="App-header">
            <h1 className="App-title">Bahia Soft</h1>
          </header>
          <div className="container">
        <InstructorApp />
       
        <Router>
                <Switch>
                        <Route path="/"  component={ListClientsComponent} />
                        <Route path="/clients"  component={ListClientsComponent} />
                        <Route path="/clients/:id" component={ClientComponent} />
                        <Route path="/produits"  component={ListProduitsComponent} />
                        <Route path="/produits/:id"  component={ProduitComponent} />
                        <Route path="/clients/:id/factures/:id"  component={FactureComponent} />
                        <Route path="/clients/:id/factures"  component={ListFacturesComponent} />
                </Switch>
        
       
        </Router>
      </div>
          
          
          
        </div>
      );
    
      

  }

}

export default App;
