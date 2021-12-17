package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.exception.NotEnoughFundsException;

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
        validateAmount(amount);

        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws IllegalArgumentException, NotEnoughFundsException {
        validateAmount(amount);

        validateEnoughFunds(amount);

        balance -= amount;
    }

    protected abstract void validateEnoughFunds(double amount) throws NotEnoughFundsException;

    protected void validateAmount(double amount) {
        if (amount < 0) throw new IllegalArgumentException();
    }
}
