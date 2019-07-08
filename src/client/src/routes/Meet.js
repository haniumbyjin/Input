import React from 'react';
import { Component } from "react";
import { observer, inject } from 'mobx-react';


@inject('stores')
@observer
class Meet extends Component {
  
  render() {
      
    return (
      
      <div>
          "Meet" page
      </div>
    );
  }
}



export default Meet;
