package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.exception.NotEnoughFundsException;
import com.luxoft.bankapp.exception.OverdraftLimitExceededException;

public class CheckingAccount extends AbstractAccount {

    protected double overdraft;

    public CheckingAccount(double balance, double overdraft) throws IllegalArgumentException {
        super(balance);

        if (overdraft < 0) throw new IllegalArgumentException();

        this.overdraft = overdraft;
    }

    @Override
    public double maximumAmountToWithdraw() {
        return overdraft + balance;
    }

    @Override
    protected void validateEnoughFunds(double amount) throws NotEnoughFundsException {
        if (amount <= maximumAmountToWithdraw()) throw new OverdraftLimitExceededException();
    }
}
