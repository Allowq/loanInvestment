import React from 'react';
import ReactDOM from 'react-dom';
import Operation from './investment';

class InvestmentOperations extends React.Component {
    render() {
        var operations = [];

        this.props.operations.forEach((o) => {
            operations.push((<Operation 
                key={o.uid}
                borrower={o.borrower}
                uniqueContract={o.uniqueContract}
                risk={o.risk}
            />));
        });

        return (
            <div className="jumbotron"> 
                <div className="container">
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                <th>Borrower</th>
                                <th>Unique contract</th>
                                <th>Risk</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {operations}
                        </tbody>
                    </table>
                </div>
            </div>  
        );
    }
}

export default InvestmentOperations;