import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, Link, browserHistory } from 'react-router';
import LeftBar from './leftbar';
import Header from './header';
import Session from './../session';

class App extends React.Component {

    render () {
        return (
            <div>
                <div className="row">
                    <div className="col-xs-1"></div>
                    <div className="col-xs-10">
                        <Header />
                    </div>
                </div>
                <div className="row">    
                    <div className="col-xs-2"></div>
                    <div className="col-xs-2">
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