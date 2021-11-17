package com.luxoft.bankapp.domain;

import java.util.UUID;

public class CheckingAccount implements Account {

    private final UUID id = UUID.randomUUID();
    protected double overdraft;
    protected double balance;

    public CheckingAccount(double balance, double overdraft) {
        this.balance = balance;
        this.overdraft = overdraft;
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
        return overdraft + balance;
    }

    @Override
    public String toString() {
        return String.format("Checking account (id=%s, deposit=%s)", getId(), getBalance());
    }
}
