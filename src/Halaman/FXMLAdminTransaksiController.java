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

/**
 * FXML Controller class
 *
 * @author Yusuf
 */
public class FXMLAdminTransaksiController implements Initializable {

    @FXML
    private TableView<TransaksiDetails> tabel;
    @FXML
    private TableColumn<TransaksiDetails, String> columID;
    @FXML
    private TableColumn<TransaksiDetails, String> columID_Pelanggan;
    @FXML
    private TableColumn<TransaksiDetails, String> columID_Barang;
    @FXML
    private TableColumn<TransaksiDetails, String> columTotal;
    @FXML
    private TableColumn<TransaksiDetails, String> columJumlah_Barang;
    @FXML
    private TableColumn<TransaksiDetails, String> columDate;
    @FXML
    private JFXButton btnLoad;
    
    private ObservableList<TransaksiDetails> data;
    private DBConnection dc;
    @FXML
    private JFXTextField pencari;

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

            ResultSet rs = conn.createStatement().executeQuery("select * from transaksi");

            while (rs.next()) {
                data.add(new TransaksiDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }

        } catch (SQLException ex) {
           System.out.println("Erorr"+ex);
           
        }
        columID.setCellValueFactory(new PropertyValueFactory<>("id_transaksi"));
        columID_Pelanggan.setCellValueFactory(new PropertyValueFactory<>("id_pelanggan"));
        columID_Barang.setCellValueFactory(new PropertyValueFactory<>("id_barang"));
        columTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        columJumlah_Barang.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        columDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        
        tabel.setItems(null);
        tabel.setItems(data);
        
    }

    @FXML
    private void backhome(ActionEvent event) throws IOException {
         // Hide this current window (if this is what you want)
                    ((Node)(event.getSource())).getScene().getWindow().hide();

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

            ResultSet rs = conn.createStatement().executeQuery("select * from transaksi WHERE id_barang LIKE '"+pencari.getText()+"%'");

            while (rs.next()) {
                data.add(new TransaksiDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }

        } catch (SQLException ex) {
           System.out.println("Erorr"+ex);
           
        }
        columID.setCellValueFactory(new PropertyValueFactory<>("id_transaksi"));
        columID_Pelanggan.setCellValueFactory(new PropertyValueFactory<>("id_pelanggan"));
        columID_Barang.setCellValueFactory(new PropertyValueFactory<>("id_barang"));
        columTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        columJumlah_Barang.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        columDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        
        tabel.setItems(null);
        tabel.setItems(data);
    }
    
}
