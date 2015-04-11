/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymlas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author barno
 */
public class Management {
    
    private Vector<Test> tests_ = new Vector<Test>(200);
    private Vector<Patient> patients_ = new Vector<Patient>(200);
    private static int num_Tests_ = 0;
    private int num_Patients_;

    
    public Management() throws SQLException{
        Connect.create_Connection(); 
        Connect.sql = "SELECT COUNT(*) AS count FROM Tests";
        ResultSet rs = Connect.stmt.executeQuery(Connect.sql);
        rs.next();
        num_Tests_ = rs.getInt("count");
        tests_ = new Vector<Test>(num_Tests_);
        Connect.sql = "SELECT * FROM Tests";
        rs = Connect.stmt.executeQuery(Connect.sql);
        while(rs.next()){
          tests_.addElement(new Test(rs.getString("Test_Name"),rs.getInt("Test_Charges")));
        }
    }
    
    
    public boolean add_Test(Test test) throws SQLException{
        Connect.create_Connection();
        Connect.sql = "SELECT * FROM Tests WHERE Test_Name = '" + test.get_Testname() + "';";
        ResultSet rs = Connect.stmt.executeQuery(Connect.sql);
        boolean flag = false;
        while(rs.next()){
            flag = true;
        }
        if(flag == true){
            return false;
        }
        Connect.sql = "SELECT * FROM Tests";
        rs = Connect.stmt.executeQuery(Connect.sql);
        int serial_temp = 0;
        while(rs.next()){
            serial_temp = rs.getInt("id");
        }
        serial_temp++;
        Connect.sql = "SELECT * FROM Tests";
        rs = Connect.stmt.executeQuery(Connect.sql);
        Connect.sql = "INSERT INTO Tests VALUES (" + serial_temp + ",'" + test.get_Testname() + "'," + test.get_Testcharges() + ");";
        Connect.stmt.executeUpdate(Connect.sql);
        tests_.addElement(new Test(test));
        num_Tests_++;
        return true;
    }

    public void remove_Test(Test test) throws SQLException{
        Connect.create_Connection();      
        Connect.sql = "DELETE FROM Tests WHERE Test_Name = '" + test.get_Testname() + "';";
        Connect.stmt.executeUpdate(Connect.sql);
        Connect.stmt.close();
        tests_.removeElement(test);
        num_Tests_--;
    }
   
    
    public boolean edit_Test(Test prev_Test, Test new_Test) throws SQLException {
        Connect.create_Connection();      
        Connect.sql = "SELECT * FROM Tests WHERE Test_Name = '" + prev_Test.get_Testname()+ "' AND Test_Charges = " + prev_Test.get_Testcharges()  + ";";
        ResultSet rs = Connect.stmt.executeQuery(Connect.sql);
        boolean flag1 = true;
        while(rs.next()){
            flag1 = false;
        }
        if(flag1 == true){
            Connect.sql = "SELECT COUNT(*) AS count FROM Tests";
            rs = Connect.stmt.executeQuery(Connect.sql);
            rs.next();
            int serial = rs.getInt("count");
            Connect.sql = "INSERT INTO Tests VALUES (" + (serial + 1) + ",'" + new_Test.get_Testname() + "'," + new_Test.get_Testcharges() + ");";
            Connect.stmt.executeUpdate(Connect.sql);
            tests_.addElement(new_Test);
            num_Tests_++;
            return true;
        }
        flag1 = true;
        if(!new_Test.get_Testname().equals(prev_Test.get_Testname())){
            Connect.sql = "SELECT * FROM Tests WHERE Test_Name = '" + new_Test.get_Testname() + "';";
            rs = Connect.stmt.executeQuery(Connect.sql);
            while(rs.next()){
                flag1 = false;
            }
            if(flag1 == false){
                return flag1;
            }
        }
        Connect.sql = "UPDATE Tests SET Test_Name = '" + new_Test.get_Testname() + "',Test_Charges = " + new_Test.get_Testcharges() + " WHERE Test_Name = '" + prev_Test.get_Testname() + "' AND Test_Charges = " + prev_Test.get_Testcharges() + ";";
        Connect.stmt.executeUpdate(Connect.sql);
        for(int i = 0;i < num_Tests_;i++){
            if(list_Tests(i) == prev_Test){
                list_Tests(i).set_Testname(new_Test.get_Testname());
                list_Tests(i).set_Testcharges(new_Test.get_Testcharges());
                //list_Tests(i).set_Normal_values(new_Test.get_Normal_values());
                break;
            }
        }
        return true;
    }
    
