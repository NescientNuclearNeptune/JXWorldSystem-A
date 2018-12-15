/*
   NOTICE: This file will DEFINITELY be moved later on to another file.
*/

package com.jhnuxer.gametest0;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import com.jhnuxer.math.*;
import com.jhnuxer.util.*;

public class IarmMapPanel_A extends JPanel implements KeyEventDispatcher,MouseMotionListener {
  Iarm iarm;
  IarmDrawScript[] scripts;
  int drawMode = 0;
  int offsx = 0;
  int offsy = 0;
  Point lp = new Point(0,0);

  public IarmMapPanel_A(Iarm a,int ww,int hh) {
    this.iarm = a;
    Dimension d = new Dimension(ww,hh);
    setMinimumSize(d);
    setMaximumSize(d);
    setPreferredSize(d);
    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);

    ArrayList<IarmDrawScript> ds = new ArrayList<IarmDrawScript>();
    File dir = new File("data/drawscripts".replace("/",File.separator));
    for (File file : dir.listFiles()) {
      if (file.isFile() && file.getName().endsWith(".js")) {
        ds.add(new IarmDrawScript(file,file.getName().endsWith(".p.js")));
      }
    }
    this.scripts = ds.toArray(new IarmDrawScript[0]);
    addMouseMotionListener(this);
  }

  @Override
  protected void paintComponent(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(0,0,getWidth(),getHeight());

    if (drawMode == 0) {  // Elevation
      for (int y = 0; y < getHeight(); y++) {
        for (int x = 0; x < getWidth(); x++) {
          float f = ((float) iarm.get("elev",x,y) / 3000f);
          if (f > 1F) f = 1F;
          if (f < 0F) f = 0F;
          g.setColor(new Color(f,f,f));
          g.drawRect(x,y,1,1);
        }
      }
    } else {
      System.out.println("Running Script...");
      scripts[drawMode-1].run(iarm,g);
    }
  }

  @Override
  public boolean dispatchKeyEvent(KeyEvent e) {
    if (e.getID() == KeyEvent.KEY_RELEASED) {
      if (e.getKeyCode() == KeyEvent.VK_1) {
        drawMode = 0;
      } else if (e.getKeyCode() == KeyEvent.VK_2) {
        drawMode = 1;
      } else if (e.getKeyCode() == KeyEvent.VK_3) {
        drawMode = 2;
      } else if (e.getKeyCode() == KeyEvent.VK_4) {
        drawMode = 3;
      }
      updateUI();
    }
    return false;
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    lp = e.getPoint();
  }
  @Override
  public void mouseDragged(MouseEvent e) {
    Point p = e.getPoint();
    offsx += p.x-lp.x;
    offsy += p.y-lp.y;
    updateUI();
    lp = p;
  }
}
