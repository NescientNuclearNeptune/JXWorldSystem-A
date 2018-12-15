package com.jhnuxer.graphics;

import java.awt.*;

import com.jhnuxer.math.*;
import com.jhnuxer.util.*;

public class BitMapSprite implements SpriteComponent {
  int w,h;
  boolean[] grid;
  int drawMode = 0;
  Color[] colors;

  public BitMapSprite(int w,int h,Color[] colors) {
    this.grid = new boolean[w*h];
    this.colors = colors;
  }

  public int getSpriteWidth() { return w; }
  public int getSpriteHeight() { return h; }
  public void draw(Graphics g) {
    if (drawMode == 0) {
      g.setColor(colors[0]);
      double dw = (double) w;
      for (int i = 0; i < w*h; i++) {
        double di = (double) i;
        if (grid[i]) g.fillRect(i%w,(int) Math.round(di-(di%dw)/dw),1,1);
      }
    }
  }
}
