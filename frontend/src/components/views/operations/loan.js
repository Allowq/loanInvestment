import React from 'react';
import ReactDOM from 'react-dom';

class Loan extends React.Component {
    render () {
        return (
            <tr>
                <td>{this.props.investor}</td>
                <td>{this.props.uniqueContract}</td>
                <td>{this.props.risk}</td>
                <td><button className="btn btn-primary">Close</button></td>
            </tr>
        );
    }
}

export default Loan;