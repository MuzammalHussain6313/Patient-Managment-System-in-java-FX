package persistenceLayer;

import BusinessLogicLayer.Disease;
import BusinessLogicLayer.Doctor;
import BusinessLogicLayer.Patient;

import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PatientDatabase
{
    public Patient getPatientInfo(int id)          // working but change date formate
    {
        Patient patient = new Patient();
        Doctor doctor = new Doctor();
        ResultSet RSet = null;
        Statement statement1 = null;
        try {
            statement1 = Database.getConnection().createStatement();


            String sqll = "SELECT * FROM patient NATURAL JOIN doctor WHERE id = " + id +"";
            RSet = statement1.executeQuery(sqll);
            DoctorDatabase db = new DoctorDatabase();
            // doctor
            while (RSet.next()){
                doctor = db.getDoctorInfo(RSet.getInt("doctorID"));
                patient.setDoctor(doctor);
                patient.setName(RSet.getString("name"));
                patient.setFatherName(RSet.getString("fatherName"));
                patient.setGender(RSet.getString("gender"));
                java.sql.Date date = RSet.getDate("dateOfBirth");
                //java.sql.Date utilDate = new java.util.Date(date.getTime());
                patient.setDateOfBirth(date);
                patient.setDiseaseHistory(RSet.getString("diseaseHistory"));
                patient.setPrescription(RSet.getString("prescription"));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return patient;
    }
    public void insertPatient(Patient patient)  // working
    {
        Connection connection = Database.getConnection();
        Statement statement = null;
        try{
        statement = connection.createStatement();
        String doctor = patient.getDoctor().getName();
        ResultSet resultSet = statement.executeQuery("SELECT doctorID FROM doctor WHERE doctorName ='" + doctor + "'");
        int idd=0 ;
        while(resultSet.next())
            {
            idd = resultSet.getInt(1);
            }
        System.out.println(idd);
        java.sql.Date d = new java.sql.Date(patient.getDateOfBirth().getTime());
        String sql = "INSERT INTO patient (name,fatherName,gender,dateOfBirth,doctorID,diseaseHistory,prescription) VALUES (?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, patient.getName());
        preparedStatement.setString(2, patient.getFatherName());
        preparedStatement.setString(3, patient.getGender());
        preparedStatement.setDate(4, d);
        preparedStatement.setInt(5, idd);
        preparedStatement.setString(6, patient.getDiseaseHistory());
        preparedStatement.setString(7, patient.getPrescription());
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
    public void deletePatient(Patient patient)  // working
    {
        Connection connection = Database.getConnection();
        try
            {
            String sql = "DELETE FROM patient WHERE name=? AND fatherName=?";
            //String sql = "DELETE FROM patient WHERE (name = " + name + " AND fatherName = " + fname + ")";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, patient.getName());
            statement.setString(2,patient.getFatherName());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0)
                {
                JOptionPane.showMessageDialog(null,"A user was deleted successfully!");
                }
            connection.close();
            } catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Exception occured.");
            }
    }
    public ArrayList<Patient> searchPatientByID(int iD)
    {
        ArrayList<Patient> list = new ArrayList();
        try
            {
            Statement statement1 = Database.getConnection().createStatement();

            String sqll = "SELECT * FROM patient WHERE id = "+iD+"";
            ResultSet RSet = statement1.executeQuery(sqll);
            while (RSet.next())
                {
                    list.add(this.getPatientInfo(RSet.getInt("id")));
                }
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        return list;
    }
    public ArrayList<Patient> searchPatientByDisease(String Dname) // not working
    {
        ArrayList<Patient> list = new ArrayList();
        try
        {
//            String diseaseId = "SELECT diseaseID FROM disease WHERE diseaseName LIKE '%"+Dname+"%'";
//            ResultSet RSet = statement1.executeQuery(diseaseId);
//            while (RSet.next())
//            {
//                int newID = RSet.getInt("diseaseID");
//            }
            Statement statement1 = Database.getConnection().createStatement();
            DiseaseDatabase diseaseDatabase = new DiseaseDatabase();
            DoctorDatabase doctorDatabase = new DoctorDatabase();
            int doctorID = doctorDatabase.doctorID(diseaseDatabase.diseaseID(Dname));
            String sqll = "SELECT * FROM patient NATURAL JOIN doctor WHERE doctorID = "+doctorID+"";
            ResultSet RSet = statement1.executeQuery(sqll);
            while (RSet.next())
            {
                list.add(this.getPatientInfo(RSet.getInt("id")));
            }
        }catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return list;
    }
    public ArrayList<Patient> searchPatientByAge(int age) // working
    {
        ArrayList<Patient> list = new ArrayList();
        try
            {
            Statement statement1 = Database.getConnection().createStatement();
            String sqll = "SELECT *, YEAR(CURDATE()) - YEAR(dateOfBirth) AS age FROM patient";
            ResultSet rSet = statement1.executeQuery(sqll);
            int array[] = new int[10];int i=0;
            while (rSet.next())
                {
                if(rSet.getInt("age")==age)
                    {
                        list.add(this.getPatientInfo(rSet.getInt("id")));
                    }
                }
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
            return list;
    }
    public ArrayList<Patient> searchPatientByNAME(String name) //working
    {
        ArrayList<Patient> list = new ArrayList();
        try
            {
            Statement statement1 = Database.getConnection().createStatement();

            String sqll = "SELECT * FROM patient WHERE name LIKE '%"+name+"%'";
            ResultSet RSet = statement1.executeQuery(sqll);
            while (RSet.next())
                {
                    list.add(this.getPatientInfo(RSet.getInt("id")));
                }
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        return list;

    }
    public ArrayList<Patient> searchPatientRecord(Patient patient) // Working
    {
        ArrayList<Patient> list = new ArrayList();
        try
            {
            Statement statement1 = Database.getConnection().createStatement();
            String sqll = "SELECT * FROM patient WHERE name LIKE '%"+patient.getName()+"%' OR fatherName LIKE '%"+patient.getFatherName()+"%'";
            ResultSet rSet = statement1.executeQuery(sqll);
            while (rSet.next())
                {
                    list.add(this.getPatientInfo(rSet.getInt("id")));
                }
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        return list;
    }
    public int getPatientID() // working
    {
        int id = 1;
        try
            {
            Statement statement1 = Database.getConnection().createStatement();
            String sqll = "SELECT * FROM patient";
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
    public ArrayList<Patient> searchPatientByDoctor(String name) // working
    {
        ArrayList<Patient> list = new ArrayList();
        try
            {
            Statement statement1 = Database.getConnection().createStatement();
            ////////////// That statement as well as next statement is also working ////////////////////
            //String sqll = "SELECT name, fatherName FROM patient WHERE name = '"+name+"' AND fatherName = '"+Fname+"'";
            String sqll = "SELECT * FROM patient NATURAL JOIN doctor WHERE doctorName LIKE '%"+name+"%'";
            //"SELECT * FROM Contacts WHERE Name LIKE '%'"+name+"'%' AND TelePhoneNumber LIKE '"+tpNumber+"%' OR Address LIKE '%'"+address+"'%' OR Description LIKE '%'"+description+"'%'";
            ResultSet rSet = statement1.executeQuery(sqll);
            //contactTableInDefaultForm.setModel(DbUtils.resultSetToTableModel(rs));
            while (rSet.next())
                {
                    list.add(this.getPatientInfo(rSet.getInt("id")));


                //JOptionPane.showMessageDialog(null,"ID : "+rSet.getInt("id")+"\nName :" + rSet.getString("name")+"\nFather Name : "+rSet.getString("fatherName")+"\nGender "+rSet.getString("gender")+"\nDate Of Birth"+rSet.getString("dateOfBirth")+"\nDoctor ID : "+rSet.getString("doctorID")+"\nDisease History"+rSet.getString("diseaseHistory")+"\nPrescription : "+rSet.getString("prescription"));
                }
            }catch (Exception e)
            {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
            return list;
    }
    public static void main(String a[])
    {
        PatientDatabase p = new PatientDatabase();
        Doctor doctor = new Doctor();
        doctor.setName("osama Gill");
        java.util.Date date=java.util.Calendar.getInstance().getTime();
        //Patient patient = new Patient("saghir ahmed","nazeer ahmed","gender",date,doctor,"diseaseH","discription");
        //p.searchPatientByDisease("ali Hamza");
        //p.insertPatient(patient);
        //p.deletePatient(patient);
        ArrayList<Patient> list = new ArrayList<>();
        //list = p.searchPatientByNAME("shais mirza");
        //list = p.searchPatientRecord(patient);
        list = p.searchPatientByDoctor("mubashir");
        for(int i =0;i<list.size();i++)
        {

            System.out.println(list.get(i).getName());
            System.out.println(list.get(i).getFatherName());
            System.out.println(list.get(i).getGender());
            System.out.println(list.get(i).getDateOfBirth());
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(df.format(list.get(i).getDateOfBirth()));
            System.out.println(list.get(i).getDoctor().getName());
            System.out.println(list.get(i).getDiseaseHistory());
            System.out.println(list.get(i).getPrescription());
        }

    }
}