    public void place_New_Order(Stocks item) throws SQLException {
        Connect.create_Connection();
        Connect.sql = "SELECT * FROM NotifyStocks WHERE Item_Name = '" + item.get_Item_Name() + "';";
        ResultSet rs = Connect.stmt.executeQuery(Connect.sql);
        int quantity = 0;
        boolean flag = false,flag2 = false;
        while(rs.next()){
            flag2 = true;
            quantity = rs.getInt("Quantity");
            if(quantity + item.get_Quantity() >= rs.getInt("Threshold")){
                flag = true;
            }
            quantity = quantity + item.get_Quantity();
        }
        if(flag == true) {
            Connect.sql = "DELETE FROM NotifyStocks WHERE Item_Name = '" + item.get_Item_Name() + "';";
            Connect.stmt.executeUpdate(Connect.sql);
        }
        else if(flag2 == true) {
             Connect.sql = "UPDATE NotifyStocks SET Quantity = " + quantity + " WHERE Item_Name = '" + item.get_Item_Name() + "';";
             Connect.stmt.executeUpdate(Connect.sql);
        }
        Connect.sql = "SELECT * FROM Stocks WHERE Item_Name = '" + item.get_Item_Name() + "';";
        rs = Connect.stmt.executeQuery(Connect.sql);
        while(rs.next()){
            quantity = rs.getInt("Quantity") + item.get_Quantity();
        }
        Connect.sql = "UPDATE Stocks SET Quantity = " + quantity + " WHERE Item_Name = '" + item.get_Item_Name() + "';";
        Connect.stmt.executeUpdate(Connect.sql);
    }
    
    public void place_Bulk_Order(Vector check_Stocks) throws SQLException {
        Connect.create_Connection();
        ResultSet rs;
        for(int i = 0;i < check_Stocks.size();i++){
            Connect.sql = "SELECT * FROM Stocks WHERE Item_Name = '" + String.valueOf(check_Stocks.elementAt(i)) + "';";
            rs = Connect.stmt.executeQuery(Connect.sql);
            int threshold = 0;
            while(rs.next()){
                threshold = rs.getInt("Threshold");
            }
            Connect.sql = "UPDATE Stocks SET Quantity = " + threshold + " WHERE Item_Name = '" + String.valueOf(check_Stocks.elementAt(i)) + "';";
            Connect.stmt.executeUpdate(Connect.sql);
        }
    }
    
    public int get_num_tests(){
        return num_Tests_;
    }
    
    public Test list_Tests(int i){
        return tests_.elementAt(i);
    }
    
    
    ///////////////////
    
    private Vector<Stocks> stock_Item_ = new Vector<Stocks>(200);
    private int num_Stocks_;
    /*
    public Medical_Lab_Employee() throws SQLException{
        Connect.create_Connection(); 
        Connect.sql = "SELECT COUNT(*) AS count FROM Stocks";
        ResultSet rs = Connect.stmt.executeQuery(Connect.sql);
        rs.next();
        num_Stocks_ = rs.getInt("count");
        stock_Item_ = new Vector<Stock_Item>(num_Stocks_);
        Connect.sql = "SELECT * FROM Stocks";
        rs = Connect.stmt.executeQuery(Connect.sql);
        Stock_Item stock= new Stock_Item();
        while(rs.next()){
           stock.set_Item_Name(rs.getString("Item_Name"));
           stock.set_Quantity(rs.getInt("Quantity"));
           stock.set_Threshold(rs.getInt("Threshold"));
           stock_Item_.addElement(new Stock_Item(stock));    
        }
        Connect.stmt.close();
    }
    */
    
