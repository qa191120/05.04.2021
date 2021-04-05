package com.example;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {

    private String m_conn; // connection string

    public EmployeeDAO(String m_conn) {
        this.m_conn = m_conn;
    }

    // Remove to different class
    public void creaetDatabase(String name) {
        String url = "jdbc:sqlite:D:/SQLITE/" + name;
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Employee> getAllEmployees() {
        // fire select query
        // create Employee instance per record
        // create array list of all employees
        // try to connect to db

        ArrayList<Employee> employees = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                // prepare query string
                String sql = "SELECT * FROM EMPLOYEES";

                // prepare statement
                Statement stmt = conn.createStatement();

                // fire query
                ResultSet rs = stmt.executeQuery(sql);

                // read results
                while (rs.next()) {
                    Employee e = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("address"),
                    rs.getDouble("salary"));
                    employees.add(e);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return employees;
    }

    public void select(String query) {

        // try to connect to db
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                // prepare query string
                String sql = query;

                // prepare statement
                Statement stmt = conn.createStatement();

                // fire query
                ResultSet rs = stmt.executeQuery(sql);

                // read results
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getInt("age") + "\t" +
                            rs.getString("address") + "\t" +
                            rs.getDouble("salary")
                    );
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(String query) {

        // try to connect to db
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                // prepare query
                String sql = query;

                // prepare statement
                Statement stmt = conn.createStatement();

                // fire query
                int result = stmt.executeUpdate(sql); // not expect result
                System.out.println(result + " record updated.");
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}