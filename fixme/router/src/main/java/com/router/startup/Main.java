package com.router.startup;

import com.router.controllers.*;
public class Main
{
  
  public static void main(String[] args) {
    String host = "localhost";
    int port = 5000;
    RouterController router = new RouterController(host, port);
    try
    {
      router.startServers();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}