package thread.sync.service;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

import thread.sync.BankCount;

public class BankAccountV1 implements BankCount {

  /// 동시성 문제를 확인해보는 예제

  private int balance;

  public BankAccountV1(int balance) {
    this.balance = balance;
  }

  @Override
  public boolean withdraw(int amount) {
    log("거래시작 : " + getClass().getSimpleName());
    /// 잔고가 출금액보다 적으면 진행하면 안됌.
    log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
    if (balance < amount) {
      log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
      return false;
    }

    /// 잔고가 출금액보다 많으면 진행O.
    log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
    sleep(1000); // 출금액 걸리는 시간
    balance -= amount;
    log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
    log("거래종료");
    return false;
  }

  @Override
  public int getBalance() {
    return balance;
  }
}
