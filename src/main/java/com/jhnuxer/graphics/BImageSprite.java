package com.jhnuxer.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.jhnuxer.math.*;
import com.jhnuxer.util.*;

public class BImageSprite extends BufferedImage implements SpriteComponent {
  public BImageSprite(int w,int h) {
    super(w,h,BufferedImage.TYPE_INT_ARGB);
  }

  public int getSpriteWidth() { return getWidth(); }
  public int getSpriteHeight() { return getHeight(); }
  public void draw(Graphics g) {
    g.drawImage(this,0,0,null);
  }
}
