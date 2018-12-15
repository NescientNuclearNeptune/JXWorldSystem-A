package com.jhnuxer.gametest0;

import java.util.*;
import javax.script.*;
import javax.swing.*;

public class Main {
  public static final Random RAND = new Random();
  public static final ScriptEngine JS = new ScriptEngineManager().getEngineByName("js");

  public static void main(String[] args) {
    Iarm2 iarm2 = new Iarm2(800,600,
      "trand(5,3000);tsmooth(80);hgen();script(heatsmoothe.js);"
    );
    IarmMapPanel_A iarr = new IarmMapPanel_A(iarm2,800,600);
    JFrame frame = new JFrame();
    frame.add(iarr);
    frame.pack();
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("WGT 0 v0.2.0a");
    frame.setVisible(true);
  }
}
