/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Halaman;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tokosepatu.Config;

/**
 * FXML Controller class
 *
 * @author Yusuf
 */
public class FXMLAdminBarangController implements Initializable {

    @FXML
    private TableView<BarangDetails> tabel;
    @FXML
    private TableColumn<BarangDetails, String> columID;
    @FXML
    private TableColumn<BarangDetails, String> columNama_Barang;
    @FXML
    private TableColumn<BarangDetails, String> columStock;
    @FXML
    private TableColumn<BarangDetails, String> columHarga;
    @FXML
    private JFXButton btnLoad;

    private ObservableList<BarangDetails> data;
    private DBConnection dc;
    @FXML
    private JFXTextField pencari;
    @FXML
    private JFXTextField Aidi;
     
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dc = new DBConnection();
    }

    @FXML
    private void loadDataFromDatabase(ActionEvent event) {

        try {
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("select * from barang");

            while (rs.next()) {
                data.add(new BarangDetails(rs.getString(4), rs.getString(3), rs.getString(2), rs.getString(1)));
            }

        } catch (SQLException ex) {
            System.out.println("Erorr" + ex);

        }
        columID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columNama_Barang.setCellValueFactory(new PropertyValueFactory<>("nama_barang"));
        columStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        columHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));

        tabel.setItems(null);
        tabel.setItems(data);
    }

    @FXML
    private void backhome(ActionEvent event) throws IOException {
        // Hide this current window (if this is what you want)
        ((Node) (event.getSource())).getScene().getWindow().hide();

        // Load the new fxml
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXMLAdminUtama.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),853,483);

        // Create new stage (window), then set the new Scene
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("-----");
        stage.show();
    }

    @FXML
    private void cari(ActionEvent event) {

        try {
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("select * from barang WHERE nama_barang LIKE '" + pencari.getText() + "%'");

            while (rs.next()) {
                data.add(new BarangDetails(rs.getString(4), rs.getString(3), rs.getString(2), rs.getString(1)));
            }

        } catch (SQLException ex) {
            System.out.println("Erorr" + ex);

        }
        columID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columNama_Barang.setCellValueFactory(new PropertyValueFactory<>("nama_barang"));
        columStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        columHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));

        tabel.setItems(null);
        tabel.setItems(data);
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
      String Id;
     String nm;
     String stck;
     String hrg; 
      

                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("FXMLedit.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(),450,315);

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("-----");
                    stage.show();
                    
                    FXMLeditController a = fxmlLoader.getController();
                    
        try {
         
            java.sql.Connection conn=(Connection)Config.configDB();
            String sql = "select * from barang where id_barang = "+Aidi.getText()+"";
            
            ResultSet rs = conn.createStatement().executeQuery(sql);
           
       
            while (rs.next()) {
              
                String nama= rs.getString("nama_barang");
                String stock= rs.getString("stock");
                String harga= rs.getString("harga");
               
               
                nm=(nama);
                 stck=(stock);
                 hrg =(harga); 
                 
             a.passing(Aidi.getText(),nm ,stck ,hrg);
            }
             
        } catch (SQLException ex) {
            System.out.println("Erorr" + ex);

        }
                 
        
        
                    
            
                    // Create new stage (window), then set the new Scene
            
           
    }

    @FXML
    private void Delete(ActionEvent event) {
        
        try {
           Connection connn = dc.Connect();
            data = FXCollections.observableArrayList();
            
           String sql = "delete from barang where id_barang = "+Aidi.getText()+"";
            java.sql.Connection conn=(com.mysql.jdbc.Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
            
             ResultSet rs = connn.createStatement().executeQuery("select * from barang");

            while (rs.next()) {
                data.add(new BarangDetails(rs.getString(4), rs.getString(3), rs.getString(2), rs.getString(1)));
            }
           

        } catch (SQLException ex) {
            System.out.println("Erorr" + ex);

        }
        columID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columNama_Barang.setCellValueFactory(new PropertyValueFactory<>("nama_barang"));
        columStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        columHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));

        tabel.setItems(null);
        tabel.setItems(data);
    }

}
