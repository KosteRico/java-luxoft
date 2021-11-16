package com.luxoft.bankapp.domain;

public class SavingAccount extends Account {
    public SavingAccount(double balance) {
        super(balance);
    }

    @Override
    public double maximumAmountToWithdraw() {
        return 0;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }
}
