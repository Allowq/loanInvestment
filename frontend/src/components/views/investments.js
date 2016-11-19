import React from 'react';
import ReactDOM from 'react-dom';
import InvestmentOperationts from './operations/investments';

class Investments extends React.Component {
    constructor(props) {
        super(props);
    }

    render () {
        var operations = [
            {  
                uid: Math.random(),
                borrower: "investment_borrower1"
            },
            {  
                uid: Math.random(),
                borrower: "investment_borrower2"
            }
        ];
        return (
            <div> 
                <h2>Investments</h2>
                <InvestmentOperationts operations={operations}/>
            </div>
        );
    }
}

export default Investments;