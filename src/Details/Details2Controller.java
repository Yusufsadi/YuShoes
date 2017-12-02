/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;

import Report.ReportController;
import com.jfoenix.controls.JFXRadioButton;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tokosepatu.Config;
import tokosepatu.data;

/**
 * FXML Controller class
 *
 * @author Yusuf
 */
public class Details2Controller implements Initializable {

    @FXML
    private JFXRadioButton b40;
    @FXML
    private ToggleGroup Size;
    @FXML
    private JFXRadioButton b41;
    @FXML
    private JFXRadioButton b42;
    @FXML
    private JFXRadioButton b43;
    @FXML
    private JFXRadioButton b44;
    @FXML
    private JFXRadioButton b45;
    @FXML
    private JFXRadioButton b46;
    @FXML
    private JFXRadioButton j1;
    @FXML
    private ToggleGroup Jml;
    @FXML
    private JFXRadioButton j2;
    @FXML
    private JFXRadioButton j3;
    @FXML
    private JFXRadioButton j4;
    @FXML
    private JFXRadioButton j5;
    @FXML
    private JFXRadioButton j6;
    @FXML
    private JFXRadioButton j7;
    @FXML
    private JFXRadioButton j8;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buy(ActionEvent event) throws IOException {
        int Size = 0;
        
         
        if (b40.isSelected()){
            Size = 40;
        }
        else if (b41.isSelected()){
            Size = 41;
        }
        else if (b42.isSelected()){
            Size = 42;
        }
        else if (b43.isSelected()){
            Size = 43;
        }
        else if (b44.isSelected()){
            Size = 44;
        }
        else if (b45.isSelected()){
            Size = 45;
        }
        else if (b46.isSelected()){
            Size = 46;
        }
        
        
         int Jml = 0;
        
        if (j1.isSelected()){
            Jml = 1;
        }
        else if (j2.isSelected()){
            Jml = 2;
        }
        else if (j3.isSelected()){
            Jml = 3;
        }
        else if (j4.isSelected()){
            Jml = 4;
        }
        else if (j5.isSelected()){
            Jml = 5;
        }
        else if (j6.isSelected()){
            Jml = 6;
        }
        else if (j7.isSelected()){
            Jml = 7;
        }
        else if (j8.isSelected()){
            Jml = 8;
        }
        
        
        
            int total;
             total = 2000000 * Jml;
             
              int id_pelanggan = data.getId_Pelanggan(); 
             int id_barang  = 3;
         if(Size== 0 || Jml==0){
         JOptionPane.showMessageDialog(null, "Input your Size and  Jumlah barang");
        }
         else if(Size== 0 ){
            JOptionPane.showMessageDialog(null, "Input your Size ");
        }
         else if( Jml==0){
            JOptionPane.showMessageDialog(null, "Input  Jumlah barang");
        }
         else{
        try {
            String sql = "INSERT INTO `transaksi`(`id_pelanggann`, `id_barang`, `total`, `Jumlah_barang`) VALUES('"+id_pelanggan+"', '"+id_barang+"', '"+total+"','"+Jml+"')";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Transaksi Berhasil");
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Report/report.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),680,457);
            
             ReportController a = fxmlLoader.getController();
            a.Hasil(id_barang, id_pelanggan, total, Jml, Size );
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("-----");
            stage.show();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }}
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
    
}
