package org.hackrussia.repositories;

import org.hackrussia.model.SmartContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class SmartContractRepository implements CrudRepository<SmartContract, String> {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public SmartContract save(SmartContract entity) {
        mongoOperations.save(entity);
        return entity;
    }

    @Override
    public SmartContract findOne(String primaryKey) {
        return mongoOperations.findById(primaryKey, SmartContract.class);
    }

    @Override
    public Iterable<SmartContract> findAll() {
        return mongoOperations.findAll(SmartContract.class);
    }

    @Override
    public Long count() {
        return mongoOperations.count(Query.query(null), SmartContract.class);
    }

    @Override
    public void delete(SmartContract entity) {
        mongoOperations.remove(entity);
    }

    @Override
    public boolean exists(String primaryKey) {
        return mongoOperations.exists(Query.query(null), primaryKey);
    }
}
