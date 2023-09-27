package org.example.database;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
@Slf4j
public class OracleConnection {

    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String url = "jdbc:oracle:thin:@des4-scan.cbd.root.gpa:1521/hom4.cbd.root.gpa";
    private static String user = "PV01";
    private static String password = "JD19HOM#gpa19";

    public static Connection connectionOracleHlg() {
        Connection conexao = null;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
           // System.out.println(System.getProperty("java.class.path"));
            System.out.println("ClassNotFound...");
            e.printStackTrace();
        }
        return conexao;
    }

    private OracleConnection() { throw new IllegalStateException("Utility class"); }

}
