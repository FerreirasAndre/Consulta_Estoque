import java.io.*;
import java.util.ArrayList;
 class Loja {
    String lojaName = "";
    ArrayList<String> produtos = new ArrayList<>();
    ArrayList<Integer> quantidade = new ArrayList<>();
    int quantidadeProdutos;
    public Loja(String nomeLoja){
        int cont = 0;
        String linha = "";
        String url = "src/"+nomeLoja;

        try{
            FileReader  arquivo = new FileReader (url); //abre o arquivo para leitura
            BufferedReader br = new BufferedReader (arquivo); //cria um buffer para leitura do arquivo

            try {
                while (linha != null) { //enquanto não chegar no fim do arquivo
                    linha = br.readLine(); //lê a linha
                    if (linha != null && cont > 0) { //se a linha não for nula, adiciona na lista
                        String[] dados = linha.split(";");

                        this.produtos.add(dados[0]);
                        this.quantidade.add(Integer.parseInt(dados[1]));
                        cont++;
                    } else if (linha != null && cont == 0) {
                        this.lojaName = linha;
                        cont++;
                    }
                }

            } catch (IOException erro) { //trata o erro de leitura do arquivo
                System.out.println("Erro ao ler arquivo");
            }

        } catch (FileNotFoundException erro) {  //trata o erro de arquivo não encontrado
            System.out.println("Arquivo não encontrado");
        }
    }

    public int pesquisaProdutos(String produtoPesquisado){
        this.quantidadeProdutos = 0;
        //System.out.println("nome da loja: " + lojaName);
        //System.out.println("Produto pesquisado: " + produtoPesquisado);

        for (int i = 0; i < this.produtos.size(); i++) {
            //System.out.println("Produto da lista: " + this.produtos.get(i) + " Quantidade: " + this.quantidade.get(i));

            String produtoParcial[] = this.produtos.get(i).split(" ");//separa o nome do produto em um array
            for (String s : produtoParcial) {
                if (produtoPesquisado.equals(s.toLowerCase())) {
                    this.quantidadeProdutos = this.quantidadeProdutos + this.quantidade.get(i);
                }
            }
        }
        return this.quantidadeProdutos;
    }
}
