package persistenceLayer;

import BusinessLogicLayer.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserAuthentication
{
    Database database = new Database();
    public boolean checkGuestUser(User user)
    {
        Connection connection = Database.getConnection();
        Statement statement = null;int check = 0;
        try{
            statement = connection.createStatement();
            String query = "select * from users";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                if(resultSet.getString("userName").equals(user.getUserName())&&resultSet.getString("password").equals(user.getPassword())&&resultSet.getString("userType").equals(user.getType()))
                {
                    check++;break;
                }
            }
            connection.close();
        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Exception occured.");
        }
        if(check>0){
            return true;}
        else{
            return false;
        }
    }
    public boolean checkAdminUser(User user)
    {
        Connection connection = Database.getConnection();
        Statement statement = null;int check = 0;
        try{
            statement = connection.createStatement();
            String query = "select * from users";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                if(resultSet.getString("userName").equals(user.getUserName())&&resultSet.getString("password").equals(user.getPassword())&&resultSet.getString("userType").equals(user.getType()))
                {
                    check++;break;
                }
            }
            connection.close();
        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Exception occured.");
        }
        if(check>0){
        return true;}
        else{
            return false;
        }
    }
    public void changePassword(User user)
    {
        Connection connection = Database.getConnection();
        Statement statement = null;
        try{
            statement = connection.createStatement();
            String query = "update users set password = ? where userName = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, user.getPassword());
            preparedStmt.setString(2, user.getUserName());
            int row = preparedStmt.executeUpdate();
            if (row > 0)
            {
                JOptionPane.showMessageDialog(null,"A row has been inserted successfully.");
            }
            connection.close();
        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Exception occured.");
        }
    }
    public void signUp(User user)
    {
        Connection connection = Database.getConnection();
        Statement statement = null;
        try{
            statement = connection.createStatement();
            String sql = "INSERT INTO users (userName,password,userType) VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getType());
            int row = preparedStatement.executeUpdate();
            if (row > 0)
            {
                JOptionPane.showMessageDialog(null,"A row has been inserted successfully.");
            }
            connection.close();
        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Exception occured.");
        }
    }
    public void forgetpassword(User user)
    {
        Connection connection = Database.getConnection();
        Statement statement = null;
        try{
            statement = connection.createStatement();
            String query = "update users set password = ? where userName = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, user.getPassword());
            preparedStmt.setString(2, user.getUserName());
            int row = preparedStmt.executeUpdate();
            if (row > 0)
            {
                JOptionPane.showMessageDialog(null,"A row has been inserted successfully.");
            }
            connection.close();
        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Exception occured.");
        }
    }
    public String getUserName(int Id)
    {
        return null;
    }
}
