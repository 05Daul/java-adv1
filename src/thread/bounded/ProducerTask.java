package thread.bounded;

import static thread.util.MyLogger.log;

public class ProducerTask implements Runnable {
  private BoundedQueue queue;
  private String request;


  @Override
  public void run() {
    log("[생산 시도] "+request+" -> "+queue);
    queue.put(request);
    log("[생산 완료] "+request+" -> "+queue);
  }

  public ProducerTask(BoundedQueue queue, String request) {
    this.queue = queue;
    this.request = request;
  }

  public BoundedQueue getQueue() {
    return queue;
  }

  public void setQueue(BoundedQueue queue) {
    this.queue = queue;
  }

  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }
}
