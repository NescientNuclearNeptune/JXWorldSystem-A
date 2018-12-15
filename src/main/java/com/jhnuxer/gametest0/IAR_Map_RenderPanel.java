/*
   NOTICE: This class is DEPRECATED
*/

package com.jhnuxer.gametest0;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import com.jhnuxer.math.*;
import com.jhnuxer.util.*;

public class IAR_Map_RenderPanel extends JPanel {
  public static final int RM_HEIGHTMAP = 0;

  IAR_Map iarm;
  int renderMode = 1;

  public IAR_Map_RenderPanel(IAR_Map iarm) {
    this.iarm = iarm;

    Dimension d = new Dimension(iarm.w,iarm.h);
    setMinimumSize(d);
    setPreferredSize(d);
  }

  @Override
  protected void paintComponent(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(0,0,getWidth(),getHeight());
    if (renderMode == RM_HEIGHTMAP) {
      for (int y = 0; y < getHeight(); y++) {
        for (int x = 0; x < getWidth(); x++) {
          // System.out.println("Drawing pixel at ("+x+","+y+")");
          byte b = iarm.lvl.get(x,y);
          float gr = ((float) b)/127f;
          gr = gr < 0f ? 0f : gr;
          gr = gr > 255f ? 255f : gr;
          g.setColor(new Color(0f,gr,0f));
          g.drawRect(x,y,1,1);
        }
      }
    } else if (renderMode == 1) {
      // Humidity Map
      for (int y = 0; y < getHeight(); y++) {
        for (int x = 0; x < getWidth(); x++) {
          byte b = iarm.tmp.get(x,y);
          double gr = ((double) b)/127f;
          gr = gr < 0f ? 0f : gr;
          gr = gr > 255f ? 255f : gr;
          g.setColor(Mathy.interpolate(new Color(128,128,128),new Color(0,128,255),1D-gr));
          g.drawRect(x,y,1,1);
        }
      }
    }
  }
}
