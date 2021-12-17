package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.exception.ClientExistsException;

import java.util.LinkedList;
import java.util.List;

public class Bank {

    private final List<Client> clients = new LinkedList<>();

    public void addClient(Client client) throws ClientExistsException {
        if (clients.stream()
                .anyMatch(c -> c.getName().equals(client.getName()))) {
            throw new ClientExistsException(client);
        }

        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }
}
