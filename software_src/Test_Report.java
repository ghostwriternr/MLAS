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
public class Test_Report {
    private Patient Patient_Details;
    private String Doctor_Name;
    private Test Test_Information = new Test();
    private String Patient_Result;
    
    public Test_Report(Patient patient,String doc_name,Test test,String result){
        Patient_Details = patient;
        Doctor_Name = doc_name;
        Test_Information = test;
        Patient_Result = result;
    }
    
    public Patient get_Patient_Details(){
        return Patient_Details;
    }
    
    public String get_Doctor_Name(){
        return Doctor_Name;
    }
    
    public Test get_Test_Information(){
        return Test_Information;
    }
    
    public String get_Patient_Result(){
        return Patient_Result;
    }
    
    public void set_Patient_Details(Patient patient){
        Patient_Details = patient;
    }
    
    public void get_Doctor_Name(String d_name){
        Doctor_Name = d_name;
    }
    
    public void set_Test_Information(Test test_info){
        Test_Information = test_info;
    }
    
    public void set_Patient_Result(String result){
        Patient_Result = result;
    }
}
