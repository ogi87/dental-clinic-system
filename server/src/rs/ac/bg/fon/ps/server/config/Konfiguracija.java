/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.server.config;

/**
 *
 * @author ognje
 */
import java.io.FileInputStream;
import java.util.Properties;

public class Konfiguracija {
    
    private static Konfiguracija instance;
    private Properties properties;

    private Konfiguracija() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Konfiguracija getInstance() {
        if (instance == null) {
            instance = new Konfiguracija();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key, "n/a");
    }
}
