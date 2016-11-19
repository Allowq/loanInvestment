import React from 'react';
import ReactDOM from 'react-dom';
import Operation from './loan';

class InvestmentOperations extends React.Component {
    render() {
        var operations = [];

        this.props.operations.forEach((o) => {
            operations.push((<Operation 
                key={o.uid}
                investor={o.investor}
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
                                <th>Investor</th>
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