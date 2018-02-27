package com.revature.banking.part2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class T_test {

    //static Logger log = Logger.getLogger(Test.class.getName());
    
    public static void main(String[] argv) {

        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@feb12usf.cll2dycnuoiq.us-east-2.rds.amazonaws.com:1521:ORCL", "gkigundu", "revature");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }
        
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        
//        log.debug("Hello this is a debug message");
//        log.info("Hello this is an info message");
        
        try (Statement stmt = connection.createStatement(); 
            ResultSet rs = stmt.executeQuery("select * from employee");) {
          
          int row = 0;
          while (rs.next()) {
            System.out.println("----------Row " + (++row) + " ------------");
            System.out.println("EMP_ID=" + rs.getString(1));
            System.out.println("FIRSTNAME=" + rs.getString(2));
            System.out.println("LASTNAME=" + rs.getString(3));
            System.out.println();
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }
        
    }

}



