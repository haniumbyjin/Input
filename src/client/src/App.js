import React from 'react';
import { Component } from "react";
import './App.css';
import Meet from "./routes/Meet";
import { observer, inject } from 'mobx-react';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import FileUpload from './component/FileUpload';
import FilePage from './routes/FilePage';

@inject('stores')
@observer
class App extends Component {

  render() {
    const  { testData } = this.props.stores.example;
    return (

    <Router>
    <div className="App">
        Conference Manager <br/>
        mobx 변수 사용 => {testData}<br/><br/>
        <div >
        <Switch>
        {/* <Route exact path="/" component={Meet}></Route> */}
        <Route path="/file" component={FilePage}></Route>
        <Route path="/meet" component={Meet}></Route>
        </Switch>
        </div>
    </div>
   </Router>
    );

  }
}
export default App;
