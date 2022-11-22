package com.tribc.ddd.repository;

import java.util.List;

/**
 * Holds entities of type T.
 *
 * @param <T>  Entity type.
 * @param <ID> Entity identifier type.
 */
public interface Repository<T, ID> {

    /**
     * Adds new entity
     *
     * @param t Entity.
     */
    void add(T t);

    /**
     * Updates existing entity.
     *
     * @param t Entity.
     */
    void update(T t);

    /**
     * Removes existing entity.
     *
     * @param t Entity.
     */
    void remove(T t);

    /**
     * Returns entity with given identifier.
     *
     * @param identifier Identifier.
     * @return Entity.
     */
    T forOne(ID identifier);

    /**
     * Returns all entities in the repository.
     *
     * @return Entities. May be empty.
     */
    List<T> forAll();

    /**
     * Inquires whether this repository holds an entity with given identifier.
     *
     * @param identifier Identifier.
     * @return Result.
     */
    boolean contains(ID identifier);

}
