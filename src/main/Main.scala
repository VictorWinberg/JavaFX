package main

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.EventHandler
import javafx.event.ActionEvent

class ScalaMain extends Application {
  
	val button = new Button("Click me!")
  
	override def start(primaryStage: Stage) = {
    primaryStage.setTitle("JavaFX with Scala")
    
    button.setOnAction(new EventHandler[ActionEvent]() {
      override def handle(action: ActionEvent) = println("Scale me!")
    })
    
    val layout = new StackPane()
    layout.getChildren.add(button)
    
    val scene = new Scene(layout, 300, 250)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}

object ScalaMain {
  def main(args: Array[String]) = Application.launch(classOf[ScalaMain], args: _*)
}