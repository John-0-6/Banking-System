import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    System.out.println("""
      ~~~~~~~~~~~~~~
      Banking System
      ~~~~~~~~~~~~~~""");

    Scanner scanner = new Scanner(System.in);
    BankManager bankManager = new BankManager();

    boolean running = true;

//    Main Menu
    while(running){
      System.out.println("\n1. Create Account");
      System.out.println("2. Login");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch(choice){
        case 1:
          createAccount(scanner, bankManager);
          break;

        case 2:
          login(scanner, bankManager);
          break;
      }
    }

    scanner.close();
  }
//  Create Account
  public static void createAccount(Scanner scanner, BankManager bankManager){

    IdGeneratorHelper idGeneratorHelper = new IdGeneratorHelper();
    String accountNumber = idGeneratorHelper.id();
    System.out.print("");

    System.out.print("Enter username: ");
    String username = scanner.nextLine();

    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    System.out.println("Account type");
    System.out.println("1. Checking Account");
    System.out.println("2. Savings Account");
    System.out.println("3. Money Market Account");
    System.out.print("Enter your choice: ");
    int accountTypeChoice = scanner.nextInt();
    scanner.nextLine();

    String accountType = "";
    if(accountTypeChoice == 1){
      accountType = "Checking Account";
    }
    else if(accountTypeChoice == 2){
      accountType = "Savings Account";
    }
    else if(accountTypeChoice == 3){
      accountType = "Money Market Account";
    }

    System.out.print("Enter full name (First name, Middle name, Surname): ");
    String fullName = scanner.nextLine();

    Account account = new Account(accountNumber, username, password, fullName, accountType);
    bankManager.addAccount(account);
  }

//  Login and Account Menu
  public static void login(Scanner scanner, BankManager bankManager){
    System.out.print("\nEnter username: ");
    String usernameLogin = scanner.nextLine();

    System.out.print("Enter password: ");
    String passwordLogin = scanner.nextLine();
    Account loggedIn = bankManager.login(usernameLogin, passwordLogin);

    if(loggedIn != null){
      System.out.println("--- Login successful! Welcome ---");
      bankManager.showAccount(usernameLogin);

//      Checking Account
      if(loggedIn.getAccountType().equals("Checking Account")){
        System.out.println("\n1. Deposit");
        System.out.println("2. Withdraw");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if(choice == 1){
          bankManager.deposit(amount, usernameLogin);
        }
        else if(choice == 2){
          bankManager.withdraw(amount, usernameLogin);
        }
      }
//      Savings Account
      else if(loggedIn.getAccountType().equals("Savings Account")){
        System.out.println("\n1. Deposit");
        System.out.println("2. Withdraw");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if(choice == 1){
          bankManager.deposit(amount, usernameLogin);
        }
        else if(choice == 2){
          bankManager.withdraw(amount, usernameLogin);
        }
      }
//      Money Market Account
      else if(loggedIn.getAccountType().equals("Money Market Account")){
        System.out.println("\n1. Deposit");
        System.out.println("2. Withdraw");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if(choice == 1){
          bankManager.deposit(amount, usernameLogin);
        }
        else if(choice == 2){
          bankManager.withdraw(amount, usernameLogin);
        }
      }
    }
    else {
      System.out.println("--- Login failed. Please check your username and password ---\n");
    }
  }
}
