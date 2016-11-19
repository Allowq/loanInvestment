import React from 'react';
import ReactDOM from 'react-dom';

class RegisterForm extends React.Component {
    render() {
        return (
            <div>
                <label>Login</label>
                <input className="form-control" type="text" />
                <br />
                <label>Password</label>
                <input className="form-control" type="password" />
                <br />
                <label>Bitcoin GUID</label>
                <input className="form-control" type="text" />
                <br />
                <label>Digital signature</label>
                <input className="form-control" type="text" />
                <br />
                <button className="btn btn-primary">Register</button>
            </div>
        );
    }
}

export default RegisterForm;