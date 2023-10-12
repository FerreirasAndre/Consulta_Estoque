public class Produto extends Loja{
    String produto;
    int quantidade;


    public Produto(String produto) {
        super(produto);
    }
    public int totalProdutos(int quantidadeProdutos){
        this.quantidade = quantidadeProdutos+this.quantidade;
        return this.quantidade;
    }
}
