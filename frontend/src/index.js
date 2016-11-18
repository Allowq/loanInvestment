import React from 'react';
import ReactDOM from 'react-dom';
import Header from './components/header';
import App from './components/app';
import { Router, Route, Link, browserHistory } from 'react-router';

import History from './components/views/history';
import Loans from './components/views/loans';
import Investments from './components/views/investments';
import Profile from './components/views/profile';

ReactDOM.render(
  <div>
    <Header />
	<Router history={browserHistory}>
        <Route path="/" component={App}>
            <Route path="loans" component={Loans} />
            <Route path="investments" component={Investments} />
            <Route path="history" component={History} />
            <Route path="profile" component={Profile} />
        </Route>
    </Router>
  </div>,
  document.getElementById('root')
);
