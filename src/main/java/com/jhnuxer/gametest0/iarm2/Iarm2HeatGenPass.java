package com.jhnuxer.gametest0.iarm2;

import java.util.*;

import com.jhnuxer.math.*;
import com.jhnuxer.gametest0.*;

public class Iarm2HeatGenPass extends AIarm2GenPass {
  private int x,y;

  public Iarm2HeatGenPass(Iarm2 iarm2) {
    super("Generating Heat Gradient",iarm2.w*iarm2.h,iarm2);
  }

  public void run() {
    for (y = 0; y < iarm2.h; y++) {
      for (x = 0; x < iarm2.w; x++) {
        iarm2.temp.set(x,y,iarm2.elev.get(x,y) + (char) Main.RAND.nextInt(121));
      }
    }
  }

  public int getCompleted() {
    return (y * iarm2.w) + x;
  }
}
