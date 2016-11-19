package org.hackrussia.services;

import org.hackrussia.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    ClientRepository clientRepository;

    public boolean authProcessor(String login, String password) {
        return clientRepository.existByCriteria(Query.query(Criteria
                .where("login")
                .is(login)
                .and("password")
                .is(password)));
    }
}
