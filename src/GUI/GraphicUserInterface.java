package GUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GraphicUserInterface extends Application{
	private Stage primaryStage;
	private BorderPane mainLayout;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.primaryStage = stage;
		this.primaryStage.setTitle("Mobile Web Automation");
		
		showMainView();
	}

	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GraphicUserInterface.class.getResource("GUIManager.fxml"));
		mainLayout = loader.load();
		
		Scene scene = new Scene(mainLayout);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}