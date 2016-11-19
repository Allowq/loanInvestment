package org.hackrussia.repositories;

import org.hackrussia.model.Proposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropositionRepository implements CrudRepository<Proposition, String> {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Proposition save(Proposition entity) {
        mongoOperations.save(entity);
        return entity;
    }

    @Override
    public Proposition findOne(String primaryKey) {
        return mongoOperations.findById(primaryKey, Proposition.class);
    }

    @Override
    public List<Proposition> findAll() {
        return mongoOperations.findAll(Proposition.class);
    }

    @Override
    public Long count() {
        return mongoOperations.count(Query.query(null), Proposition.class);
    }

    @Override
    public void delete(Proposition entity) {
        mongoOperations.remove(entity);
    }

    @Override
    public boolean exists(String primaryKey) {
        return mongoOperations.exists(Query.query(null), primaryKey);
    }

    public List<Proposition> findByCriteria(Query query) {
        return mongoOperations.find(query, Proposition.class);
    }

    public boolean existByCriteria(Query query) {
        return mongoOperations.exists(query, Proposition.class);
    }

}
