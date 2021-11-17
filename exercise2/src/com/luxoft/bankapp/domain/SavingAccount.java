package com.luxoft.bankapp.domain;

public class SavingAccount extends AbstractAccount {
    public SavingAccount(double balance) {
        super(balance);
    }

    @Override
    public double maximumAmountToWithdraw() {
        return balance;
    }

}
