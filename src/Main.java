import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<Object> inventarioList = new ArrayList<>();
        boolean controle = false;
        String controll;
        String produtoPesquisado = "";
        int  somatorioProdutos = 0;
        
        System.out.println("*******************************Seja bem-vindo(a)!**************************");
        //System.out.println("\r\n");

        while (!controle) {
            System.out.println("Informe um arquivo de inventário, ou “fim” para encerrar:");
            Scanner entrada = new Scanner(System.in);
            controll = entrada.nextLine();

            if ((controll.equals("loja1.txt")) || (controll.equals("loja2.txt")) || (controll.equals("loja3.txt"))) {
                Produto inventario = new Produto(controll);
                inventarioList.add(inventario);

                if (inventarioList.size() == 3) {
                    while (!produtoPesquisado.equals("0")) {
                        System.out.println("Informe um produto, ou “0” para encerrar:");
                        Scanner produto = new Scanner(System.in);
                        produtoPesquisado = produto.nextLine().toLowerCase(); //transforma o texto em minúsculo
                        inventario.quantidade = 0;

                        for (Object o : inventarioList) {
                            ((Produto) o).pesquisaProdutos(produtoPesquisado);
                            System.out.println(((Produto) o).quantidadeProdutos + " unidades em " + ((Produto) o).lojaName);
                            somatorioProdutos = inventario.totalProdutos(((Produto) o).quantidadeProdutos);
                        }
                        System.out.println(somatorioProdutos + " unidades no total");
                    }
                }
            } else if (controll.equals("fim")) {
                controle = true;
            }
        }
    }
}
