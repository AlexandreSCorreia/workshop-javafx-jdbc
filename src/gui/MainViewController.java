package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Program;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;

	@FXML
	private MenuItem menuItemDepartment;

	@FXML
	private MenuItem menuItemAbout;

	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}

	@FXML
	public void onMenuItemDepartmentAction() {
		loadView( "/gui/DepartmentList.fxml");
	}

	@FXML
	public void onMenuItemAboutAction() {
		loadView( "/gui/AboutView.fxml");
	}

	private synchronized void loadView(String absoluteName) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Program.getScene();
			//Pegando uma referencipara o VBOX dentro do SCROLLPANE
			VBox mainVBox = (VBox)((ScrollPane) mainScene.getRoot()).getContent(); 
			//Capturando o menu para manter ele
			Node mainMenu = mainVBox.getChildren().get(0);
			//Limpando o vbox
			mainVBox.getChildren().clear();
			//adicionando o menu
			mainVBox.getChildren().add(mainMenu);
			//adicionando uma coleção que será os filhos do newVBox
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view ", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

}
