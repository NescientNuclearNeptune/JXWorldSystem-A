package com.jhnuxer.gametest0.iarm2;

import com.jhnuxer.gametest0.*;

public abstract class AIarm2GenPass implements Iarm2GeneratorPass {
  String name;
  int weight;
  Thread thread;
  Iarm2 iarm2;

  public AIarm2GenPass(String name,int weight,Iarm2 i) {
    this.iarm2 = i;
    this.name = name;
    this.weight = weight;
    this.thread = new Thread(this);
  }

  public String getName() { return name; }
  public int getWeight() { return weight; }
  public int getRemaining() { return getWeight() - getCompleted(); }
  public void start() {
    thread.start();
  }
  public boolean isDone() { return getCompleted() >= getWeight(); }
}
