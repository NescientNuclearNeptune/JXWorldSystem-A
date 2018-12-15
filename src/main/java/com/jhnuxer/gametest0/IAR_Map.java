/*
   NOTICE: This class is currently, though not indefinitely, DEPRECATED. Will
           not work with IarmMapPanel_A without patching in an implementation
           of Iarm.
*/

package com.jhnuxer.gametest0;

import com.jhnuxer.math.*;
import com.jhnuxer.util.*;

public class IAR_Map {
  ByteMap veg,tmp,hum,lvl;
  int w,h;

  private ByteMap bm() { return new ByteMap(w,h); }
  public IAR_Map(int w,int h) {
    this.w = w;
    this.h = h;
    veg = bm();
    tmp = bm();
    hum = bm();
    lvl = bm();

    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        lvl.set(x,y,(byte) Main.RAND.nextInt(180));
      }
    }
    lvl.smoothe(3,30);

    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        tmp.set(x,y,(byte) Math.round(Mathy.interpolate((127-lvl.get(x,y))*0.4D,(double) Main.RAND.nextInt(50)+30,Main.RAND.nextDouble())));
      }
    }
    tmp.smoothe(4,60);

    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        hum.set(
          x,y,(byte) Math.round(
            Mathy.interpolate(
                (double) tmp.get(
                  x,y
                ),(
                  1D - (double) lvl.get(
                    x,y
                  )
                ),
                Main.RAND.nextDouble()
            )
          )
        );
      }
    }
    hum.smoothe(3,50);
  }
}
