import React from 'react';
import ReactDOM from 'react-dom';
import GetFetchParams from './../http';

class RegisterForm extends React.Component {
    constructor (props) {
        super(props);
        this.login = '';
        this.password = '';
        this.guid = '';
        this.digitalSignature = '';
    }
    
    loginChanged(event) {
        this.login =  event.target.value;
    }
    
    passwordChanged(event) {
        this.password =  event.target.value;
    }
    
    guidChanged(event) {
        this.guid =  event.target.value;
    }
    
    signChanged(event) {
        this.digitalSignature =  event.target.value;
    }
    
    register() {
        var data = {
            login: this.login,
            password: this.password,
            bguid: this.guid,
            dsignature: this.digitalSignature
        };
        
        fetch('/register',  GetFetchParams(data))
            .then(response => response.json())
            .then((responseJSON) => {
                alert(responseJSON.status);
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
                <label>Bitcoin GUID</label>
                <input className="form-control" type="text" onKeyUp={this.guidChanged.bind(this)} />
                <br />
                <label>Digital signature</label>
                <input className="form-control" type="text" onKeyUp={this.signChanged.bind(this)} />
                <br />
                <a className="btn btn-primary btn-block" onClick={this.register.bind(this)}>Register</a>
            </div>
        );
    }
}

export default RegisterForm;