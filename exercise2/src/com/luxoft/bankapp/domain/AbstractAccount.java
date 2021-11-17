package com.luxoft.bankapp.domain;

import java.util.UUID;

public abstract class AbstractAccount implements Account {
    private final UUID id = UUID.randomUUID();
    protected double balance;

    public AbstractAccount(double balance) {
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Account (id=%s, deposit=%s)", id, balance);
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= maximumAmountToWithdraw()) {
            balance -= amount;
        }
    }
}
