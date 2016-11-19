import React from 'react';
import ReactDOM from 'react-dom';
import InvestmentOperationts from './operations/investments';
import GetFetchParams from './../../http';
import { Router, Route, Link, browserHistory } from 'react-router';

class Investments extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            operations: []
        };
    }
   componentDidMount() {
        var data = {
            uuid: window.uid
        };
        
        //CreateHttpRequest('/auth', data)
        fetch('/tests/investments.json', GetFetchParams(data))
            .then(response => response.json())
            .then((responseJSON) => {
                this.setState({
                    operations: responseJSON
                });
                return responseJSON;
            })
            .catch(error => console.log(error));
    }

    removeHandler (uid) {
        var ops = this.state.operations;
        var op = ops.filter(op => op.uid == uid)[0];
        if(op) {
            var index = ops.indexOf(op);
            ops.splice(index, 1);
            this.setState({
                operations: ops 
            });
        }
    }

    render () {
        var operations = this.state.operations;
        return (
            <div> 
                <h2>Investments</h2>
                <InvestmentOperationts onRemove={this.removeHandler.bind(this)} operations={operations} />
            </div>
        );
    }
}

export default Investments;