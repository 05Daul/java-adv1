package thread.sync;

public class WithDrawTask implements Runnable {

  private BankCount account;
  private int amount;

  public WithDrawTask(BankCount account, int amount) {
    this.account = account;
    this.amount = amount;
  }


  @Override
  public void run() {
    account.withdraw(amount);

  }
}
