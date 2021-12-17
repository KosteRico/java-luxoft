package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.exception.NotEnoughFundsException;

public class SavingAccount extends AbstractAccount {
    public SavingAccount(double balance) {
        super(balance);
    }

    @Override
    public double maximumAmountToWithdraw() {
        return balance;
    }


    @Override
    protected void validateEnoughFunds(double amount) throws NotEnoughFundsException {
        if (amount <= maximumAmountToWithdraw()) throw new NotEnoughFundsException();
    }
}
