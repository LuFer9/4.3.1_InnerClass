/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innerclass_planning4.pkg3.pkg1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Luis
 */
public class InnerClass_Planning431 extends Application {
   
    
    private Circle circle;
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        
        //Elegimos el layout
        BorderPane root = new BorderPane();
        
        //determinamos la escena
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("InnerClass");
        primaryStage.setScene(scene);
        
        
        //creamos el circulo a agrandar o enpequeñecer
        circle = new Circle(50, Color.web("black", 0.05));
        circle.setStroke(Color.web("black", 1));
        
        //Añadimos el circulo a la ventana
        root.setCenter(circle);
        
        //creamos un contenedor para los botones
        HBox contenedor_btn = new HBox(10);
        root.setBottom(contenedor_btn);
        
        
        //Creamos los botones y le damos los eventos correspondientes
        Button btn_Shrink = new Button();
        btn_Shrink.setText("Shrink");
        btn_Shrink.setOnAction(new ShrinkHandler());
        
        
        Button btn_enlarge = new Button();
        btn_enlarge.setText("Enlarge");
        btn_enlarge.setOnAction(new EnlargeHandler());
        
        
        //Añadimos los botones al contenedor HBOX
        contenedor_btn.getChildren().addAll(btn_enlarge, btn_Shrink);
        
        //Le decimos la posicion dentro del HBox
        contenedor_btn.setAlignment(Pos.CENTER);
       
        primaryStage.show();
    }
    
    
    //clase evento para agrandar el circulo
    private class EnlargeHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            circle.setRadius(circle.getRadius() + 5);
        }   
    }
    
    
    
    //clase evento para minimizar el circulo
    private class ShrinkHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            
             circle.setRadius(circle.getRadius() - 5);
        }   
    }  
    
}




