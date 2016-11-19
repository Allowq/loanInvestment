import React from 'react';
import ReactDOM from 'react-dom';
import { ButtonInput } from 'react-bootstrap';
import { Router, Route, Link, browserHistory } from 'react-router';

class Login extends React.Component {
    render() {
        var style = {
            marginTop: '120px',
            minWidth: "200px",
            maxWidth: "400px"
        };
        var nowrap = {
            whiteSpace: 'nowrap'
        };
        var wrapperStyle = {
            backgroundColor: '#dddddd',
            padding: '20px'
        };

        return (
            <div className="container" style={style}> 
                <div className="wrapper" style={wrapperStyle}>
                <h2 style={nowrap}>Loan investments</h2> 
                <form className="form-signin">     
                <ul className="nav nav-tabs">
                    <li><Link to="/auth/auth">Login</Link></li>
                    <li><Link to="/auth/register">Register</Link></li>
                </ul>
                <br />
                <div>
                    {this.props.children}
                </div>
                </form>
            </div>
            </div>
            );
    }
}

export default Login;