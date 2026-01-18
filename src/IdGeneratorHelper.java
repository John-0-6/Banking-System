import java.time.LocalDate;

public class IdGeneratorHelper {

  private static int accountCounter = 0; // will be updated from file

  public IdGeneratorHelper() {
  }

  public static void setCounter(int lastCounter) {
    accountCounter = lastCounter;
  }

  public String id() {
    accountCounter++;

    LocalDate now = LocalDate.now();
    int year = now.getYear();
    int month = now.getMonthValue();

    return year + "-" + String.format("%02d", month) + "-" + accountCounter;
  }
}
