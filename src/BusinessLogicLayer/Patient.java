package BusinessLogicLayer;

import java.util.Date;

public class Patient
{
    private int id;
    private String Name;
    private String FatherName;
    private String Gender;
    private java.sql.Date DateOfBirth;
    private Doctor doctor;
    private String DiseaseHistory;
    private String Prescription;
    public Patient()
    {

    }
    public Patient(String name,String fatherName,String gender,java.sql.Date dateOfBirth,Doctor doctor,String diseaseHistory, String prescription)
    {
        this.Name = name;
        this.FatherName = fatherName;
        this.Gender = gender;
        this.DateOfBirth = dateOfBirth;
        this.doctor = doctor;
        this.DiseaseHistory = diseaseHistory;
        this.Prescription = prescription;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setFatherName(String fatherName) {
        this.FatherName = fatherName;
    }

    public void setDiseaseHistory(String diseaseHistory) {
        this.DiseaseHistory = diseaseHistory;
    }

    public void setPrescription(String prescription) {
        this.Prescription = prescription;
    }

    public void setDateOfBirth(java.sql.Date dateOfBirth) {
        this.DateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public int getid()
    {
        return id;
    }
    public String getName()
    {
        return Name;
    }
    public String getFatherName()
    {
        return FatherName;
    }
    public String getGender()
    {
        return Gender;
    }
    public Date getDateOfBirth()
    {
        //java.sql.Date sqlDate = new java.sql.Date(dateOfBirth.getTime());
        return DateOfBirth;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor()
    {
        return doctor;
    }
    public String getDiseaseHistory()
    {
        return DiseaseHistory;
    }
    public String getPrescription()
    {
        return Prescription;
    }
}
