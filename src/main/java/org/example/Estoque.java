package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {
    private static List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return (List<Produto>) produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }


    static void consultarEstoque(String nome) {
        System.out.println("Nome pesquisado: " + nome);
        for (Produto produto : produtos) {
            if (nome.equalsIgnoreCase(produto.getNome())) {
                System.out.println("Produto: " + produto.getNome() + "\t" + "Preço: " + produto.getPreco() + "\t" + "Quantidade: " + "\t" + produto.getQuantidade());
            }
        }
    }

    public static void cadastrarProduto() {
        Scanner scanner = new Scanner(System.in);
        String nome;
        double preco;
        int quantidade;
        String perecivel;
        String dataValidade;
        Produto novoProduto;
        System.out.println("O produto é perecível? (s/n");
        perecivel = scanner.next();
        if (perecivel.equalsIgnoreCase("s")) {
            novoProduto = new ProdutoPerecivel();
            System.out.println("Qual a data de validade? ");
            dataValidade = scanner.next();
            ((ProdutoPerecivel) novoProduto).setDataValidade(dataValidade);
        } else {
            novoProduto = new ProdutoNaoPerecivel();
        }
        System.out.println("Digite o nome do produto:");
        nome = scanner.next();
        novoProduto.setNome(nome);
        System.out.println("Digite o preco do produto:");
        preco = scanner.nextDouble();
        novoProduto.setPreco(preco);
        System.out.println("Digite a quantidade do produto: ");
        quantidade = scanner.nextInt();
        novoProduto.setQuantidade(quantidade);
        produtos.add(novoProduto);
    }

    static void consultarEstoque() {
        for (Produto produto : produtos) {
            System.out.println("Produto: " + produto.getNome() + "\t" + "Preço: " + produto.getPreco() + "\t" + "Quantidade: " + "\t" + produto.getQuantidade());
            if (produto.getClass() == ProdutoPerecivel.class) {
                System.out.println("Data de validade: " + ((ProdutoPerecivel) produto).getDataValidade());
            }
        }
    }

    static void editarEstoque(String nome) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
            for (Produto produto : produtos) {
                if (nome.equalsIgnoreCase(produto.getNome())) {
                    System.out.println("O que deseja alterar?");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Preço");
                    System.out.println("3 - Quantidade");
                    if (produto.getClass() == ProdutoPerecivel.class) {
                        System.out.println("4 - Data de validade");
                    }
                    opcao = scanner.nextInt();
                    if(opcao == 1) {
                        System.out.println("Qual o novo nome? ");
                        produto.setNome(scanner.next());
                        System.out.println("Nome atualizado com sucesso");
                    } else if(opcao == 2) {
                        System.out.println("Qual o novo preço? ");
                        produto.setPreco(scanner.nextDouble());
                        System.out.println("Preço atualizado com sucesso");
                    } else if(opcao == 3) {
                        System.out.println("Qual a nova quantidade? ");
                        produto.setQuantidade(scanner.nextInt());
                    } else {
                        System.out.println("Qual a data de validade? ");
                        ((ProdutoPerecivel) produto).setDataValidade(scanner.next());
                    }

                }
            }
    }
}
