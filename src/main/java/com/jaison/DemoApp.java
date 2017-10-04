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

    PriorityQueue pq = new EvictingPriorityQueue(10);
    pq.insertWithOverflow(10);
    pq.insertWithOverflow(4);
    pq.insertWithOverflow(5);

    pq.insertWithOverflow(1);
    pq.insertWithOverflow(3);
    pq.insertWithOverflow(5);
    pq.insertWithOverflow(15);
    pq.insertWithOverflow(55);
    pq.insertWithOverflow(0);

    // Filling some more numbers
    for(int i=30;i<55;i++){
      pq.insertWithOverflow(i);
    }
    pq.insertWithOverflow(1);
    pq.insertWithOverflow(9);
    pq.insertWithOverflow(2);
    pq.insertWithOverflow(8);
    pq.insertWithOverflow(7);
    pq.insertWithOverflow(6);

    // Filling some more numbers
    for(int i=45;i<65;i++){
      pq.insertWithOverflow(i);
    }

    while (pq.size()>0){
      System.out.println(pq.pop());
    }

  }
}
