/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab8a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crbrehm
 */
public class BrehmLab8A {
    
    public static int findID(ResultSet result) {
        int highestID = -1;
        try {
            while (result.next()) {
                if (result.getInt("ID") > highestID) {
                    highestID = result.getInt("ID");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return highestID;
    }
    
    public static void addRecord(ResultSet result, Connection dbCon) {
        Scanner sc = new Scanner(System.in);
        ArrayList record = new ArrayList();
        try {
            System.out.println("NEW RECORD:");
            System.out.println("ID: " + (findID(result) + 1));
            record.add(findID(result) + 1);
            ResultSetMetaData metadata = result.getMetaData();
            for (int i = 2; i <= metadata.getColumnCount(); i++) {
                String input = null;
                do {
                    System.out.print(metadata.getColumnName(i) + ": ");
                    input = sc.nextLine();
                    record.add(input);
                } while (input.isEmpty());
                input = null;
            }
            PreparedStatement ps = dbCon.prepareStatement("INSERT INTO CONTRACTORS (ID, COMPANYNAME, PHONE, CONTACTNAME, RATING, OUTOFSTATESERVICE) VALUES(?,?,?,?,?,?)");
            System.out.println(record);
            ps.setInt(1, (int) record.get(0));
            ps.setString(2, (String) record.get(1));
            ps.setString(3, (String) record.get(2));
            ps.setString(4, (String) record.get(3));
            ps.setInt(5, (int) record.get(4));
            ps.setBoolean(6, (boolean) Boolean.parseBoolean((String) record.get(5)));
            ps.execute();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public static void delRecord(ResultSet result, int index) {
        
    }

    public static String getData(ResultSet result) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        try {
            ResultSetMetaData metadata = result.getMetaData();
            System.out.print("| ");
            for (int i = 1; i <= metadata.getColumnCount(); i++) {
                System.out.print(metadata.getColumnName(i));
                System.out.print(" | ");
            }
            System.out.println();
            System.out.print("Choose a column from the list above: ");
            String selector = sc.nextLine();
            System.out.println();

            if (!result.next()) {
                sb.append("NO DATA FOUND FOR " + selector);
            } else {
                while (result.next()) {
                    sb.append(result.getString(selector) + "\n");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return sb.toString();
    }

    public static String pad(String toPad, int amount) {
        StringBuilder sb = new StringBuilder(toPad);
        if (toPad.length() < amount) {
            for (int x = 0; x < (amount - toPad.length()); x++) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String listAll(ResultSet result) {
        StringBuilder sb = new StringBuilder();
        try {
            ResultSetMetaData metadata = result.getMetaData();
            for (int i = 1; i <= metadata.getColumnCount(); i++) {
                sb.append(pad(metadata.getColumnName(i), 28));
            }
            sb.append("\n");
            while (result.next()) {
                for (int i = 1; i < 7; i++) {
                    sb.append(pad(result.getString(i), 25));
                    sb.append(" | ");
                }
                sb.append("\n");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return sb.toString();
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice < 1 || choice > 4) {
            System.out.println();
            System.out.println("Choose an option:");
            System.out.println("[1] Dump the contents of the database to console");
            System.out.println("[2] Get specific column of data");
            System.out.println("[3] Add a record");
            System.out.println("[4] Delete a record");
            System.out.println("Enter anything else to quit.");
            choice = sc.nextInt();
        }
        return choice;
    }

    public static void main(String[] args) {
        ResultSet result = null;
        Connection dbCon = null;
        boolean exit = false;
        boolean connected = false;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String myDb = "jdbc:derby://localhost:1527/Lab8A";
            dbCon = DriverManager.getConnection(myDb, "nbuser", "nbuser");
            Statement statement = dbCon.createStatement();
            result = statement.executeQuery("SELECT * from Contractors");
            connected = true;
        } catch (ClassNotFoundException | SQLException exc) {
            System.err.println(exc);
            System.err.println("Connection failed. Please make sure the database server is running.");
        }

        while (!exit && connected) {
            switch (menu()) {
                case 1:
                    System.out.println();
                    System.out.print(listAll(result));
                    break;
                case 2:
                    System.out.println();
                    System.out.println(getData(result));
                    break;
                case 3:
                    System.out.println();
                    addRecord(result, dbCon);
                default:
                    exit = true;
                    break;
            }
        }

        if (connected) {
            try {
                dbCon.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }
}
