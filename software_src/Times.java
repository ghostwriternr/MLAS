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
public class Times {
    private int Hours_;
    private int Minutes_;
    
    public Times(){
        Hours_ = 0;
        Minutes_ = 0;
    }
    
    public Times(int hours,int minutes){
        Hours_ = hours;
        Minutes_ = minutes;
    }
    
    public int get_hours() {
        return Hours_;
    }
        
    public void set_day(int hours) {
        Hours_ = hours;
    }
    
    public int get_minutes() {
        return Minutes_;
    }
        
    public void set_minutes(int minutes) {
        Minutes_ = minutes;
    }
}
