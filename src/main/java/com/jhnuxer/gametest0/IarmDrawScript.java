/*
  NOTICE: This class may later be moved to another package for the sake of keeping things clean. Please
          bear this in mind when referencing this file.
 */

package com.jhnuxer.gametest0;

import java.awt.*;
import java.util.*;
import java.io.*;
import javax.script.*;
import javax.swing.*;

public class IarmDrawScript {
  String script;
  ScriptEngine engine;

  // Iarm iarm;
  boolean isPerPixel = true;

  public IarmDrawScript(File f,boolean ipp) {
    this.isPerPixel = ipp;
    this.engine = Main.JS;//new ScriptEngineManager().getEngineByName("js");
    this.script = "";
    // this.iarm = i;

    try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
      String l = "";
      while ((l = reader.readLine()) != null) {
        if (!script.equals("")) script += "\n";
        script += l;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void run(Iarm iarm,Graphics g) {
    try (FileReader fr = new FileReader(new File("data"+File.separator+"dscore0.js"))) {
      engine.eval(fr);
      engine.put("IARM",iarm);
      engine.put("G",g);
      if (isPerPixel) {
        for (int y = 0; y < iarm.getIarmHeight(); y++) {
          for (int x = 0; x < iarm.getIarmWidth(); x++) {
            engine.put("X",x);
            engine.put("Y",y);
            engine.eval(script);
          }
        }
      } else {
        engine.put("SIZE",iarm.getIarmSize());
        engine.eval(script);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
