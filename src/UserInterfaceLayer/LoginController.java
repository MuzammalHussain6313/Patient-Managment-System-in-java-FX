package UserInterfaceLayer;

import BusinessLogicLayer.User;
import javafx.collections.FXCollections;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import persistenceLayer.UserAuthentication;

public class LoginController implements Initializable
{

    @FXML
    private Label Name;
    @FXML
    private Label Name1;
    @FXML
    private Label Name11;
    @FXML
    private Button signin;
    @FXML
    private Button SignUP;
    @FXML
    private ComboBox<String> userType;
	@FXML
	private PasswordField password;
    private final ObservableList<String> dbTypeList = FXCollections.observableArrayList("Admin", "Guest");
    @FXML
    private TextField user;
    @FXML
    private AnchorPane mainAnchorPane;
    @FXML
    private Label forgetPassword;

    @FXML
    private void forgetPassword(MouseEvent event)
    {
	try
	{
	    AnchorPane pane = FXMLLoader.load(getClass().getResource("forgetPassword.fxml"));
	    mainAnchorPane.getChildren().setAll(pane);
	} catch (Exception e)
	{
	    System.err.println(e.getClass().getName() + ": " + e.getMessage());
	    System.out.println("Exception occured.");
	}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
	userType.setItems(dbTypeList);

    }

//    @FXML
//    private void forgetPassword(MouseEvent event) throws IOException
//    {
//	AnchorPane pane = FXMLLoader.load(getClass().getResource("forgatPassword.fxml"));
//	mainAnchorPane.getChildren().setAll(pane);
//    }
    @FXML
    private void loginUser(ActionEvent event) throws IOException
    {
//	if (this.athenticateAdminUser() == false)
//	{
//	    user.setPromptText("Enter Admin user name");
//	    password.setPromptText("Enter password");
//	    Parent file = FXMLLoader.load(getClass().getResource("Admin.fxml"));
//	    Scene scene = new Scene(file);
//	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//	    stage.setScene(scene);
//	    stage.show();
//	}
//	if(this.athenticateGuestUser() == true)
//	{
		user.setPromptText("Enter Guest user name");
		password.setPromptText("Enter password");
	    Parent file = FXMLLoader.load(getClass().getResource("Admin.fxml"));
	    Scene scene = new Scene(file);
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	    stage.show();
	//}
    }
    public boolean athenticateAdminUser()
	{
		User loginUser = new User();
		loginUser.setUserName(user.getText());
		loginUser.setPassword(password.getText());
		loginUser.setType(userType.getValue());
		UserAuthentication userAuthentication = new UserAuthentication();
		boolean b = userAuthentication.checkAdminUser(loginUser);
		return b;
	}
	public boolean athenticateGuestUser()
	{
		User loginUser = new User();
		loginUser.setUserName(user.getText());
		loginUser.setPassword(password.getText());
		loginUser.setType(userType.getValue());
		UserAuthentication userAuthentication = new UserAuthentication();
		boolean b = userAuthentication.checkGuestUser(loginUser);
		return b;
	}
//    @FXML
//    public String selectType()
//    {
//	String admin = "Admin";
//	String guest = "Guest";
//	if (userType.getValue().equals("Admin"))
//	{
//	    user.setPromptText("Enter Admin user name");
//	    return admin;
//	}
//	else
//	{
//	    user.setPromptText("Enter guest user name");
//	    return guest;
//	}
//    }

    @FXML
    private void createNewUser(ActionEvent event) throws IOException
    {
	AnchorPane pane = FXMLLoader.load(getClass().getResource("signUP.fxml"));
	mainAnchorPane.getChildren().setAll(pane);

    }

}
