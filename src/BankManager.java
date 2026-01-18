import java.io.*;
import java.util.ArrayList;

public class BankManager {

  private ArrayList<Account> accounts;
  private final String FILE_NAME = "accounts.txt";

  public BankManager() {
    accounts = new ArrayList<>();
    loadAccountsFromFile(); // load accounts when program starts
  }

  public void addAccount(Account account) {
    accounts.add(account);
    saveAccountsToFile();
  }

  public Account login(String usernameLogin, String passwordLogin) {
    for(Account account : accounts) {
      if(account.getUsername().equals(usernameLogin) && account.getPassword().equals(passwordLogin)) {
        return account;
      }
    }
    return null;
  }

  public void showAccount(String usernameLogin){
    for (Account account : accounts) {
      if (account.getUsername().equals(usernameLogin)) {
        System.out.println(account.getAccountNumber() + ": " + account.getFullName() + " | " + account.getAccountType() + " | " + account.getBalance());
      }
    }
  }

  public void deposit(double amount, String usernameLogin) {
    for (Account account : accounts) {
      if (account.getUsername().equals(usernameLogin)) {
        account.setBalance(account.getBalance() + amount);
        saveAccountsToFile();
      }
    }
  }

  public void withdraw(double amount, String usernameLogin) {
    for (Account account : accounts) {
      if (account.getUsername().equals(usernameLogin)) {
        if (account.getBalance() >= amount) {
          account.setBalance(account.getBalance() - amount);
          saveAccountsToFile();
        } else {
          System.out.println("--- Insufficient balance ---");
        }
      }
    }
  }

//  ------------------- FILE I/O METHODS -------------------

  private void saveAccountsToFile() {
    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
      for (Account account : accounts) {
        writer.println(account.getAccountNumber() + " | " +
          account.getUsername() + " | " +
          account.getPassword() + " | " +
          account.getFullName() + " | " +
          account.getBalance() + " | " +
          account.getAccountType() + " | " +
          account.isActive());
      }
    } catch (IOException e) {
      System.out.println("--- Error saving account ---");
    }
  }

  private void loadAccountsFromFile() {
    int maxCounter = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(" | ");
        if (parts.length == 7) {
          String accountNumber = parts[0]; // e.g., "2026-01-5"
          String username = parts[1];
          String password = parts[2];
          String fullName = parts[3];
          double balance = Double.parseDouble(parts[4]);
          String accountType = parts[5];
          boolean isActive = Boolean.parseBoolean(parts[6]);

          Account acc = new Account(accountNumber, username, password, fullName, accountType);
          acc.setBalance(balance);
          acc.setActive(isActive);
          accounts.add(acc);

          // Extract last number after the last dash
          String[] idParts = accountNumber.split("-");
          int counter = Integer.parseInt(idParts[2]);
          if (counter > maxCounter) {
            maxCounter = counter;
          }
        }
      }

      // Set counter in IdGeneratorHelper
      IdGeneratorHelper.setCounter(maxCounter);

    } catch (FileNotFoundException e) {
      System.out.println("--- Account not found ---");
    } catch (IOException e) {
      System.out.println("--- Error loading account ---");
    }
  }
}