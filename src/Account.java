public class Account {

  private final String accountNumber;
  private final String username;
  private final String password;
  private final String fullName;
  private double balance;
  private final String accountType;
  private boolean isActive;

  public Account(String accountNumber, String username, String password,
                 String fullName, String accountType) {
    this.accountNumber = accountNumber;
    this.username = username;
    this.password = password;
    this.fullName = fullName;
    this.accountType = accountType;
    this.balance = 0.0;
    this.isActive = true;
  }

  public String getAccountNumber(){
    return accountNumber;
  }

  public String getUsername(){
    return username;
  }

  public String getPassword(){
    return password;
  }

  public String getFullName(){
    return fullName;
  }

  public double getBalance(){
    return balance;
  }

  public String getAccountType(){
    return accountType;
  }

  public boolean isActive(){
    return isActive;
  }

  public void setBalance(double amount){
    this.balance = amount;
  }

  public void setActive(boolean active){
    this.isActive = active;
  }

  @Override
  public String toString(){
    if(isActive){
      return accountNumber + ": " + fullName + " | " + accountType + " | " + balance + " | Active";
    }
    else{
      return accountNumber + ": " + fullName + " | " + accountType + " | " + balance + " | Inactive";
    }
  }
}
