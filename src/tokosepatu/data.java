/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokosepatu;

import java.time.LocalDate;

/**
 *
 * @author yusuf
 */
public class data {

    private static int id_pelanggan;
    private static String username;
    private static String alamat;
    
    public static int getId_Pelanggan() {
        return id_pelanggan;
    }
    public static String getUsername() {
        return username;
    }
    public static String getAlamat() {
        return alamat;
    }
    

    public static void setId_pelanggan(int id_pelanggan) {
        data.id_pelanggan = id_pelanggan;
    }
    public static void setUsername(String username) {
        data.username = username;
    }
    public static void setAlamat(String alamat) {
        data.alamat = alamat;
    }

}