package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("victorwinberg - JavaFX");
		
		Scene sceneLogin = getLoginScene();
		
		Scene mainScene = getMainScene(sceneLogin);

		Scene sceneWelcome = getWelcomeScene(mainScene);
		
		window.setScene(sceneWelcome);
		window.setTitle("This is the JavaFX window");
		window.show();
	}

	private Scene getWelcomeScene(Scene nextScene) {
		// Main scene
		Label label = new Label("Welcome to Victor Winberg's JavaFX");
		Button button = new Button("Go to scene 2");
		button.setOnAction(e -> window.setScene(nextScene));
		
		//Layout - children are laid out in vertical column
		VBox layout = new VBox(20);
		layout.getChildren().addAll(label, button);
		layout.setAlignment(Pos.CENTER);
		return new Scene(layout, 300, 200);
	}

	private Scene getMainScene(Scene loginScene) {
		//Button
		Button alertButton = new Button("Click me!");
		alertButton.setOnAction(e -> AlertBox.display("AlertTitle", "This is a cool alert box"));
		
		Button loginButton = new Button("Login");
		loginButton.setOnAction(e -> window.setScene(loginScene));
		
		//Layout
		VBox layout = new VBox();
		layout.getChildren().addAll(alertButton, loginButton);
		layout.setAlignment(Pos.CENTER);
		return new Scene(layout, 600, 600);
	}

	private Scene getLoginScene() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		// Username
		Label nameLabel = new Label("Username: ");
		GridPane.setConstraints(nameLabel, 0, 0);
		
		TextField nameField = new TextField("Victor");
		GridPane.setConstraints(nameField, 1, 0);
		
		// Password
		Label passLabel = new Label("Password: ");
		GridPane.setConstraints(passLabel, 0, 1);
		
		TextField passField = new TextField();
		passField.setPromptText("type a password");
		GridPane.setConstraints(passField, 1, 1);
		
		// Login button
		Button loginButton = new Button("Log in");
		GridPane.setConstraints(loginButton, 1, 2);
		
		grid.getChildren().addAll(nameLabel, nameField, passLabel, passField, loginButton);
		
		return new Scene(grid, 300, 200);
	}
	
}