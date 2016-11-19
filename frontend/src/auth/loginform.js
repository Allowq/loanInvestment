import React from 'react';
import ReactDOM from 'react-dom';
import { browserHistory } from 'react-router';
import GetFetchParams from './../http';

class LoginForm extends React.Component {
    constructor (props) {
        super(props);
        this.login = '';
        this.password = '';
    }
    
    loginChanged(event) {
        this.login =  event.target.value;
    }
    
    passwordChanged(event) {
        this.password =  event.target.value;
    }

    _login() {
        var data = {
            login: this.login,
            password: this.password
        };

        //CreateHttpRequest('/auth', data)
        fetch('/tests/user.json', GetFetchParams(data))
            .then(response => response.json())
            .then((responseJSON) => {
                if (responseJSON.status == 'OK') {
                    window.uid = responseJSON.uuid;
                    browserHistory.push('/home');
                } else {
                    alert("Bad login or password!");
                }
                return responseJSON;
            })
            .catch(error => console.log(error));
    }

    render() {
        return (
            <div>
                <label>Login</label>
                <input className="form-control" type="text" onKeyUp={this.loginChanged.bind(this)} />
                <br />
                <label>Password</label>
                <input className="form-control" type="password" onKeyUp={this.passwordChanged.bind(this)} />
                <br />
                <a className="btn btn-primary btn-block" onClick={this._login.bind(this)}>Login</a>
            </div>
        );
    }
}

export default LoginForm;