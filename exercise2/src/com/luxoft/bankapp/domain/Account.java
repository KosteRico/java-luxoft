package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.exception.NotEnoughFundsException;

public interface Account {
    void deposit(double amount);
    void withdraw(double amount) throws IllegalArgumentException, NotEnoughFundsException;
    double maximumAmountToWithdraw();

}
