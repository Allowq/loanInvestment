import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, Link, browserHistory } from 'react-router';

class Investment extends React.Component {
    render () {
        return (
           <tr>
                <td>{this.props.borrower}</td>
                <td><Link to={`/contract/${this.props.contract}`}>{this.props.contract}</Link></td> 
                <td>{this.props.risk}</td>
                <td><button className="btn btn-primary" onClick={this.props.remove}>Close</button></td>
           </tr> 
        );
    }
}

export default Investment;