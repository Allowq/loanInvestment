package org.hackrussia.repositories;

import org.hackrussia.model.Investment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentRepository implements CrudRepository<Investment, String> {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Investment save(Investment entity) {
        mongoOperations.save(entity);
        return entity;
    }

    @Override
    public Investment findOne(String primaryKey) {
        return mongoOperations.findById(primaryKey, Investment.class);
    }

    @Override
    public List<Investment> findAll() {
        return mongoOperations.findAll(Investment.class);
    }

    @Override
    public Long count() {
        return mongoOperations.count(Query.query(null), Investment.class);
    }

    @Override
    public void delete(Investment entity) {
        mongoOperations.remove(entity);
    }

    @Override
    public boolean exists(String primaryKey) {
        return mongoOperations.exists(Query.query(null), primaryKey);
    }
}
