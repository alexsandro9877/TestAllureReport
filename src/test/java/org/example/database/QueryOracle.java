package org.example.database;

import java.sql.Connection;
import java.sql.SQLException;
public class QueryOracle  {


    public void deveverobanco(){

        Connection connection = OracleConnection.connectionOracleHlg();

        if (connection != null) {
            System.out.println("Conexão com o Oracle bem-sucedida!");

            try {
                connection.close(); // Feche a conexão quando não for mais necessária.
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Falha na conexão com o Oracle.");
        }

    }



}

