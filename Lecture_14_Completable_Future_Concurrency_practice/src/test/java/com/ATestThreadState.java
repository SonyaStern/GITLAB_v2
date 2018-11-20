package com;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by Admin on 8/6/2018.
 */
public class ATestThreadState {

  /**
   * Fill in the gaps and insert instructions to make code executable
   */
  @Test
  public void testThreadState() throws InterruptedException {
    // TODO: change instantiation
    Runnable task = () -> {
      for (int i =0; i < 10; i++) {
        System.out.println("task " + i);
        try {
          sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };
    Runnable task1 = () -> {
      for (int i =0; i < 10; i++) {
        System.out.println("task " + i);
        try {
          sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };
    Thread thread1 = createThread(task);
    Thread thread2 = createThread(task1);

    assertEquals(thread1.getState(), Thread.State.NEW);
    assertEquals(thread2.getState(), Thread.State.NEW);

    // TODO: fill the gap
    // TODO: fill the gap
    thread1.start();
    thread2.start();

    assertEquals(thread1.getState(), Thread.State.RUNNABLE);
    assertEquals(thread2.getState(), Thread.State.RUNNABLE);

    // Add delay if necessary
    // TODO: fill the gap

    thread2.join(5000);
    // threads should run task to be put on hold
    assertEquals(thread1.getState(), Thread.State.TIMED_WAITING);
    assertEquals(thread2.getState(), Thread.State.TIMED_WAITING);
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
