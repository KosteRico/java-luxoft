package com.luxoft.bankapp.domain;

public class CheckingAccount extends Account{
    public CheckingAccount(double balance) {
        super(balance);
    }

    @Override
    public double maximumAmountToWithdraw() {
        return 0;
    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public void deposit(double amount) {

    }
}
