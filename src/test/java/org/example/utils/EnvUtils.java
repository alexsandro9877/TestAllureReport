package org.example.utils;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class EnvUtils {
    public static String getEnv() {
        //if (System.getProperty("env").length() > 0) {
            return "HLG";
        //} else {
            //log.error("A variável -Denv não está configurada corretamente em seus testes, considere revisar.");
        //    return "HLG";
        //}
    }
}
