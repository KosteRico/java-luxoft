package com.luxoft.bankapp.exception;

import com.luxoft.bankapp.domain.Client;

public class ClientExistsException extends Exception {
    public ClientExistsException(Client c) {
        super(
                String.format("Client with name \"%s\" already exists!!!", c.getName())
        );
    }
}
