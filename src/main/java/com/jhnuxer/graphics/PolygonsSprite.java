package com.jhnuxer.graphics;

import java.awt.*;

import com.jhnuxer.math.*;
import com.jhnuxer.util.*;

public class PolygonsSprite implements SpriteComponent {
  Polygon[] polygons;
  Color color;
  Color bgColor = new Color(0,0,0,0);

  public PolygonsSprite(Polygon[] polygons,Color c) {
    this.polygons = polygons;
    this.color = c;
  }
  public PolygonsSprite(Polygon[] polygons,Color c,Color b) {
    this(polygons,c);
    this.bgColor = b;
  }

  public int getSpriteWidth() {
    int n = 0;
    int m = 0;
    for (int i = 0; i < polygons.length; i++) {
      int[] xx = polygons[i].xpoints;
      n = Math.min(Mathy.min(xx),n);
      m = Math.max(Mathy.max(xx),n);
    }
    return m - n;
  }
  public int getSpriteHeight() {
    int n = 0;
    int m = 0;
    for (int i = 0; i < polygons.length; i++) {
      int[] yy = polygons[i].ypoints;
      n = Math.min(Mathy.min(yy),n);
      m = Math.max(Mathy.max(yy),n);
    }
    return m - n;
  }
  public void draw(Graphics g) {
    g.setColor(bgColor);
    g.setColor(color);
    for (int i = 0; i < polygons.length; i++) {
      Polygon p = polygons[i];
      g.fillPolygon(p.xpoints,p.ypoints,p.npoints);
    }
  }
}
