package persistenceLayer;
import BusinessLogicLayer.Disease;
import BusinessLogicLayer.Doctor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DoctorDatabase
{
    DiseaseDatabase diseaseDatabase = new DiseaseDatabase();
    public int doctorID(int idd)
    {
        int id = 0;
        try
        {
            Statement statement1 = Database.getConnection().createStatement();
            String sqll = "SELECT doctorID FROM doctor WHERE diseaseID = '" + idd + "'";
            ResultSet rSet = statement1.executeQuery(sqll);
            while (rSet.next())
            {
                id = rSet.getInt("doctorID");
            }
            System.out.println(id);
        }catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return id;
    }
    public void insertDoctor(Doctor doctor) //working
    {
        Connection connection = Database.getConnection();
        Statement statement = null;
        try{
        statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM doctor");
//        int id=0 ;
//        while(resultSet.next())
//            {
//            id = resultSet.getInt(1);
//            }
        String sql = "INSERT INTO doctor (doctorName,diseaseID) VALUES (?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //preparedStatement.setInt(1,id+1);
        preparedStatement.setString(1, doctor.getName());
        preparedStatement.setInt(2,doctor.getSpacialization().getId());
        int row = preparedStatement.executeUpdate();
        if (row > 0)
            {
            JOptionPane.showMessageDialog(null,"A row has been inserted successfully.");
            }
        connection.close();
        }catch(Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //JOptionPane.showMessageDialog(null,"Error occured !!!");
            }
    }
    public ArrayList<String> doctorList() {
        ArrayList<String> list = new ArrayList<>();
        Connection connection = Database.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();

//            resultSet = statement.executeQuery("SELECT * FROM doctor");
//            int i = 0;
//
//            while (resultSet.next()) {
//                i++;
//            }
//            list = new String[i];
//            i = 0;

            resultSet = statement.executeQuery("SELECT doctorName FROM doctor");
            while (resultSet.next()) {
                list.add(resultSet.getString("doctorName"));
            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.out.println("Exception occured.");
        }
        return list;
    }   // working
    public Doctor getDoctorInfo(int id)          // working
    {
        Doctor doctor = new Doctor();
        ResultSet RSet = null;
        Statement statement1 = null;
        try {
            statement1 = Database.getConnection().createStatement();


            String sqll = "SELECT * FROM doctor NATURAL JOIN disease WHERE doctorID = " + id +"";
            RSet = statement1.executeQuery(sqll);

            // doctor
            while (RSet.next()){
            doctor.setid(RSet.getInt("doctorID"));
            doctor.setName(RSet.getString("doctorName"));

            // Disease
            Disease doctorSpecialization = new Disease();
            doctorSpecialization.setName(RSet.getString("diseaseName"));

            // back to doctor
            doctor.setSpecialization(doctorSpecialization);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return doctor;
    }
    public ArrayList<Doctor> searchDoctorByNAME(String name) //working
    {
        ResultSet RSet = null;
        Statement statement1 = null;
        ArrayList<Doctor> doctors = new ArrayList<>();

        try {
            statement1 = Database.getConnection().createStatement();

            String sqll = "SELECT * FROM doctor WHERE doctorName LIKE '%" + name + "%'";
            RSet = statement1.executeQuery(sqll);

            while (RSet.next()) {
                doctors.add(this.getDoctorInfo(RSet.getInt("doctorID")));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return doctors;
    }
    public ArrayList<Doctor> searchDoctorBySpacialization(String name) // working
    {
        ResultSet RSet = null;
        Statement statement1 = null;
        ArrayList<Doctor> doctors = new ArrayList<>();

        try {
            statement1 = Database.getConnection().createStatement();

            String sqll = "SELECT * FROM doctor NATURAL JOIN disease WHERE diseaseName LIKE '%" + name + "%'";
            RSet = statement1.executeQuery(sqll);

            while (RSet.next()) {
                System.out.println(RSet.getInt("doctorID"));
                doctors.add(this.getDoctorInfo(RSet.getInt("doctorID")));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
        }

        return doctors;

    }
    public static void main(String a[])
    {
        DoctorDatabase d = new DoctorDatabase();

        ArrayList<Doctor> list = new ArrayList<>();

        /////////////////// working///////////////
//      list = d.searchDoctorByNAME("Valid");
//        System.out.println(list.size());
//        for(int i=0;i< list.size();i++) {
//            System.out.println(list.get(i).specialization.getName());
//            System.out.println(list.get(i).getName());
//            System.out.println(list.get(i).getId());
//        }
        /////////////////////working////////////

//        Disease disease = new Disease();
//        disease.setId(12);
//        disease.setName("unknown");
//        Doctor doctor = new Doctor();
//        doctor.setName("Muhammad Ali");
//        doctor.setSpecialization(disease);
//        d.insertDoctor(doctor);
        ////////
//        ArrayList<String> name = new ArrayList<>();
//        name = d.doctorList();
//        for(int i=0;i< name.size();i++) {
//            System.out.println(name.get(i));
//        }

//        list = d.searchDoctorBySpacialization("Heart");
//               for(int i=0;i< list.size();i++) {
//            System.out.println(list.get(i).specialization.getName());
//            System.out.println(list.get(i).getName());
//            System.out.println(list.get(i).getId());
//        }
    }
}
