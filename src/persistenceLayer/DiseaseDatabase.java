package persistenceLayer;

import BusinessLogicLayer.Disease;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DiseaseDatabase
{
    public int diseaseID(String disease) // working
    {
        int id = 0;
        try
            {
            Statement statement1 = Database.getConnection().createStatement();
            String sqll = "SELECT diseaseID FROM disease WHERE diseaseName = '" + disease + "'";
            ResultSet rSet = statement1.executeQuery(sqll);
            while (rSet.next())
                {
                id = rSet.getInt(1);
                }
            System.out.println(id);
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        return id;
    }
    public ArrayList<String> diseaseList() //working
    {
        ArrayList<String> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement();
            String sql = "SELECT diseaseName FROM disease";
            resultSet = statement.executeQuery(sql);
        while(resultSet.next())
            {
            list.add(resultSet.getString("diseaseName"));
            }
        statement.close();
        connection.close();

        } catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.out.println("Exception occured.");
            }
        return list;
    }
    public void insertDisease(Disease disease) //working
    {
        Connection connection = Database.getConnection();
        try{
        String sql = "INSERT INTO disease (diseaseName,discription) VALUES (?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, disease.getName());
        preparedStatement.setString(2, disease.getDiscription());
        int row = preparedStatement.executeUpdate();
        if (row > 0)
            {
            JOptionPane.showMessageDialog(null,"A row has been inserted successfully.");
            }
        connection.close();
        }catch(Exception e)
            {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
    }
    public static void main(String a[])
    {
        DiseaseDatabase d = new DiseaseDatabase();
        ArrayList<String> list = d.diseaseList();
        for (int i=0; i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
//        Disease disease = new Disease();
//        disease.setName("headache");
//        disease.setDiscription("unknown");
//        d.insertDisease(disease);
        //System.out.println(d.diseaseID("headache"));
    }
}
