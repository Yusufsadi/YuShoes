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
public class BarangDetails {
    
    private final StringProperty id;
    private final StringProperty nama_barang;
    private final StringProperty stock;
    private final StringProperty harga;
    

    public BarangDetails(String harga, String stock, String nama_barang, String id) {
        this.id = new SimpleStringProperty(id);
        this.nama_barang = new SimpleStringProperty(nama_barang);
        this.stock = new SimpleStringProperty(stock);
        this.harga = new SimpleStringProperty(harga);
        

    }
    
    public String getid() {
        return id.get();
    }
    public String getNama_barang() {
        return nama_barang.get();
    }

    public String getStock() {
        return stock.get();
    }

    public String getHarga() {
        return harga.get();
    }
   
    

    public void setid(String value) {
        id.set(value);
    }
    public void setNama_barang(String value) {
        nama_barang.set(value);
    }

    public void setStock(String value) {
        stock.set(value);
    }

    public void setHarga(String value) {
        harga.set(value);
    }
    
     
    
    public StringProperty idProperty() {
        return id;
    }
    public StringProperty nama_barangProperty() {
        return nama_barang;
    }

    public StringProperty stockProperty() {
        return stock;
    }

    public StringProperty hargaProperty() {
        return harga;
    }
    
    

}
