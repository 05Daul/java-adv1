package thread.control;

import static thread.util.MyLogger.log;

import thread.start.HelloThread;

public class ThreadInfoMain {

  public static void main(String[] args) {

    /// Main 스레드 정보 출력
    Thread thread = Thread.currentThread();
    log("main thread: " + thread.getName());
    log("main thread.threadId: " + thread.getId());
    log("main thread.Priority: " + thread.getPriority());
    // 우선 순위의 기본값은 5.
    // 추가적으로 1~10까지 설정이 가능하면 변경이 가능하다.
    // 높을 수록 우선순위 값을 가진다.
    log("main thread.state: " + thread.getState()); /// 상태
    log("main thread.Group: "+thread.getThreadGroup()); /// 스레드 그룹

    /// MyThread 스레드 정보 출력
    Thread mythread = new Thread(new HelloThread(),"MyThread");
    log("MyThread: " + mythread.getName());
    log("MyThread.threadId: " + mythread.getId());
    log("MyThread.Priority: " + mythread.getPriority());
    log("MyThread.state: " + mythread.getState());
    log("MyThread.Group: "+mythread.getThreadGroup());
  }
}
