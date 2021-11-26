package com.luxoft.bankapp.domain;

import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.List;

public class Bank {

    private final List<ClientRegistrationListener> listeners = List.of(
            new PrintClientListener(),
            new EmailNotificationListener(),
            new DebugListener()
    );

    private final List<Client> printedClients = new LinkedList<>();
    private final List<Client> emailedClients = new LinkedList<>();
    private final List<Client> debuggedClients = new LinkedList<>();

    private final List<Client> clients = new LinkedList<>();

    public void addClient(Client client) {
        clients.add(client);

        listeners.forEach(listener -> listener.onClientAdded(client));
    }

    public List<Client> getClients() {
        return clients;
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
