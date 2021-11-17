package com.luxoft.bankapp.domain;

import java.util.UUID;

public interface Account {
    default void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    default void withdraw(double amount) {
        if (amount <= maximumAmountToWithdraw()) {
            setBalance(getBalance() - amount);
        }
    }

    double maximumAmountToWithdraw();
    double getBalance();
    void setBalance(double amount);
    UUID getId();

}
