/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymlas;

/**
 *
 * @author ghost_000
 */
public class Order {
    private Stocks item;
    boolean isReceived;
    
   public Order()
   {
       item = new Stocks();
       //quantity = 0;
       isReceived = false;
   }
   
   public Order(Stocks i)
   {
       item = new Stocks(i);
       //quantity = 0;
       isReceived = false;
   }
   
   public Stocks getItem()
   {
       return item;
   }
   
   public boolean getStatus()
   {
       return isReceived;
   }
}
