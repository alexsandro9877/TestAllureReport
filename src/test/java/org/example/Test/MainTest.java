package org.example.Test;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.put;


class MainTest {

    public String valor ;
public  static void setUp() throws IOException {
    String vaslor;
    InputStream inStream = MainTest.class.getClassLoader().getResourceAsStream("config.properties");
    Properties prop = new Properties();
    prop.load(inStream);
    prop.getProperty("test");
    vaslor = prop.getProperty("test");
}

@Test
    public void testUnit (){



    System.out.println(valor);


    }
    public Map<String, String> RetornaValor(){
    int valor1 = 10;
    Map<String , String> valor = new  HashMap<>();

    valor.put("test1","test1");
    valor.put("test2","test2");
    valor.put("test3", String.valueOf(valor1));

        return valor;
}


}
