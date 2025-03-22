package Collections;

import java.util.*;

class BankingSystem {
    Map<Integer, Double> accountBalances = new HashMap<>();
    TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    Queue<Integer> withdrawalQueue = new LinkedList<>();

    void createAccount(int accountNumber, double initialBalance) {
        accountBalances.put(accountNumber, initialBalance);
        sortedAccounts.put(initialBalance, accountNumber);
    }

    void deposit(int accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            double newBalance = accountBalances.get(accountNumber) + amount;
            sortedAccounts.remove(accountBalances.get(accountNumber));
            accountBalances.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
        }
    }

    void requestWithdrawal(int accountNumber) {
        if (accountBalances.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }

    void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + accountNumber);
        }
    }

    void displayAccounts() {
        System.out.println("Accounts (by balance): " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount(101, 5000.0);
        bank.createAccount(102, 3000.0);
        bank.createAccount(103, 7000.0);

        bank.deposit(101, 2000.0);
        bank.requestWithdrawal(102);
        bank.requestWithdrawal(103);

        bank.displayAccounts();
        bank.processWithdrawals();
    }
}

