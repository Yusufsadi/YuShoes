/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import tokosepatu.data;

/**
 * FXML Controller class
 *
 * @author Yusuf
 */
public class FXMLHalamanUtamaController implements Initializable {

    @FXML
    private Label idd;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int id_pelanggan = data.getId_Pelanggan();
        idd.setText(""+id_pelanggan);
    }    

    @FXML
    private void simt(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();

                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/Details/Details6.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(),700,436);

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("-----");
                    stage.show();
    }

    @FXML
    private void nmd(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();

                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/Details/Details5.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(),700,436);

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("-----");
                    stage.show();
    }

    @FXML
    private void eqt(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();

                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/Details/Details4.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(),700,436);

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("-----");
                    stage.show();
    }

    @FXML
    private void jrd(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();

                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/Details/Details3.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(),700,436);

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("-----");
                    stage.show();
    }

    @FXML
    private void vansk(ActionEvent event) throws IOException {
       ((Node)(event.getSource())).getScene().getWindow().hide();

                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/Details/Details2.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(),700,436);

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("-----");
                    stage.show();
    }

    @FXML
    private void vansp(ActionEvent event) throws IOException { 
        ((Node)(event.getSource())).getScene().getWindow().hide();

                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/Details/Details1.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(),700,432);

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("-----");
                    stage.show();
    }

    @FXML
    private void out(ActionEvent event) throws IOException {
        
     ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/tokosepatu/FXMLLogin.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),833,464);
            
             
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("-----");
            stage.show();
    }
    
}
