package thread.control;

import static thread.util.MyLogger.log;

import thread.start.HelloThread;

public class ThreadInfoMain {

  public static void main(String[] args) {

    /// Main 스레드
    Thread thread = Thread.currentThread();
    log("main thread: " + thread.getName());
    log("main thread.threadId: " + thread.getId());
    log("main thread.Priority: " + thread.getPriority()); /// 우선 순위
    log("main thread.state: " + thread.getState()); /// 상태
    log("main thread.Group: "+thread.getThreadGroup()); /// 스레드 그룹

    /// MyThread 스레드
    Thread mythread = new Thread(new HelloThread(),"MyThread");
    log("main thread: " + mythread.getName());
    log("main thread.threadId: " + mythread.getId());
    log("main thread.Priority: " + mythread.getPriority());
    log("main thread.state: " + mythread.getState());
    log("main thread.Group: "+mythread.getThreadGroup());
  }
}
