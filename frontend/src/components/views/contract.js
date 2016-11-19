import React from 'react';
import ReactDOM from 'react-dom';

function findContractById(contractId) {
    return {
        
    }
}

class Contract extends React.Component {
    componentDidMount() {
        this.setState({
           contract: findContractById(this.props.params.contractId)
        });
    }

    render() {
        return (
            <div>
                <h2>{this.state.contract.id}</h2>
                <div className="jumbotron"> 
                    <div className="container">
                        <div className="row">
                            <div className="col-md-2">Investor</div> 
                            <div className="col-md-2"><p>{this.state.contract.investorLogin}</p></div> 
                        </div>
                        <div className="row">
                            <div className="col-md-2">
                            </div> 
                            <div className="col-md-2">
                            </div> 
                        </div>
                        <div className="row">
                            <div className="col-md-2">
                            </div> 
                            <div className="col-md-2">
                            </div> 
                        </div>
                        <label>Login</label>
                    </div>
                </div>
            </div>
        );
    }
}

export default Contract; 
