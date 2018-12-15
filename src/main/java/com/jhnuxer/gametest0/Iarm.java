package com.jhnuxer.gametest0;

import java.awt.Dimension;

public interface Iarm {
  public int getIarmWidth();
  public int getIarmHeight();
  public Dimension getIarmSize();
  public int get(String s,int x,int y);
  public void set(String s,int x,int y,int value);
  public int getAvg(String s,int x,int y,int r);
}
