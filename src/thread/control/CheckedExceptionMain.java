package thread.control;

import static thread.util.ThreadUtils.sleep;

import thread.util.ThreadUtils;

public class CheckedExceptionMain {

  public static void main(String[] args) throws Exception {

  }
static class CheckedException implements Runnable {

  @Override
  public void run() {
    sleep(1000);
  }
}
}
