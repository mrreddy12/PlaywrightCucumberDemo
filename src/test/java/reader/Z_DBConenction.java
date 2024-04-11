package reader;


import org.testng.annotations.Test;

import java.sql.*;

public class Z_DBConenction {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @Test
    public void dbTest() {
        connectToDB();


      //  createTable();
       // insertRow();
       // selectRow();
        closeConenction();
    }


    public void connectToDB() {

        String uid = "postgres";
        String pwd = "root";
        String dbName = "postgres";
        //  String dbURL = "jdbc:postgresql://localhost:5432/postgres";
        String dbURL = "jdbc:postgresql://localhost:5432/" + dbName;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(dbURL, uid, pwd);
            System.out.println("connection passed");

        } catch (SQLException e) {
            System.out.println("Failed to Connect to postgres");
            System.out.println(e.getMessage());
            e.printStackTrace();


        }
    }


    public void createTable()
    {
         String query="CREATE TABLE cars11  (brand VARCHAR(255), model VARCHAR(255),year INT);";
        try {
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }


    }

    public void insertRow()
    {
        String query="INSERT INTO cars11 (brand, model, year) VALUES ('Ford11', 'Mustang11', 1964);";
        try {
            statement=connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }


    }

    public void selectRow()
    {
        String query="select * from cars;";
        try {
            statement=connection.createStatement();
           resultSet= statement.executeQuery(query);
            while(resultSet.next())
            {
//               int rCount=resultSet.getRow();
//               System.out.println("row count"+rCount);
//                System.out.println(resultSet.getString(rCount));  apply to retrieve first value of first row without depend on col name
                System.out.print(resultSet.getString("brand")+" ");
                System.out.print(resultSet.getString("model")+" ");
                System.out.println(resultSet.getString("year")+" ");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }


    }
    public void closeConenction()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}