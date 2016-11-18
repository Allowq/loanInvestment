import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, Link, browserHistory } from 'react-router';
import LeftBar from './leftbar';

class App extends React.Component {
    render () {
        return (
            <div>
                <div className="row">    
                    <div className="col-xs-4">
                        <LeftBar />
                    </div>    
                    <div className="col-xs-6">
                        {this.props.children}
                    </div>
                </div>
            </div>
        );
    }
}

export default App;