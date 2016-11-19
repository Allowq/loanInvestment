import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/app';
import { Router, Route, Link, browserHistory, DefaultRoute } from 'react-router';
import History from './components/views/history';
import Home from './components/views/home';
import Loans from './components/views/loans';
import Investments from './components/views/investments';
import Contract from './components/views/contract';
import Profile from './components/views/profile';
import Login from './auth/login';
import LoginForm from './auth/loginform';
import RegisterForm from './auth/registerform';
import 'bootstrap/dist/css/bootstrap.css';
import NoMatch from './nomatch';

window.uid = '';

function requireAuth(nextState, replace) {
    if (window.uid == '') {
        replace({
            pathname: '/auth/auth',
            state: { nextPathname: nextState.location.pathname }
        })
    }
}

ReactDOM.render(
	  <Router history={browserHistory}>
        <Route path="/" component={App} onEnter={requireAuth}>
            <Route path="home" component={Home} />
            <Route path="loans" component={Loans} />
            <Route path="investments" component={Investments} />
            <Route path="history" component={History} />
            <Route path="profile" component={Profile} />
            <Route path="contract/:contractId" component={Contract} />
        </Route>
        <Route path="auth" component={Login}>
            <Route path="auth" component={LoginForm} />
            <Route path="register" component={RegisterForm} />
        </Route>
    </Router>,
  document.getElementById('root')
);
