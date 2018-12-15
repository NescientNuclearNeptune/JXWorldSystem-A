package com.jhnuxer.gametest0.iarm2;

public interface Iarm2GeneratorPass extends Runnable {
  public String getName();
  public int getWeight();
  public int getCompleted();
  public void start();
  public default int getRemaining() { return getWeight() - getCompleted(); }
  public default boolean isDone() { return getCompleted() >= getWeight(); }
}
