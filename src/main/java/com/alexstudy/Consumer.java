package com.alexstudy;

public class Consumer implements Runnable {
    // 3. Consumers are coupled only to the Mediator
    private Mediator med;
    private int    id;
    private static int num = 1;

    public Consumer(Mediator m) {
      med = m;
      id = num++;
    }

    @Override
    public void run() {
      while (true) {
        System.out.println("c" + id + "-" + med.retrieveMessage() + "  ");
      }
    }
  }