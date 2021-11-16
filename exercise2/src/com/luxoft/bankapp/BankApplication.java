package com.luxoft.bankapp;

import com.luxoft.bankapp.domain.*;

public class BankApplication {

    public static void main(String[] args) {
        Bank bank = new Bank();

        Client jack = new Client("Jack", Gender.MALE);
        Client josh = new Client("Josh", Gender.MALE);

        jack.addAccount(new SavingAccount(100));
        josh.addAccount(new SavingAccount(2999));

        bank.addClient(jack);
        bank.addClient(josh);

        System.out.println("Before modification:");
        printBalance(bank);

        modifyBank(bank);

        System.out.println("After modification:");
        printBalance(bank);
    }

    // add 100 for every client account
    private static void modifyBank(Bank bank) {
        bank.getClients()
                .stream()
                .flatMap(client -> client
                        .getAccounts()
                        .stream()
                ).forEach(account -> account.deposit(100));
    }

    private static void printBalance(Bank bank) {
        bank.getClients()
                .stream()
                .peek(client -> System.out.printf("Client (name=%s):\n", client.getName()))
                .flatMap(client -> client
                        .getAccounts()
                        .stream()
                ).forEach(account -> System.out.printf("\t%s\n\n", account));
    }

}
