/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author YVON
 */
public class Students_Table {
    String Student_id, First_name , Last_name, Gender, Dob, Address, Phone_number, Student_Reference;

    public Students_Table(String Student_id, String First_name, String Last_name, String Gender, String Dob, String Address, String Phone_number, String Student_Reference) {
        this.Student_id = Student_id;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Gender = Gender;
        this.Dob = Dob;
        this.Address = Address;
        this.Phone_number = Phone_number;
        this.Student_Reference = Student_Reference;
    }

    public String getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(String Student_id) {
        this.Student_id = Student_id;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String First_name) {
        this.First_name = First_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String Last_name) {
        this.Last_name = Last_name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String Phone_number) {
        this.Phone_number = Phone_number;
    }

    public String getStudent_Reference() {
        return Student_Reference;
    }

    public void setStudent_Reference(String Student_Reference) {
        this.Student_Reference = Student_Reference;
    }
    
}
