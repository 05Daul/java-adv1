package thread.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class MyLogger {

  /// 시간을 사용하니까 formatter 사용하기
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
      "yy-MM-dd HH:mm:ss.SSS");

  public static void log(Object o) {

    String time = LocalDateTime.now().format(formatter);
    //string 타입으로 LocalDateTime.now() 에 formatter 타입으로
    System.out.printf("%s [%6s] %s\n", time, Thread.currentThread().getName(), o);
  }
}
