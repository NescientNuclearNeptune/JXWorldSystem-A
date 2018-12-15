package com.jhnuxer.gametest0.iarm2;

import java.util.*;

import com.jhnuxer.math.*;
import com.jhnuxer.gametest0.*;

public class Iarm2SmootheTerrainPass extends AIarm2GenPass {
  int smootheRadius;
  UShortMap map;

  private int x;
  private int y;

  public Iarm2SmootheTerrainPass(Iarm2 iarm,int sr) {
    super("Smoothing Terrain",iarm.w*iarm.h*4,iarm);
    this.smootheRadius = sr;
    this.map = iarm2.elev;
  }

  public void run() {
    UShortMap usm = new UShortMap(iarm2.w,iarm2.h);
    for (y = 0; y < iarm2.h; y++) {
      for (x = 0; x < iarm2.w; x++) usm.set(x,y,map.getAvg(x,y,smootheRadius));
    }
    for (int k = 0; k < iarm2.h; k++) {
      for (int h = 0; h < iarm2.w; h++) map.set(h,k,usm.get(h,k));
    }
  }
  public int getCompleted() {
    return ((y * iarm2.w) + x) * 4;
  }
}
