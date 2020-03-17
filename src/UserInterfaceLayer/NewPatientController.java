package UserInterfaceLayer;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import BusinessLogicLayer.Doctor;
import BusinessLogicLayer.Patient;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import persistenceLayer.DiseaseDatabase;
import persistenceLayer.DoctorDatabase;
import persistenceLayer.PatientDatabase;

public class NewPatientController implements Initializable
{
    @FXML
    private TextArea diseaseHistory;

    @FXML
    private TextArea discription;

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField fatherName;

    @FXML
    private DatePicker datePikker;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private ComboBox<String> selectDoctor;
    @FXML
    private Button savebutton;
    @FXML
    private Button cancelButton;
//    @FXML
//    private ComboBox<String> selectDoctor1;
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        PatientDatabase patientDatabase = new PatientDatabase();
        id.setText(Integer.toString(patientDatabase.getPatientID()));
        DoctorDatabase doctorDatabase = new DoctorDatabase();
        ObservableList<String> dbTypeList = FXCollections.observableArrayList(doctorDatabase.doctorList());
        selectDoctor.setItems(dbTypeList);
    }
    public void saveData(ActionEvent actionEvent) {
        Patient patient = new Patient();
        patient.setName(name.getText());
        patient.setFatherName(fatherName.getText());
        patient.setGender(this.getGender());
        patient.setDateOfBirth(this.getdate());
        Doctor doctor = new Doctor();
        doctor.setName(this.selectDoctor());
        patient.setDoctor(doctor);
        patient.setDiseaseHistory(diseaseHistory.getText());
        patient.setPrescription(discription.getText());
        PatientDatabase patientDatabase = new PatientDatabase();
        patientDatabase.insertPatient(patient);
        System.out.println(this.getGender());

    }

    public void cancel(ActionEvent actionEvent) {

        this.selectDoctor();
        this.getdate();
    }
    public String selectDoctor()
    {
        return selectDoctor.getValue();
    }
    public java.sql.Date getdate() {
        LocalDate date = datePikker.getValue();
        java.sql.Date d = null;
        if (date != null) {
            //System.out.println(date);
            System.out.println(date.toString());
            d = java.sql.Date.valueOf(date);
            System.out.println(d.toString());
            //Date datee = Date.valueOf(date);
            //java.util.Date datee = (java.util.Date) datePikker.getModel().getValue();
            //java.sql.Date sqlDate = new java.sql.Date(datee.getTime());
//            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
//            df.format(date);
//            System.out.println(date);
        }
        return d;
    }
    public String getGender()
    {
        ToggleGroup group = new ToggleGroup();
        male.setUserData("Male");
        male.setToggleGroup(group);
        male.setSelected(true);
        female.setUserData("Female");
        female.setToggleGroup(group);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    String selected = group.getSelectedToggle().getUserData().toString();
                }
            }
        });
        return group.getSelectedToggle().getUserData().toString();
    }
}