    public Bill generate_Bill(String patient_Name, String doctor_Name, Test test)throws SQLException {
        Bill bill_temp = new Bill();
        bill_temp.set_patient_Name(patient_Name);
        bill_temp.set_doctor_Name(doctor_Name);
        bill_temp.set_test_Performed(test);
        Connect.create_Connection(); 
        Connect.sql = "SELECT COUNT(*) AS count FROM Bills";
        ResultSet rs = Connect.stmt.executeQuery(Connect.sql);
        rs.next();
        bill_temp.set_unique_Id(rs.getInt("count") + 1);
        return bill_temp;
    }

    public Test_Report generate_Test_Report(Patient patient, String doctor_Name, Test test, String result) throws SQLException {
        Test_Report report = new Test_Report(patient,doctor_Name,test,result);
        return report;
    }

    public boolean check_Stock_Item(Stocks item) {
        if(item.get_Quantity() >= item.get_Threshold()){
            return true;
        }
        else {
            return false;
        }
    }
    
    public void notify_Management(Stocks item) throws SQLException {
        Connect.create_Connection();
        Connect.sql = "SELECT * FROM NotifyStocks;";
        ResultSet rs = Connect.stmt.executeQuery(Connect.sql);
        int serial = 0;
        while(rs.next()) {
            serial = rs.getInt("serial");
        }
        Connect.sql = "SELECT * FROM NotifyStocks WHERE Item_Name = '" + item.get_Item_Name() + "';";
        rs = Connect.stmt.executeQuery(Connect.sql);
        boolean flag = false;
        while(rs.next()){
            flag = true;
        }
        if(flag == true){
            Connect.sql = "UPDATE NotifyStocks SET Quantity = " + item.get_Quantity() + " WHERE Item_Name = '" + item.get_Item_Name() + "';";
            Connect.stmt.executeUpdate(Connect.sql);
        }
        else {
            Connect.sql = "INSERT INTO NotifyStocks VALUES (" + (serial + 1) + ",'" + item.get_Item_Name() + "'," + item.get_Quantity() + "," + item.get_Threshold() + ");";
            Connect.stmt.executeUpdate(Connect.sql);
        }
        Connect.stmt.close();
    }
    
    public Vector check_all_Stocks() {
        Vector check_stocks = new Vector(200);
        for(int i = 0;i < num_Stocks_ ;i++){
            if(list_Stocks(i).get_Quantity() >= list_Stocks(i).get_Threshold()){
                check_stocks.addElement("true");
            }
            else {
                check_stocks.addElement("false");
            }
        }
        return check_stocks;
    }
    
    public void notify_Management_multiple(Vector vect) {
    
    }
    
    public boolean add_Patient(String p_name,int p_age,String p_gender) throws SQLException{
       Connect.create_Connection(); 
       Connect.sql = "SELECT * FROM Patients WHERE Name = '" + p_name + "' AND Age = " + p_age + " AND Gender = '" + p_gender + "';";
       ResultSet rs = Connect.stmt.executeQuery(Connect.sql);
       boolean flag = true;
       int idd = 0;
       while(rs.next()){
           flag = false;
           break;
       }
       if(flag == true){
         Connect.sql = "SELECT * FROM Patients;";
         rs = Connect.stmt.executeQuery(Connect.sql);
         while(rs.next()){
           idd = rs.getInt("id");
         }
         idd++;
         Connect.sql = "INSERT INTO Patients VALUES(" + idd + ",'" + p_name + "'," + p_age + ",'" + p_gender + "','" + p_name + "123')";
         Connect.stmt.executeUpdate(Connect.sql);
         Connect.stmt.close();
         Connect.conn.close();
       }
       return flag; 
    }
    
    public Stocks list_Stocks(int i){
        return stock_Item_.elementAt(i);
    }
    public int get_num_Stocks(){
        return num_Stocks_;
    }
}
