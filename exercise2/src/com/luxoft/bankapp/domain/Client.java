package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.service.Indexed;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Client implements Indexed {
    private final UUID id = UUID.randomUUID();

    private final String name;

    private final List<Account> accounts = new LinkedList<>();

    private final Gender gender;

    public Client(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getClientGreeting() {
        switch (gender) {
            case MALE:
                return "Mr. " + name;
            case FEMALE:
                return "Mrs. " + name;
        }

        throw new UnsupportedOperationException();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    public String getName() {
        return name;
    }

    @Override
    public UUID getId() {
        return id;
    }
}
