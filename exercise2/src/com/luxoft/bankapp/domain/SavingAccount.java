package com.luxoft.bankapp.domain;

import java.util.UUID;

public class SavingAccount implements Account {

    private final UUID id = UUID.randomUUID();
    protected double balance;

    public SavingAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double amount) {
        this.balance = amount;
    }

    @Override
    public double maximumAmountToWithdraw() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("Saving account (id=%s, deposit=%s)", getId(), getBalance());
    }

}
