package com.luxoft.bankapp.domain;

import java.util.UUID;

public abstract class Account {
    private final UUID id = UUID.randomUUID();
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public abstract double maximumAmountToWithdraw();

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

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
}
