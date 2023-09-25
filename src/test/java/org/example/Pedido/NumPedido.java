package org.example.Pedido;

public class NumPedido {
    private String NomParceiro;
    public String Pedido;
    public Integer Loja;

    public String getNomParceiro() {
        return NomParceiro;
    }
    public void setNomParceiro(String nomParceiro) {
        NomParceiro = nomParceiro;
    }

    public String getPedido() {
        return Pedido;
    }

    public void setPedido(String pedido) {
        Pedido = pedido;
    }

    public Integer getLoja() {
        return Loja;
    }

    public void setLoja(Integer loja) {
        Loja = loja;
    }


    public NumPedido(String nomParceiro, Integer loja) {
        NomParceiro = nomParceiro;
        Loja = loja;
        numeroPedidoParceiro( loja , NomParceiro);

    }

    public String numeroPedidoParceiro (int loja, String NomParceiro){
        if (NomParceiro == "bees") {
               Pedido = NomParceiro+"1234";
        } else if (NomParceiro == "magalu") {
                Pedido = NomParceiro+"1234";
        } else if (NomParceiro == "Ifood-shop") {
                Pedido = NomParceiro+"1234";
        } else if (NomParceiro == "Shoppe") {
                Pedido = NomParceiro+"1234";
        }
        return Pedido;
    }


}
