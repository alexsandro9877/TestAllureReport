package org.example.utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class MontaPedido {

    public static String parceiro;

    public static String loja;
    public static String deliveryDate;
    public static Integer barrelRegionId;
    public static Boolean needValidation;
    public static String code;
    public static String dueDate;
    public static Double paymentsTotal;
    public static String partnerCode;
    public static String saleCode;
    public static Integer quantity;
    public static Integer interest;
    public static Double unitPrice;
    public static Double discount;
    public static Double totalItem;






    public  static Map<String, Object> Pedido(String parceiro, String loja) {

        Map<String, Object> principal = new HashMap<>();
        List<Object> itesn = new ArrayList<>();
        itesn.add(Item());



        principal.put("storeTypeUrl",parceiro);
        principal.put("erpCode",loja);
        principal.put("subTotal",220.98);
        principal.put("discount",0.00);
        principal.put("interest",0);
        principal.put("freightPrice",0);
        principal.put( "freightPricePromotion",0);
        principal.put("total",220.98);

        principal.put("delivery", Delivery(parceiro) );
        principal.put("items",itesn);
        principal.put("customer",Customer(parceiro) );
        principal.put("payments",listpayments());
        principal.put("partnerOrderId",getPartnerOrderId(parceiro));
        principal.put("partnerDateTimeReadOrder",getDateTime());

        principal.put("partnerStatus","PENDING");
        principal.put("paymentMethod","BANK_SLIP");
        principal.put("beesAccountId","18750082000157");
        principal.put("paymentTerm",15);
        principal.put("channel","B2B_APP");
        principal.put("resale",true);


        return principal;
    }
    private static List<Object> listpayments (){
        Map<String, Object> payments = new HashMap<>();
        List<Object> Listpayments = new ArrayList<>();
        Listpayments.add(payments);

        payments.put( "code",code);
        payments.put( "dueDate",dueDate);
        payments.put( "total",totalItem);

        return  Listpayments;
    }
    private static Map<String, Object> Customer (String parceiro){
        Map<String, Object> custumer = new HashMap<>();
        Map<String, Object> address = new HashMap<>();

        custumer.put("name","JANAINA MERCEARIA");
        custumer.put("document","18750082000157");
        custumer.put("email","18750082000157_bees@parceirogpa.com");
        custumer.put("phone","11999999999");
        address.put("name","Comercial");
        address.put("zipCode","06010000");
        address.put("state","SP");
        address.put("neighborhood","R. Dona Primitiva Vianco");
        address.put("city","Osasco");
        address.put("street","R. Dona Primitiva Vianco");
        address.put("locationNumber","18750082000157");
        address.put("type","BUSINESS_ADDRESS");
        custumer.put("address",address);

        if (parceiro == "bees"){
            custumer.put("creditLimit" ,99999);

        }

        return  custumer;
    }

    private static Map<String, Object> Item (){
        Map<String, Object> iten = new HashMap<>();

        iten.put("partnerCode",partnerCode);
        iten.put("saleCode",saleCode);
        iten.put("quantity",quantity);
        iten.put("unitPrice",unitPrice);
        iten.put("interest",interest);
        iten.put("discount",discount);
        iten.put("total",totalItem);

        return  iten;
    }

    private static  String getPartnerOrderId(String parceiro){
        String PartnerOrderId ="" ;
        Date date = new Date();
        if ("bees" == parceiro) {
            DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
            PartnerOrderId = dateFormat.format(date);
            PartnerOrderId =  PartnerOrderId.substring(0, 10);
        } else if ("shoppe" == parceiro) {
            DateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
            PartnerOrderId = dateFormat.format(date);
        } else if ("magalu" == parceiro) {
            DateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
            PartnerOrderId = "LU-"+dateFormat.format(date)+"00";
        } else if ("ifood-shop" == parceiro) {
            DateFormat dateFormat = new SimpleDateFormat("HHmmss");
            PartnerOrderId = "0"+dateFormat.format(date);
        } else if ( "" == parceiro) {
            Random random = new Random();
            int numeroAleatorio = random.nextInt(999999) + 1;
            PartnerOrderId = ""+numeroAleatorio;
        }
        return PartnerOrderId;
    }
    public static Map<String, Object> montarObjeto(String[] chaves, Object[] valores) {
        if (chaves.length != valores.length) {
            throw new IllegalArgumentException("Os arrays de chaves e valores devem ter o mesmo tamanho.");
        }
        Map<String, Object> objeto = new HashMap<>();
        for (int i = 0; i < chaves.length; i++) {
            objeto.put(chaves[i], valores[i]);
        }
        return objeto;
    }
    private static Map<String, Object> Delivery (String parceiro){
        Map<String, Object> delivery = new HashMap<>();
        if (parceiro == "bees") {
            delivery.put("barrelRegionId", barrelRegionId);
            delivery.put("deliveryDate", deliveryDate);
            delivery.put("needValidation",needValidation);
        }

        return  delivery;
    }


    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH,mm,ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}