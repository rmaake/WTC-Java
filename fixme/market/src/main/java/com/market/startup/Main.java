package com.market.startup;

import com.market.controllers.*;
public class Main
{
  //args[0] == quantity, args[1] == price
  public static void main(String[] args)
  {
    MarketController market = new MarketController(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    try
    {
      market.contact();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}