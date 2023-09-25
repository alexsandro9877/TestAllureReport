package org.example.Pedido;

public class CriarPedidoParceiro {

 public String storeTypeUrl;
 public Integer erpCode ;

    private Integer  subTotal;
    private Integer   discount;
    private Integer  interest;
    private Integer  freightPrice;
    private Integer  freightPricePromotion;
    private Integer   total;


    public CriarPedidoParceiro(String storeTypeUrl, Integer erpCode) {
        this.storeTypeUrl = storeTypeUrl;
        this.erpCode = erpCode;


    }

    public String StringPedido (){
            String pedido;

            pedido = delivery() + customer()+ items();
        return pedido ;
    }

    private String delivery (){

         return "delivery{" +
                "barrelRegionId=2489" +
                ", deliveryDate='2023-09-15'" +
                ", needValidation=false" +
                '}';
    }


    private String items(){
        String Item = "asdsa";

        Item =  "items"+":["
       + "{" +
            "partnerCode:'',"+
                "'saleCode:1090606,"+
                "quantity:2,"+
                "unitPrice:42.99,"+
                "interest:0,"+
                "discount:0.00,"+
                "total:85.98"+
        "}],";

        return Item;
    }

    private String customer(){
        String payload = "";

        payload =
                "customer:{"+
            "name:'JANAINA MERCEARIA',"+
                    "document:'18750082000157',"+
                    "email:'18750082000157_bees@parceirogpa.com',"+
                    "phone:11999999999,"+
                    "address:{"+
                "name:'Comercial',"+
                        "zipCode:'06010000',"+
                        "state:'SP',"+
                        "neighborhood:'R. Dona Primitiva Vianco',"+
                        "city:'Osasco',"+
                        "street:'R. Dona Primitiva Vianco',"+
                        "locationNumber:'18750082000157',"+
                        "type:'BUSINESS_ADDRESS'"+
            "},"+
            "creditLimit:8166"+
        "},";

        return payload;
    }


}
