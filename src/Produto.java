
public class Produto extends Loja{
    String produto;
    int quantidade;


    public Produto(String nomeLoja) {
        super(nomeLoja);
    }
    public int totalProdutos(int quantidadeProdutos){
        this.quantidade = quantidadeProdutos+this.quantidade;
        return this.quantidade;
    }

    public String produtos(String produtos){
        this.produto = produtos;
        return this.produto;
    }
}
