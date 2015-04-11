package mymlas;


public class Bill {
    
    private String patient_Name_;
    private String doctor_Name_;
    private Test test_Performed_ = new Test();
    private Date date_Of_Test_ = new Date();
    private int unique_Id_;
    private Date date_Of_Collection_ = new Date();
    private Times time_Of_Collection_ = new Times();
    
    public Bill(){
        patient_Name_ = "";
        doctor_Name_ = "";
    }
    
    public Bill(Bill bill){
        patient_Name_ = bill.get_patient_Name();
        doctor_Name_ = bill.get_doctor_Name();
        test_Performed_ = bill.get_test_Performed();
        date_Of_Test_ = bill.get_date_Of_Test();
        date_Of_Collection_ = bill.get_date_Of_Collection();
        time_Of_Collection_ = bill.get_time_Of_Collection();
        unique_Id_ = bill.get_unique_Id();
    }
    
    public void set_patient_Name(String name) {
        patient_Name_ = name;
    }
    
    public void set_doctor_Name(String name) {
        doctor_Name_ = name;
    }
    
    public void set_test_Performed(Test test) {
        test_Performed_ = test;
    }
    
    public void set_date_Of_Test(Date date) {
        date_Of_Test_ = date;
    }    
    
    public void set_unique_Id(int id) {
        unique_Id_ = id;
    }
    
    public void set_date_Of_Collection(Date date) {
        date_Of_Collection_ = date;
    }

    public void set_time_Of_Collection(Times time) {
        time_Of_Collection_ = time;
    }
    
    public String get_patient_Name() {
        return patient_Name_;
    }
    
    public String get_doctor_Name() {
        return doctor_Name_;
    }
    
    public Test get_test_Performed() {
        return test_Performed_;
    }
    
    public Date get_date_Of_Test() {
        return date_Of_Test_;
    }    
    
    public int get_unique_Id() {
        return unique_Id_;
    }
    
    public Date get_date_Of_Collection() {
        return date_Of_Collection_;
    }

    public Times get_time_Of_Collection() {
        return time_Of_Collection_;
    }

}
