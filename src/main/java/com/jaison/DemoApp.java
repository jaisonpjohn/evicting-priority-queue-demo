package com.jaison;

import org.apache.lucene.util.PriorityQueue;

class EvictingPriorityQueue extends PriorityQueue{

  public EvictingPriorityQueue(final int maxSize) {
    super(maxSize);
  }

  @Override
  protected boolean lessThan(final Object a, final Object b) {
    return (Integer)a>(Integer)b;
  }
}

public class DemoApp {

  public static void main(final String[] args) {

    PriorityQueue priorityQueue = new EvictingPriorityQueue(10);
    priorityQueue.insertWithOverflow(10);
    priorityQueue.insertWithOverflow(4);
    priorityQueue.insertWithOverflow(5);

    priorityQueue.insertWithOverflow(1);
    priorityQueue.insertWithOverflow(3);
    priorityQueue.insertWithOverflow(5);
    priorityQueue.insertWithOverflow(15);
    priorityQueue.insertWithOverflow(55);
    priorityQueue.insertWithOverflow(0);

    // Filling some more numbers
    for(int i=30;i<55;i++){
      priorityQueue.insertWithOverflow(i);
    }
    priorityQueue.insertWithOverflow(1);
    priorityQueue.insertWithOverflow(9);
    priorityQueue.insertWithOverflow(2);
    priorityQueue.insertWithOverflow(8);
    priorityQueue.insertWithOverflow(7);
    priorityQueue.insertWithOverflow(6);

    // Filling some more numbers
    for(int i=45;i<65;i++){
      priorityQueue.insertWithOverflow(i);
    }

    while (priorityQueue.size()>0){
      System.out.println(priorityQueue.pop());
    }

  }
}
