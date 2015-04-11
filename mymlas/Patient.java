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
public class Patient {
    private String name;
    private char gender;
    private int age;
    private String password;
    
    public Patient(String n, char g,int a, String p)
    {
        name = n;
        gender = g;
        age = a;
        password = p;
    }
    
    public String getName()
    {
        return name;
    }
    
    public char getGender()
    {
        return gender;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public String getPassword()
    {
        return password;
    }
}
