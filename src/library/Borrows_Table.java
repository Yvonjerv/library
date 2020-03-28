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
public class Borrows_Table {
    String Student_id , First_name , Last_name , Title, Author, Start_date, End_date, Borrow_id;

    public Borrows_Table(String Student_id, String First_name, String Last_name, String Title, String Author, String Start_date, String End_date,String Borrow_id) {
        this.Student_id = Student_id;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Title = Title;
        this.Author = Author;
        this.Start_date = Start_date;
        this.End_date = End_date;
        this.Borrow_id = Borrow_id;
    }

    public String getBorrow_id() {
        return Borrow_id;
    }

    public void setBorrow_id(String Borrow_id) {
        this.Borrow_id = Borrow_id;
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getStart_date() {
        return Start_date;
    }

    public void setStart_date(String Start_date) {
        this.Start_date = Start_date;
    }

    public String getEnd_date() {
        return End_date;
    }

    public void setEnd_date(String End_date) {
        this.End_date = End_date;
    }
    
    
    
}
