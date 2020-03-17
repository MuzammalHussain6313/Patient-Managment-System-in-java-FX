package UserInterfaceLayer;

import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicLayer.Disease;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import persistenceLayer.DiseaseDatabase;

public class AddNewDiseaseController implements Initializable
{

    @FXML
    private Button cancel;
    @FXML
    private Label successLable;
    @FXML
    private TextField diseaseName;

    @FXML
    private Button addNewDisease;
    @FXML
    private TextField discription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
	// TODO
    }

    public void addNewDisease(ActionEvent actionEvent) {
        Disease disease = new Disease(diseaseName.getText(),discription.getText());
        DiseaseDatabase diseaseDatabase = new DiseaseDatabase();
        diseaseDatabase.insertDisease(disease);
        successLable.setText("Disease Inserted successfully in database");
    }

    public void cancelDiseaseInsertion(ActionEvent actionEvent)
    {
        diseaseName.setText("");
    }
}
