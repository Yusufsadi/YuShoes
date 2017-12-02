/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Halaman;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Yusuf
 */
public class UserDetails {

    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty alamat;
    private final StringProperty id;

    public UserDetails(String username, String password, String alamat, String id) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.alamat = new SimpleStringProperty(alamat);
        this.id = new SimpleStringProperty(id);

    }

    public String getUsername() {
        return username.get();
    }

    public String getPassword() {
        return password.get();
    }

    public String getAlamat() {
        return alamat.get();
    }
   
    public String getid() {
        return id.get();
    }

    public void setUsername(String value) {
        username.set(value);
    }

    public void setPassword(String value) {
        password.set(value);
    }

    public void setAlamat(String value) {
        alamat.set(value);
    }
    
     public void setid(String value) {
        id.set(value);
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty alamatProperty() {
        return alamat;
    }
    
    public StringProperty idProperty() {
        return id;
    }

}
