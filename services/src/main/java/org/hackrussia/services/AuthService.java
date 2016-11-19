package org.hackrussia.services;

import org.hackrussia.model.Client;
import org.hackrussia.repositories.ClientRepository;
import org.hackrussia.utils.HttpSessionEmulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private HttpSessionEmulator sessionEmulator;

    public List<Client> authProcessor(String login, String password) {
        return clientRepository.findByCriteria(Query.query(Criteria
                .where("login")
                .is(login)
                .and("password")
                .is(password)));
    }

    public boolean isAuth(UUID uuid, String clientId) {
        return sessionEmulator.exist(uuid) && sessionEmulator.get(uuid).equals(clientId);
    }

    public boolean isAuth(UUID uuid) {
        return sessionEmulator.exist(uuid);
    }
}
