package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {

  /**
   * TODO: Fix the test. Employ join()
   */
  @Test
  public void testThread() throws InterruptedException {

    MyRunnable myRunnable = new MyRunnable();

    //
    Thread thread1 = createThread(myRunnable);
    Thread thread2 = createThread(myRunnable);
    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();

    assertEquals(2, myRunnable.counter);
  }

  Thread createThread(MyRunnable myRunnable) {
    return new Thread(myRunnable);
  }

  static class MyRunnable implements Runnable {

    int counter = 0;

    @Override
    public void run() {
      counter++;
    }
  }
}
