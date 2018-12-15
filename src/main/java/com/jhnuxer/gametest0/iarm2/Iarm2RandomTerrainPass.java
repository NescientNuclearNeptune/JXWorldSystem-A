package com.jhnuxer.gametest0.iarm2;

import java.util.*;

import com.jhnuxer.math.*;
import com.jhnuxer.gametest0.*;

public class Iarm2RandomTerrainPass extends AIarm2GenPass {
  int min,max;

  private int x,y;

  public Iarm2RandomTerrainPass(Iarm2 iarm2,int min,int max) {
    super("Randomizing Terrain",iarm2.w*iarm2.h,iarm2);
    this.max = max;
    this.min = min;
  }

  private char ri16() {
    return (char) (Main.RAND.nextInt(max-min) + min);
  }

  public void run() {
    for (y = 0; y < iarm2.h; y++) {
      for (x = 0; x < iarm2.w; x++) {
        iarm2.elev.set(x,y,ri16());
      }
    }
  }
  public int getCompleted() { return (y * iarm2.w) + x; }
}
