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
public class Stocks {
    private String Item_Name_;
    private int Quantity_;
    private int Threshold_;
    
    public Stocks(){
        Item_Name_ = "";
        Quantity_ = 0;
        Threshold_ = 0;
    }
    
    public Stocks(String item_name,int quantity,int threshold){
        Item_Name_ = item_name;
        Quantity_ = quantity;
        Threshold_ = threshold;
    }
    
    public Stocks(Stocks stock){
        Item_Name_ = stock.get_Item_Name();
        Quantity_ = stock.get_Quantity();
        Threshold_ = stock.get_Threshold();
    }
    
    public String get_Item_Name() {
        return Item_Name_;
    }
        
    public void set_Item_Name(String name) {
        Item_Name_ = name;
    }

    public int get_Quantity() {
        return Quantity_;
    }

    public void set_Quantity(int quantity) {
        Quantity_ = quantity;
    }

    public int get_Threshold() {
        return Threshold_;
    }

    public void set_Threshold(int threshold) {
        Threshold_ = threshold;
    } 
}
