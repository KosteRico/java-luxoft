package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.service.ClientStorageService;
import com.luxoft.bankapp.service.StorageService;

import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.List;

public class Bank {

    private final List<ClientRegistrationListener> listeners = List.of(
            new PrintClientListener(),
            new EmailNotificationListener(),
            new DebugListener()
    );

    private final StorageService<Client> clientStorageService = new ClientStorageService();

    private final List<Client> printedClients = new LinkedList<>();
    private final List<Client> emailedClients = new LinkedList<>();
    private final List<Client> debuggedClients = new LinkedList<>();

    public void addClient(Client client) {
        clientStorageService.store(client);

        listeners.forEach(listener -> listener.onClientAdded(client));
    }

    public List<Client> getClients() {
        return clientStorageService.getAll();
    }

    private class PrintClientListener implements ClientRegistrationListener {
        @Override
        public void onClientAdded(Client c) {
            System.out.println(c);
            printedClients.add(c);
        }
    }

    private class EmailNotificationListener implements ClientRegistrationListener {
        @Override
        public void onClientAdded(Client c) {
            System.out.println("Notification email for client" + c + " is sent");
            emailedClients.add(c);
        }
    }

    private class DebugListener implements ClientRegistrationListener {
        @Override
        public void onClientAdded(Client c) {
            System.out.println(OffsetDateTime.now() + " " + c);
            debuggedClients.add(c);
        }
    }

    public List<Client> getPrintedClients() {
        return printedClients;
    }

    public List<Client> getEmailedClients() {
        return emailedClients;
    }

    public List<Client> getDebuggedClients() {
        return debuggedClients;
    }
}
