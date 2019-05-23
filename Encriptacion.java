/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptacion;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Encriptacion extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Encriptacion");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Scene scene = new Scene(grid, 300, 250);
        
        Label etiqueta = new Label("Palabra"); 
        grid.add(etiqueta, 0, 1);
        TextField ingresarPalabra = new TextField();
        grid.add(ingresarPalabra, 1, 1);
        Button encriptar = new Button("Encriptar");
        grid.add(encriptar, 1, 2);
        Button desEncriptar = new Button("Desencriptar");
        grid.add(desEncriptar, 1, 3);
        Label resultado = new Label();
        grid.add(resultado, 1, 3);
        encriptar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                     byte[] palabra = ingresarPalabra.getText().getBytes();
                    String palabraEncriptada = Base64.getEncoder().encodeToString(palabra);
                    ingresarPalabra.setText(palabraEncriptada);
                
              
             
            }
        });
        desEncriptar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){                                              
                String palab = ingresarPalabra.getText();
                Base64.Decoder base = Base64.getDecoder();
                byte[] palabraa = base.decode(palab);
                String ingresar = new String(palabraa);
                ingresarPalabra.setText(ingresar);
                
            }
        });
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}