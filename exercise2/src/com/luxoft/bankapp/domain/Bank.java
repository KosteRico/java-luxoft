package com.luxoft.bankapp.domain;

import java.util.LinkedList;
import java.util.List;

public class Bank {

    private final List<Client> clients = new LinkedList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }
}
