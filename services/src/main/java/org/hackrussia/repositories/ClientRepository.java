package org.hackrussia.repositories;

import org.hackrussia.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientRepository implements CrudRepository<Client, String> {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Client save(Client entity) {
        mongoOperations.save(entity);
        return entity;
    }

    @Override
    public Client findOne(String primaryKey) {
        return mongoOperations.findById(primaryKey, Client.class);
    }

    @Override
    public Iterable<Client> findAll() {
        return mongoOperations.findAll(Client.class);
    }

    @Override
    public Long count() {
        return mongoOperations.count(Query.query(null), Client.class);
    }

    @Override
    public void delete(Client entity) {
        mongoOperations.remove(entity);
    }

    @Override
    public boolean exists(String primaryKey) {
        return mongoOperations.exists(Query.query(null), primaryKey);
    }

    public List<Client> findByCriteria(Query query) {
        return mongoOperations.find(query, Client.class);
    }

    public boolean existByCriteria(Query query) {
        return mongoOperations.exists(query, Client.class);
    }

}
