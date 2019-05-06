/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brehmlab8a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crbrehm
 */
public class BrehmLab8A {

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
            System.out.println("[1] Dump the contents of the database to console");
            System.out.println("[2] Get specific column of data");
            System.out.println("[3] Add a record");
            System.out.println("[4] Delete a record");
            System.out.println("[5] Exit the program");
            choice = sc.nextInt();
        }
        return choice;
    }

    public static void main(String[] args) {
        ResultSet result = null;
        Connection dbCon = null;
        boolean exit = false;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String myDb = "jdbc:derby://localhost:1527/Lab8A";
            dbCon = DriverManager.getConnection(myDb, "nbuser", "nbuser");
            Statement statement = dbCon.createStatement();
            result = statement.executeQuery("SELECT * from Contractors");
        } catch (ClassNotFoundException | SQLException exc) {
            System.err.println(exc);
        }

        while (!exit) {
            switch (menu()) {
                case 1:
                    System.out.println();
                    System.out.print(listAll(result));
                case 2:
                    System.out.println();
                    System.out.println(getData(result));
                case 5:
                    exit = true;
            }
        }
        try {
            dbCon.close();
        } catch (SQLException ex) {
            Logger.getLogger(BrehmLab8A.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
