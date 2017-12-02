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
public class TransaksiDetails {

    private final StringProperty id_transaksi;
    private final StringProperty id_pelanggan;
    private final StringProperty id_barang;
    private final StringProperty total;
    private final StringProperty jumlah;
    private final StringProperty date;

    public TransaksiDetails(String id_transkasi,String id_pelanggan, String id_barang, String total,String jumlah , String date) {
        this.id_transaksi = new SimpleStringProperty(id_transkasi);
        this.id_pelanggan = new SimpleStringProperty(id_pelanggan);
        this.id_barang = new SimpleStringProperty(id_barang);
        this.total = new SimpleStringProperty(total);
        this.jumlah = new SimpleStringProperty(jumlah);
        this.date = new SimpleStringProperty(date);

    }

    public String getId_transaksi() {
        return id_transaksi.get();
    }

    public String getId_pelanggan() {
        return id_pelanggan.get();
    }

    public String getId_barang() {
        return id_barang.get();
    }
   
    public String getTotal() {
        return total.get();
    }
    public String getJumlah() {
        return jumlah.get();
    }
   
    public String getDate() {
        return date.get();
    }
    
    
    
    public void setId_transaksi(String value) {
        id_transaksi.set(value);
    }

    public void setId_pelanggan(String value) {
        id_pelanggan.set(value);
    }

    public void setId_barang(String value) {
        id_barang.set(value);
    }
    
    public void setTotal(String value) {
        total.set(value);
    }
    public void setJumlah(String value) {
        jumlah.set(value);
    }
    public void setDate(String value) {
        date.set(value);
    }

    
    public StringProperty id_transaksiProperty() {
        return id_transaksi;
    }

    public StringProperty id_pelangganProperty() {
        return id_pelanggan;
    }

    public StringProperty id_barangProperty() {
        return id_barang;
    }
    
    public StringProperty totalProperty() {
        return total;
    }
    public StringProperty jumlahProperty() {
        return jumlah;
    }
    public StringProperty dateProperty() {
        return date;
    }

}
