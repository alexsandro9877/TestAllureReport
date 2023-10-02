package org.example.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class test {



    public  static void main(String[] args){

        System.out.println(RetornaItesn());

    }

    public static List<Map<String, Object>> RetornaItesn() {
        List<Map<String, Object>> itemList = readNumbersAndGenerateItems("C:\\Users\\alexl\\Music\\gpa-digital-api-test\\topgun\\src\\test\\resources\\tests.txt");
        return itemList;
    }

    private static List<Map<String, Object>> readNumbersAndGenerateItems(String fileName) {
        List<Map<String, Object>> itemList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Linha lida do arquivo: " + line);
                // Remove os caracteres de "{" e "}" e divide os números pela vírgula.
                String[] numberStrings = line.replaceAll("[{}]", "").split(",");
                for (String numberString : numberStrings) {
                    int number = Integer.parseInt(numberString.trim());
                    Map<String, Object> item = generateItem(number);
                    itemList.add(item);
                    System.out.println("Número adicionado à lista: " + number);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }


    private static Map<String, Object> generateItem(Integer number) {
        Map<String, Object> item = new HashMap<>();
        item.put("partnerCode", number);
        item.put("saleCode", number);
        item.put("quantity", number);
        item.put("unitPrice", number);
        item.put("interest", number);
        item.put("discount", number);
        item.put("total", number);
        return item;
    }


}
