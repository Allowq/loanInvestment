import React from 'react';
import ReactDOM from 'react-dom';

function findContractById(contractId) {
    return {
        
                "id": "",
                "investor": "",
                "borrower": "",
                "sum": "",
                "percent": "",
                "dateStart": "",
                "dateEnd": "",
                "deadline": "",
                "investor": ""
    }
}

class Contract extends React.Component {
    constructor (props) {
        super(props);
        this.state = {
            contract: {
                "id": "",
                "investor": "",
                "borrower": "",
                "sum": "",
                "percent": "",
                "dateStart": "",
                "dateEnd": "",
                "deadline": "",
                "investor": ""
            }
        };
    }

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
                        <div class="page-header">
                            <h1><small>Members</small></h1>
                        </div>
                        <div className="row">
                            <div className="col-md-2">Investor</div> 
                            <div className="col-md-2"><p>{this.state.contract.investor}</p></div> 
                        </div>
                        <div className="row">
                            <div className="col-md-2">Borrower</div> 
                            <div className="col-md-2"><p>{this.state.contract.borrower}</p></div> 
                        </div>
                        <div class="page-header">
                            <h1><small>Moneys</small></h1>
                        </div>
                        <div className="row">
                            <div className="col-md-2">Sum</div> 
                            <div className="col-md-2"><p>{this.state.contract.sum}</p></div> 
                        </div>
                        <div className="row">
                            <div className="col-md-2">Percent</div> 
                            <div className="col-md-2"><p>{this.state.contract.percent}</p></div> 
                        </div>
                        <div className="row">
                            <div className="col-md-2">Refund</div> 
                            <div className="col-md-2"><p>{this.state.contract.Refund}</p></div> 
                        </div>
                        <div class="page-header">
                            <h1><small>Terms</small></h1>
                        </div>
                        <div className="row">
                            <div className="col-md-2">Date start</div> 
                            <div className="col-md-2"><p>{this.state.contract.dateStart}</p></div> 
                        </div>
                        <div className="row">
                            <div className="col-md-2">Date end</div> 
                            <div className="col-md-2"><p>{this.state.contract.dateEnd}</p></div> 
                        </div>
                        <div className="row">
                            <div className="col-md-2">Deadline</div> 
                            <div className="col-md-2"><p>{this.state.contract.deadline}</p></div> 
                        </div>
                        <div className="row">
                            <div className="col-md-2">Date close</div> 
                            <div className="col-md-2"><p>{this.state.contract.dateClose}</p></div> 
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Contract; 
