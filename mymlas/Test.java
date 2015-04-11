/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymlas;

import java.util.Vector;

/**
 *
 * @author ghost_000
 */
public class Test {
    private String Test_name;
    private int Test_charges;
    //public Vector<Stocks> stockReq = new Vector<Stocks>();
    public String stockReq;
    
    public Test(){
        Test_name = "";
        Test_charges = 0;
        //Normal_values = "";
    }
    
    public Test(String Testname,int Testcharges,String st){
        Test_name = Testname;
        Test_charges = Testcharges;
        stockReq = st;
        //Normal_values = Normvalues;
    }
    
    public Test(Test test){
        Test_name = test.get_Testname();
        Test_charges = test.get_Testcharges();
        //Normal_values = test.get_Normal_values();
    }
    
    public void set_Testname(String t_name){
        Test_name = t_name;
    }
    
    public void set_Testcharges(int t_charges){
        Test_charges = t_charges;
    }
    
    public void set_Normal_values(String norm_values){
        //Normal_values = norm_values;
    }
    
    public String get_Testname(){
       return Test_name;
    }
    
    public int get_Testcharges(){
      return Test_charges;
    }
}
