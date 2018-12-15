package com.jhnuxer.graphics;

import java.awt.Graphics;

public interface SpriteComponent {
  public int getSpriteWidth();
  public int getSpriteHeight();
  public void draw(Graphics g);
}
