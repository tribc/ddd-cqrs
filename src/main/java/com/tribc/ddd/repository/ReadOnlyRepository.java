package com.tribc.ddd.repository;

import java.util.List;

/**
 * Holds entities of type T. One can read from the repository. Updating existing
 * or adding new entities is not possible.
 *
 * @param <T>  Entity type.
 * @param <ID> Entity identifier type.
 */
public interface ReadOnlyRepository<T, ID> {

    /**
     * Queries for entity with given identifier.
     *
     * @param identifier Entity identifier.
     * @return Entity.
     * @throws NullPointerException if nonexistent.
     */
    T getOne(ID identifier);

    /**
     * Returns all entities.
     *
     * @return All entities. May be empty.
     */
    List<T> getAll();

}
