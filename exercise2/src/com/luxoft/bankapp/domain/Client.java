package com.luxoft.bankapp.domain;

import java.util.LinkedList;
import java.util.List;

public class Client {
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
        return accounts;
    }

    public String getName() {
        return name;
    }
}
