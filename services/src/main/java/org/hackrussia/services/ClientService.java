package org.hackrussia.services;

import org.hackrussia.model.Client;
import org.hackrussia.model.dto.ClientResp;
import org.hackrussia.repositories.ClientRepository;
import org.hackrussia.repositories.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements CrudRepository<Client, String> {
    @Autowired
    private ClientRepository repository;

    @Override
    public Client save(Client entity) {
        return repository.save(entity);
    }

    @Override
    public Client findOne(String primaryKey) {
        return repository.findOne(primaryKey);
    }

    public ClientResp find(String primaryKey) {
        Client client = repository.findOne(primaryKey);
        return new ClientResp(client.getId(), client.getLogin(), client.getESignature(), client.getBGuid(), client.getPropositions());
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public void delete(Client entity) {
        repository.delete(entity);
    }

    @Override
    public boolean exists(String primaryKey) {
        return repository.exists(primaryKey);
    }

    public List<Client> findByCriteria(Query query) {
        return repository.findByCriteria(query);
    }
}
