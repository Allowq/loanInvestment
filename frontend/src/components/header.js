import React from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.css';
import {Navbar, Nav, NavItem, NavDropdown, MenuItem} from 'react-bootstrap';
import { Router, Route, Link, browserHistory } from 'react-router';

class Header extends React.Component {

	  _logout() {
        window.uid = '';
        browserHistory.push('/auth');
	  }

    render() {
        let style = {
          fontSize: '30px'
        };

        return (
          <Navbar inverse collapseOnSelect>
            <Navbar.Header>
              <Navbar.Brand>
                <a href="#" style={style}>Loan investment</a>
              </Navbar.Brand>
              <Navbar.Toggle />
            </Navbar.Header>
            <Navbar.Collapse>
              <Nav>
              </Nav>
              <Nav pullRight>
                <NavItem eventKey={1} href="#">User name</NavItem>
                <NavItem eventKey={2} href="#" onClick={this._logout}>Logout</NavItem>
                <NavItem eventKey={3} href="#"></NavItem>
              </Nav>
            </Navbar.Collapse>
          </Navbar>
        )
    }
}

export default Header;