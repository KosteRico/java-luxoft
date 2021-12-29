package com.luxoft.bankapp.service;

import java.util.List;
import java.util.UUID;

public interface StorageService<T extends Indexed> {

    T store(T obj);

    T getById(UUID id);

    T update(T toUpdate);

    void delete(T obj);

    List<T> getAll();
}
