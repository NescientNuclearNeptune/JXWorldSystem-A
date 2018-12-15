package com.jhnuxer.gametest0;

import java.awt.*;
import java.io.*;
import java.util.*;

import com.jhnuxer.gametest0.iarm2.*;
import com.jhnuxer.math.*;
import com.jhnuxer.util.*;

public class Iarm2 implements Iarm {
  public UShortMap elev,
            temp,
            humd,
            vegt;

  public int w;
  public int h;

  private UShortMap um() { return new UShortMap(w,h); }
  public Iarm2(int w,int h) {
    this.w = w;
    this.h = h;
    this.elev = um();
    this.temp = um();
    this.humd = um();
    this.vegt = um();
  }
  public Iarm2(int w,int h,String gen) {
    this(w,h);
    gen(gen);
  }

  private static int pi(String s) { return Integer.parseInt(s); }
  public Iarm2 gen(String genPasss) {
    ArrayList<Iarm2GeneratorPass> passes = new ArrayList<Iarm2GeneratorPass>();
    String genPasses = genPasss.endsWith(";") ? genPasss.substring(0,genPasss.length()-1) : genPasss;
    String[] meths = genPasses.split(";");
    for (String method : meths) {
      String mname = method.split("\\(")[0];
      String[] args;
      if (method.contains("()")) {
        args = new String[0];
      } else {
        args = method.substring(0,method.length()-1).split("\\(")[1].split(",");
      }
      switch (mname) {
        case "trand":
          passes.add(new Iarm2RandomTerrainPass(this,pi(args[0]),pi(args[1])));
          break;
        case "tsmooth":
          passes.add(new Iarm2SmootheTerrainPass(this,pi(args[0])));
          break;
        case "hgen":
          passes.add(new Iarm2HeatGenPass(this));
          break;
        case "script":
          passes.add(new ScriptedIarm2GenPass(this,new File("data/passscripts/"+args[0].replace("/",File.separator))));
          break;
      }
    }

    int index = 0;

    while (index < passes.size()) {
      passes.get(index).start();
      while (!passes.get(index).isDone()) {
        try { Thread.sleep(250); } catch (Exception e) { e.printStackTrace(); System.exit(0); }
      }
      index++;
    }

    return this;
  }

  public int getIarmWidth() { return w; }
  public int getIarmHeight() { return h; }
  public Dimension getIarmSize() { return new Dimension(w,h); }
  public int get(String s,int x,int y) {
    switch (s) {
      case "elevation":
      case "elev":
      case "height":
      case "level":
      case "levl":
        return (int) elev.get(x,y);
        // break;
      case "temperature":
      case "thermal":
      case "temp":
      case "therm":
      case "tmp":
      case "thrm":
        return (int) temp.get(x,y);
        // break;
      case "humidity":
      case "moisture":
      case "humd":
        return (int) humd.get(x,y);
        // break;
      case "vegetation":
      case "plants":
      case "plant-life":
      case "vegt":
      case "plant":
        return (int) vegt.get(x,y);
        // break;
      default:
        return 0;
        // break;
    }
  }
  public int getAvg(String s,int x,int y,int r) {
    switch (s) {
      case "elevation":
      case "elev":
      case "height":
      case "level":
      case "levl":
        return (int) elev.getAvg(x,y,r);
      case "temperature":
      case "thermal":
      case "temp":
      case "therm":
      case "tmp":
      case "thrm":
        return (int) temp.getAvg(x,y,r);
      case "humidity":
      case "moisture":
      case "humd":
        return (int) humd.getAvg(x,y,r);
      case "vegetation":
      case "plants":
      case "plant-life":
      case "vegt":
      case "plant":
        return (int) vegt.getAvg(x,y,r);
      default:
        return 0;
    }
  }
  public void set(String s,int x,int y,int value) {
    switch (s) {
      case "elevation":
      case "elev":
      case "height":
      case "level":
      case "levl":
        elev.set(x,y,(char) (value & 0xFFFF));
        break;
      case "temperature":
      case "thermal":
      case "temp":
      case "therm":
      case "tmp":
      case "thrm":
        temp.set(x,y,(char) (value & 0xFFFF));
        break;
      case "humidity":
      case "moisture":
      case "humd":
        humd.set(x,y,(char) (value & 0xFFFF));
        break;
      case "vegetation":
      case "plants":
      case "plant-life":
      case "vegt":
      case "plant":
        vegt.set(x,y,(char) (value & 0xFFFF));
        break;
    }
  }
}
