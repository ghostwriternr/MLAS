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
public class Date {
    private int day_;
    private int month_;
    private int year_;
  
    public Date(){
        day_ = 1;
        month_ = 1;
        year_ = 2014;
    }
    
    public Date(int day,int month,int year){
        day_ = day;
        month_ = month;
        year_ = year;
    }
    
    public int get_day() {
        return day_;
    }
        
    public void set_day(int day) {
        day_ = day;
    }

    public int get_month() {
        return month_;
    }

    public void set_month(int month) {
        month_ = month;
    }

    public int get_year() {
        return year_;
    }

    public void set_year(int year) {
        year_ = year;
    }
}
