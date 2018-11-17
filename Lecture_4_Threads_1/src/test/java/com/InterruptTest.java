package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import prepare.util.Util;

/**
 * TODO: Fix the test case
 */
public class InterruptTest {

  @Test
  public void testInterrupt() throws InterruptedException {
    final MyThread thread = new MyThread();
    thread.start();
    thread.run();

    thread.interrupt();

    thread.join(1000);

    assertEquals(thread.getState(), Thread.State.TERMINATED);
    // outdated version
//        thread.suspend();
//        thread.resume();
  }

  static class MyThread extends Thread {

    @Override
    public void run() {
      System.out.println("MyThread: " + Thread.currentThread().getName() + " started");

      while (isInterrupted()) {
        Util.threadSleep(1000);
      }

      System.out.println("MyThread: " + Thread.currentThread().getName() + " completed");
    }
  }
}
