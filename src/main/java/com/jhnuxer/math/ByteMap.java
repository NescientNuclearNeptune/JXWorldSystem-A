package com.jhnuxer.math;

public class ByteMap {
  byte[][] bytes;
  int w,h;

  public ByteMap(int w,int h) {
    this.bytes = new byte[w][h];
    this.w = w;
    this.h = h;
  }

  private int x(int xx) {
    int x = xx;
    while (x >= w) x -= w;
    while (x < 0) x += w;
    return x;
  }
  private int y(int yy) {
    int y = yy;
    while (y >= h) y -= h;
    while (y < 0) y += h;
    return y;
  }

  public byte get(int x,int y) {
    return bytes[x][y];
  }
  public void set(int x,int y,byte b) { bytes[x][y] = b; }
  public void set(int x,int y,int b) { set(x,y,(byte) 0xFF&b); }

  public byte getAvg(int x,int y) { return getAvg(x,y,1); }
  public byte getAvg(int x,int y,int r) {
    int v = 0;
    int n = 0;
    for (int i = 0; i < r; i++) {
      if (i == 0) {
        v += get(x,y);
        n++;
      } else {
        int xp = x(x+i);
        int yp = y(y+i);
        int xm = x(x-i);
        int ym = y(y-i);
        int xc = x(x);
        int yc = y(y);
        v += get(xm,ym) + get(xc,ym) + get(xp,ym)
           + get(xm,yc) + get(xc,yc) + get(xp,yc)
           + get(xm,yp) + get(xc,yp) + get(xp,yp);
        n += 8;
      }
    }

    return (byte) Math.round((double) v / (double) n);
  }

  private void smoothePass(int r) {
    ByteMap bm = new ByteMap(w,h);
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) bm.set(x,y,getAvg(x,y,r));
    }
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) set(x,y,bm.get(x,y));
    }
  }
  public void smoothe(int passes,int r) {
    for (int i = 0; i < passes; i++) smoothePass(r);
  }
}
