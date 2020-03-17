package UserInterfaceLayer;

import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicLayer.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import persistenceLayer.PatientDatabase;

import javax.swing.JOptionPane;

public class DeletePatientRecordController implements Initializable
{
    @FXML
    private TextField patientName;

    @FXML
    private TextField fathername;
    @FXML
    private Label errorLable;
    @FXML
    private Button deletePatientRecord;
    @FXML
    private Button cancelDelection;

    @FXML
    private void deletePatient(ActionEvent event)
    {
        Patient patient = new Patient();
        patient.setName(patientName.getText());
        patient.setFatherName(fathername.getText());
        PatientDatabase patientDatabase = new PatientDatabase();
        patientDatabase.deletePatient(patient);
        errorLable.setText("");
        patientName.setText("");
        fathername.setText("");
    }

    @FXML
    private void cancelPationDeletion(ActionEvent event)
    {
        patientName.setText("");
        fathername.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
	// TODO
    }

    public void searchPatientRecord(ActionEvent actionEvent) {
    }
}
