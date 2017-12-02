/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
public class ReportController implements Initializable {

    @FXML
    private Label username;
    @FXML
    private Label id_pembeli;
    @FXML
    private Label almt;
    @FXML
    private Label size;
    @FXML
    private Label jml;
    @FXML
    private Label ttl;
    @FXML
    private Label nmrrec;
    @FXML
    private Label nama;
    
    
    @FXML
    private Label idbrg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          
    }

    public void Hasil(int id_barang, int id_pelanggan, int total, int Jml, int Size) {
       int hasil = 0, hasil2=0 , hasil3=0, hasil4=0;
        
        String Nama = data.getUsername();
        username.setText(""+Nama);
        id_pembeli.setText(""+id_pelanggan);
        String Alamat = data.getAlamat();
        almt.setText(""+Alamat);
        idbrg.setText(""+id_barang);
        size.setText(""+Size);
        jml.setText(""+Jml);
        ttl.setText(""+total);
        nama.setText(""+Nama);
        
        Random tian = new Random();
         int a[];
        a = new int[1000];
        for (int i=0; i<a.length; i++)
         hasil = tian.nextInt(1000);
        for (int i=0; i<a.length; i++)
         hasil2 = tian.nextInt(100);
        for (int i=0; i<a.length; i++)
         hasil3 = tian.nextInt(10000000);
        for (int i=0; i<a.length; i++)
         hasil4 = tian.nextInt(9);
        nmrrec.setText(""+hasil+"-"+hasil2+"-"+hasil3+"-"+hasil4);
        
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
       ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/User/HalamanUtama.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),790,441);
            
            
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("-----");
            stage.show();
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
         ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/User/HalamanUtama.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),790,441);
            
            
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("-----");
            stage.show();
    }
    
}
