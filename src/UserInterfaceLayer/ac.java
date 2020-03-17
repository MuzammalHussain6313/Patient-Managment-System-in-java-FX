package UserInterfaceLayer;

import java.io.IOException;

import BusinessLogicLayer.Disease;
import BusinessLogicLayer.Doctor;
import BusinessLogicLayer.Patient;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.*;

public class ac extends Application
{

    @FXML
    private MenuItem addNewpatient;
    @FXML
    private MenuItem AddNewDoctor;
    @FXML
    private MenuItem AddNewDisease;
    @FXML
    private MenuItem deletePatientRecord;
    @FXML
    private MenuItem updatePatient;
    @FXML
    private MenuItem updateDoctor;
    @FXML
    private MenuItem searchPatientByName;
    @FXML
    private MenuItem searchPatientByID;
    @FXML
    private MenuItem searchPatientByAge;
    @FXML
    private MenuItem searchPatientByDisease;
    @FXML
    private MenuItem searchPatientByDoctor;
    @FXML
    private MenuItem searchDoctorByName;
    @FXML
    private MenuItem searchDoctorByDiseaseSpacialization;
    @FXML
    private MenuItem aboutUS;
    @FXML
    private MenuItem changePassword;
    @FXML
    private Button AddNewPatient;
    @FXML
    public static AnchorPane mainAnchorPane;
    @FXML
    private AnchorPane smallAnchorPane;
    @FXML
    private Button addNewDoctor;
    @FXML
    private Button print;

    @FXML
    private MenuItem menueSearchPatientRocord;
    @FXML
    private Button ButtonsearchPatientRecord;
    @FXML
    private TableView<Doctor> doctorDB;
    @FXML
    private TableColumn<Doctor, Integer> doctorID;
    @FXML
    private TableColumn<Doctor, String> doctorName;
    @FXML
    private TableColumn<Disease, Integer> diseaseID;
    @FXML
    private TableView<Patient> patientDB;
    @FXML
    private TableColumn<Patient, Integer> id;
    @FXML
    private TableColumn<Patient, String> name;
    @FXML
    private TableColumn<Patient, String> FatherName;
    @FXML
    private TableColumn<Patient, String> gender;
    @FXML
    private TableColumn<Patient, String> DOB;
    @FXML
    private TableColumn<Patient, String> diseasehistory;
    @FXML
    private TableColumn<Patient, String> prescription;
    @FXML
    private TableView<Disease> diseaseDB;
    @FXML
    private TableColumn<Disease, String> diseaseName;
    @FXML
    private TableColumn<Disease, String> diseasediscription;

    @FXML
    private void addNewPatient(ActionEvent event) throws IOException
    {
	try
	{
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("NewPatient.fxml"));
	    Parent root = (Parent) loader.load();
	    Stage stage = new Stage();
	    stage.setScene(new Scene(root));
	    stage.show();
	} catch (Exception e)
	{
	    System.err.println(e.getClass().getName() + ": " + e.getMessage());
	    System.out.println("Exception occured.");
	}
    }

    public static void run()
    {

    }

    @FXML
    void searchPatientButton(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("searchPatientRecord.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void addNewDoctorButton(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("AddNewDoctor.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void searchPatient(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("searchPatientRecord.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void addNewDoctor(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("AddNewDoctor.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void addNewDisease(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("AddNewDisease.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void deletePatient(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("deletePatientRecord.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void searchPatientByAge(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("searchPatientByAge.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void searchPatientByDisease(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("searchPatientByDisease.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void searchPatientByDoctor(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("searchPatientByDoctorName.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void searchDoctorByName(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("searchDoctorByName.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void searchDoctorByDiseaseSpacialization(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("searchDoctorByDiseaseName.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void aboutUS(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("aboutUS.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void changePassword(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("changePassword.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void searchPatientByID(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("searchPatientByID.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void searchPatientByName(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("searchPatientByname.fxml"));
	smallAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void Print(ActionEvent event)
    {
	JOptionPane.showMessageDialog(null, "Printer not connected to your PC.\nPlease Connect Printer first");
    }

    @FXML
    private void updatePatient(ActionEvent event)
    {

    }

    @FXML
    private void updateDoctor(ActionEvent event)
    {
        diseaseID.setCellValueFactory(new PropertyValueFactory<>("id"));
        diseaseName.setCellValueFactory(new PropertyValueFactory<>("name"));
        diseasediscription.setCellValueFactory(new PropertyValueFactory<>("discription"));
        Disease d = new Disease(1,"rtyuio", "dtyui");
        Disease d1 = new Disease(2,"rtyuio", "dtyui");
        Disease d2 = new Disease(3,"rtyuio", "dtyui");
        Disease d3 = new Disease(4,"rtyuio", "dtyui");
        Disease d4 = new Disease(5,"rtyuio", "dtyui");
        ObservableList<Disease> dbTypeList = FXCollections.observableArrayList();
        dbTypeList.add(d1);
        dbTypeList.add(d2);
        diseaseDB.setItems(dbTypeList);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
	try
	{
	    AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin.fxml"));
	    mainAnchorPane.getChildren().setAll(pane);
	    Scene scene = new Scene(mainAnchorPane);
	    Stage stage = new Stage();
	    stage.setScene(scene);
	    stage.show();
	} catch (Exception e)
	{
	    System.err.println(e.getClass().getName() + ": " + e.getMessage());
	    System.out.println("Exception occured.");
	}
    }
}
