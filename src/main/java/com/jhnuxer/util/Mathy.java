package com.jhnuxer.util;

import java.awt.*;

public class Mathy {
  public static int min(int[] arr) {
    int n = arr[0];
    for (int i = 1; i < arr.length; i++) n = Math.min(n,arr[i]);
    return n;
  }
  public static float min(float[] arr) {
    float n = arr[0];
    for (int i = 1; i < arr.length; i++) n = Math.min(n,arr[i]);
    return n;
  }
  public static long min(long[] arr) {
    long n = arr[0];
    for (int i = 1; i < arr.length; i++) n = Math.min(n,arr[i]);
    return n;
  }
  public static short min(short[] arr) {
    short n = arr[0];
    for (int i = 1; i < arr.length; i++) n = (short) Math.min(n,arr[i]);
    return n;
  }
  public static byte min(byte[] arr) {
    byte n = arr[0];
    for (int i = 1; i < arr.length; i++) n = (byte) Math.min(n,arr[i]);
    return n;
  }
  public static double min(double[] arr) {
    double n = arr[0];
    for (int i = 1; i < arr.length; i++) n = Math.min(n,arr[i]);
    return n;
  }

  public static int max(int[] arr) {
    int n = arr[0];
    for (int i = 1; i < arr.length; i++) n = Math.max(n,arr[i]);
    return n;
  }
  public static float max(float[] arr) {
    float n = arr[0];
    for (int i = 1; i < arr.length; i++) n = Math.max(n,arr[i]);
    return n;
  }
  public static long max(long[] arr) {
    long n = arr[0];
    for (int i = 1; i < arr.length; i++) n = Math.max(n,arr[i]);
    return n;
  }
  public static short max(short[] arr) {
    short n = arr[0];
    for (int i = 1; i < arr.length; i++) n = (short) Math.max(n,arr[i]);
    return n;
  }
  public static byte max(byte[] arr) {
    byte n = arr[0];
    for (int i = 1; i < arr.length; i++) n = (byte) Math.max(n,arr[i]);
    return n;
  }
  public static double max(double[] arr) {
    double n = arr[0];
    for (int i = 1; i < arr.length; i++) n = Math.max(n,arr[i]);
    return n;
  }

  public static double interpolate(double a,double b,double r) {
    return a * r + b * (1D-r);
  }
  public static float interpolate(float a,float b,double r) {
    return (float) (a * r + b * (1D-r));
  }
  public static long interpolate(long a,long b,double r) {
    return Math.round(interpolate((double) a,(double) b,r));
  }
  public static int interpolate(int a,int b,double r) {
    return (int) Math.round(interpolate((double) a,(double) b,r));
  }

  public static Color interpolate(Color a,Color b,double r) {
    float[] a_rgba = new float[] {
      ((float) a.getRed()) / 255f,
      ((float) a.getGreen()) / 255f,
      ((float) a.getBlue()) / 255f,
      ((float) a.getAlpha()) / 255f
    };
    float[] b_rgba = new float[] {
      ((float) b.getRed()) / 255f,
      ((float) b.getGreen()) / 255f,
      ((float) b.getBlue()) / 255f,
      ((float) b.getAlpha()) / 255f
    };
    return new Color(
      interpolate(a_rgba[0],b_rgba[0],r),
      interpolate(a_rgba[1],b_rgba[1],r),
      interpolate(a_rgba[2],b_rgba[2],r),
      interpolate(a_rgba[3],b_rgba[3],r)
    );
  }
  public static Color setLightness(Color a,double b) {
    // System.out.println("COLOR: ("+a.getRed()+","+a.getGreen()+","+a.getBlue()+","+a.getAlpha()+")");
    return new Color(
      (float) ((a.getRed() * b)/255D),
      (float) ((a.getGreen() * b)/255D),
      (float) ((a.getBlue() * b)/255D),
      (float)a.getAlpha()/255F
    );
  }
  public static Color rgb(float r,float g,float b) { return new Color(r,g,b); }
  public static Color rgba(float r,float g,float b,float a) {
    // System.out.println("("+r+","+g+","+b+","+a+")");
    return new Color(r,g,b,a);
  }
}
