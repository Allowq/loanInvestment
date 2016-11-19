import React from 'react';
import ReactDOM from 'react-dom';

class Profile extends React.Component {
    render () {
        return (
            <div> 
                <h2>Profile</h2>
                <div className="jumbotron"> 
                    <div className="container">
                        <label>Login</label>
                        <input className="form-control" type="text" />
                        <br />
                        <label>Password</label>
                        <input className="form-control" type="password" />
                        <br />
                        <label>UID</label>
                        <input className="form-control" type="text" />
                        <br />
                        <label>Bitcoin GUID</label>
                        <input className="form-control" type="text" />
                        <br />
                        <label>Digital signature</label>
                        <input className="form-control" type="text" />
                        <br />
                    </div>

                    <div className="row">
                        <div className="col-md-2 col-md-push-9">
                            <button className="btn btn-primary">Save settings</button>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Profile;