package org.hackrussia.repositories;

import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {
    T save(T entity);

    T findOne(ID primaryKey);

    List<T> findAll();

    Long count();

    void delete(T entity);

    boolean exists(ID primaryKey);
}