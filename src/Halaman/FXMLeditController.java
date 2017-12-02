/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Halaman;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Halaman.BarangDetails;
import java.awt.HeadlessException;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tokosepatu.Config;

/**
 * FXML Controller class
 *
 * @author Yusuf
 */
public class FXMLeditController implements Initializable {

    @FXML
    private Label Id;
    @FXML
    private JFXTextField nm;
    @FXML
    private JFXTextField st;
    @FXML
    private JFXTextField hgr;
    
    @FXML
    private String cari;
    private DBConnection dc;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Update(ActionEvent event) throws IOException {
        
        try {
           
            String sql = "UPDATE barang SET nama_barang='"+nm.getText()+"',stock="+st.getText()+",Harga="+hgr.getText()+" where id_barang = "+Id.getText()+" ";
            java.sql.Connection conn=(com.mysql.jdbc.Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            
           
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

  

    void passing(String Cari, String nma, String stck, String harga) {
     Id.setText(Cari);
     nm.setText(nma);
     st.setText(stck);
     hgr.setText(harga);
    
      
    }
    
}
