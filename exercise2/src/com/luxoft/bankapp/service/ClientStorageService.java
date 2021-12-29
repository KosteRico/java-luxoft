package com.luxoft.bankapp.service;

import com.luxoft.bankapp.domain.Client;

import java.util.*;

public class ClientStorageService implements StorageService<Client> {
    private final List<Client> clients = new ArrayList<>();

    @Override
    public Client store(Client obj) {
        clients.add(obj);
        return obj;
    }

    @Override
    public Client getById(UUID id) {
        return clients.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Client update(Client toUpdate) {
        ListIterator<Client> iterator = clients.listIterator();

        while (iterator.hasNext()) {
            int i = iterator.nextIndex();
            Client next = iterator.next();

            if (next.getId().equals(toUpdate.getId())) {
                clients.set(i, toUpdate);
                return toUpdate;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public void delete(Client obj) {
        Iterator<Client> iterator = clients.iterator();

        while (iterator.hasNext()) {
            Client next = iterator.next();

            if (next.getId().equals(obj.getId())) {
                iterator.remove();
                return;
            }
        }
    }

    @Override
    public List<Client> getAll() {
        return Collections.unmodifiableList(clients);
    }
}
