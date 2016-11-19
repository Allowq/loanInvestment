import React from 'react';
import ReactDOM from 'react-dom';
import auth from './../auth';

class LoginForm extends React.Component {

    _login() {
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
                <button className="btn btn-primary" onClick={this._login}>Login</button>
            </div>
        );
    }
}

export default LoginForm;