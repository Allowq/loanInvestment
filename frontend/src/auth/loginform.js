import React from 'react';
import ReactDOM from 'react-dom';
import Global from 'react-global';
import { browserHistory } from 'react-router';

class LoginForm extends React.Component {

    _login() {
        window.uid = 'my uid';
        browserHistory.push('/');
    }

    render() {
        return (
            <div>
                <label>Login</label>
                <input className="form-control" type="text" />
                <br />
                <label>Password</label>
                <input className="form-control" type="password" />
                <br />
                <a className="btn btn-primary btn-block" onClick={this._login}>Login</a>
            </div>
        );
    }
}

export default LoginForm;