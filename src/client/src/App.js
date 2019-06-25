import React from 'react';
import { Component } from "react";
import './App.css';
import { observer, inject } from 'mobx-react';

@inject('stores')
@observer
class App extends Component {

  render() {
    const  { testData } = this.props.stores.example;
    return (
      <div className="App">
        Conference Manager <br/><br/><br/>
        mobx 변수 사용 => {testData}
      </div>
    );
  }
}

export default App;
