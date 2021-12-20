package com.example.commandeservice.service;

import java.util.List;
import java.util.Optional;

public interface AbstractService<T, I> {

    T save(T t);

    Optional<T> findById(I id);
    boolean existsById(I id);

    List<T> findAll();

    void delete(I id);

}
