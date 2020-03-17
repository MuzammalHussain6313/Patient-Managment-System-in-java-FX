package UserInterfaceLayer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class AboutUSController implements Initializable
{

    private Label lable;
    @FXML
    private TextArea text;
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

	String n = new String("In addition to offering traditional and established\n"
		+ "medical care services, Strong is distinguished\n"
		+ "with its tertiary and quaternary services. This\n"
		+ "means Strong has the personnel and facilities\n"
		+ "to provide advanced medical inquiry and treatments\n"
		+ "that are not widely accessible in this region.");
	text.setText(n);
	text.setEditable(false);
    }

}
