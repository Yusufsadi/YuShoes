/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokosepatu;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yusuf
 */
public class FXMLSigninController implements Initializable {

    @FXML
    private JFXTextField Username;
    @FXML
    private JFXPasswordField Password;
    @FXML
    private JFXButton SignIn;
    
     
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SignIn(ActionEvent event) throws IOException {
        koneksiuser db = new koneksiuser();
        
       Connection con;
        Statement stat;
        ResultSet rs;
        String sql;
        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = (Statement) DB.stm;
        
        String username1= "";
        String alamat = "";
       
        
        db.dbConnection();
        if(Username.getText().equals("") || Password.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Input your Username and Password");
        }
        else if(Username.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Input your Username ");
        }
        else if(Password.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Input your Password");
        }
        
        else{
         try {
           sql = "SELECT * FROM admin WHERE username='"+Username.getText()+"' AND password='"+Password.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(Username.getText().equals(rs.getString("username")) && Password.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "Berhasil Login");
                    // Hide this current window (if this is what you want)
                    ((Node)(event.getSource())).getScene().getWindow().hide();

                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/Halaman/FXMLAdminUtama.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(),853,483);

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("adminyu");
                    stage.show();
                }
            }else{
                try {
            sql = "SELECT * FROM pelanggan WHERE username = '" + Username.getText() + "' AND password = '" + Password.getText() + "'";
            java.sql.Statement st = db.getConnection().createStatement();
            ResultSet rsLogin = st.executeQuery(sql);

           
           while (rsLogin.next()) {
               
               username1= rsLogin.getString("username");
               alamat = rsLogin.getString("alamat");
            }
            rsLogin.last(); //mengecek jumlah baris pada hasil query
            if (rsLogin.getRow()==1){
                data.setId_pelanggan(rsLogin.getInt("id_pelanggan"));
                data.setUsername(username1);
                data.setAlamat(alamat);

                
                                
                JOptionPane.showMessageDialog(null, "Login Berhasil!");
                ((Node)(event.getSource())).getScene().getWindow().hide();
                // Load the new fxml
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/User/HalamanUtama.fxml"));
                Scene scene = new Scene(fxmlLoader.load(),785,437);
                // Create new stage (window), then set the new Scene
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setScene(scene);
                stage.setTitle("-------");
                stage.show();
            } else {
                
         JOptionPane.showMessageDialog(null, "Username Atau Password Salah !");
                
               
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
            }
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       
        
        }
        
        
        
           
            
        
    
    }

    @FXML
    private void Signup(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();

                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("FXMLSignUp.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(),833,515);

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("-----");
                    stage.show();
    }
    
}
