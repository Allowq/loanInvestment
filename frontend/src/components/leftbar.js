import React from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.css';
import { Router, Route, Link, browserHistory } from 'react-router';

class LeftBar extends React.Component {
    render () {
        return (
            <ul className="nav nav-pills nav-stacked">
                <li><Link to="loans">Loans</Link></li>
                <li><Link to="investments">Invetment</Link></li>
                <li><Link to="history">History</Link></li>
                <li><Link to="profile">Profile</Link></li>
            </ul>
        );
    }
}

export default LeftBar;