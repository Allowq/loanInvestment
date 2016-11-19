import React from 'react';
import ReactDOM from 'react-dom';
import Global from 'react-global';
import { browserHistory } from 'react-router';

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
        
        var fetchparams = {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        };

        /*    fetch('/auth/', fetchparams)
                .then(response => response.json())
                .then((responseJSON) => {
                    if (responseJSON.status == 'OK') {
                        window.uid = responseJSON.uuid;
                        browserHistory.push('/');
                    } else {
                        alert("Bad login or password!");
                    }
                    return responseJSON;
                })
                .catch(error => console.log(error));
                */  
                
        window.uid = '123123123123';
        browserHistory.push('/home');
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