/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DataBase.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amr masoud
 */
public class User {
    
    Database db = new Database();

    public String Fname;
    public String Lname;
    public String Email;
    public String Password;
    public String Credit;

    public User() {
    }

    public User(String Fname, String Lname, String Email, String password, String credit) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.Email = Email;
        this.Password = password;
        this.Credit = credit;
    }

    public String getUserId(String email, String Password) {
        return db.getUserId(email, Password);

    }

    public User getDate(String email) {
        return db.getDate(email);

    }

}
