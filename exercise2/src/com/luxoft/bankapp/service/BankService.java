package com.luxoft.bankapp.service;

import com.luxoft.bankapp.domain.Bank;
import com.luxoft.bankapp.domain.Client;

public class BankService {
    private BankService() {
    }

    public static void addClient(Bank bank, Client client) {
        bank.addClient(client);
    }

}
