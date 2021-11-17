package com.luxoft.bankapp.domain;

public class CheckingAccount extends AbstractAccount {

    protected double overdraft;

    public CheckingAccount(double balance, double overdraft) {
        super(balance);
        this.overdraft = overdraft;
    }

    @Override
    public double maximumAmountToWithdraw() {
        return overdraft + balance;
    }

}
