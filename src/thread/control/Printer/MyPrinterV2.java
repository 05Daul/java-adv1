package thread.control.Printer;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyPrinterV2 {

  public static void main(String[] args) {

    Printer printer = new Printer();
    Thread printerThread = new Thread(printer, "Printer");
    printerThread.start();

    Scanner scanner = new Scanner(System.in);

    while (true) {
      log("프론터 할 문서룰 입력하세요. 종료(q): ");
      String input = scanner.nextLine();
      if (input.equals("q")) {
        printer.work = false;
        printerThread.interrupt();
        break;
      }
      printer.addJob(input);
    }
  }

  static class Printer implements Runnable {

    volatile boolean work = true;

    /// 여러스레드가 동시에 접근하거나 동시에 자료구조에 접근하면 특별한 방법이 필요로 한다.
    Queue<String> jobqueue = new ConcurrentLinkedQueue<>();

    @Override
    public void run() {
      while (work) {
        if (jobqueue.isEmpty()) {
          continue;
        }
        try {
          String job = jobqueue.poll();
          log("출력 시작 : " + job + ", 대기문서 " + jobqueue);
          Thread.sleep(3000);
          log("출력 완료");

        } catch (InterruptedException e) {
          log("언터럽트!");
          break;
        }
      }
      log("프린터 종료")
      ;
    }

    public void addJob(String job) {
      jobqueue.offer(job);
    }
  }

}
