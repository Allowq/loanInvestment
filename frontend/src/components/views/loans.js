import React from 'react';
import ReactDOM from 'react-dom';
import InvestmentOperationts from './operations/loans';

class Loans extends React.Component {
    constructor(props) {
        super(props);
    }

    render () {        
        var operations = [
            {  
                uid: Math.random(),
                investor: "loan_investor1",
                risk: '25%'
            },
            {  
                uid: Math.random(),
                investor: "loan_investor2",
                risk: '15%'
            },
            {  
                uid: Math.random(),
                investor: "loan_investor3",
                risk: '2%'
            },
            {  
                uid: Math.random(),
                investor: "loan_investor4",
                risk: '5%'
            }
        ];
        return (
            <div> 
                <h2>Loans</h2>
                <InvestmentOperationts operations={operations} />
            </div>
        );
    }
}

export default Loans;