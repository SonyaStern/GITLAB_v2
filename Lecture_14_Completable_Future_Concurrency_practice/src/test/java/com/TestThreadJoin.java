package com;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class TestThreadJoin {

  /**
   * Fill in the gaps and insert instructions to make code executable
   */
  @Test
  public void testThread() throws InterruptedException {
    Object lock = new Object();
    Thread thread1 = createThread(() -> {
      synchronized (lock) {
        try {
          // TODO: design wait right way
          lock.wait(1000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          e.printStackTrace();
        }
      }
    });
    Thread thread2 = createThread(() -> {
      synchronized (lock) {
        try {
          // TODO: design wait right way
          lock.wait(2000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          e.printStackTrace();
        }
      }
    });

    thread1.start();
    thread2.start();

    sleep(100);

    // TODO: make TIMED_WAITING
    // TODO: make TIMED_WAITING

    assertEquals(thread1.getState(), Thread.State.TIMED_WAITING);
    assertEquals(thread2.getState(), Thread.State.TIMED_WAITING);

    // TODO: Wait till both threads are completed or terminated



    // threads should run task to be put on hold
    assertEquals(thread1.getState(), Thread.State.TERMINATED);
    assertEquals(thread2.getState(), Thread.State.TERMINATED);

    // TODO: fill in action with Thread to exit loop
    while (!Thread.currentThread().isInterrupted()) {
    }

    assertTrue(Thread.currentThread().isInterrupted());
    assertEquals(Thread.currentThread().getState(), Thread.State.RUNNABLE);
  }

  private Thread createThread() {
    final Thread thread = new Thread();
    return thread;
  }

  private Thread createThread(Runnable runnable) {
    final Thread thread = new Thread(runnable);
    return thread;
  }

}