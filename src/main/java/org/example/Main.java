package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Estoque();
        int opcao;
        String nome;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("O que gostaria de fazer?");
            System.out.println("1 - Consultar estoque.");
            System.out.println("2 - Cadastrar produto.");
            System.out.println("3 - Editar produto.");
            System.out.println("4 - Sair.");
            opcao = scanner.nextInt();
            if(opcao == 1) {
                System.out.println("1 - Consultar produto por nome.");
                System.out.println("2 - Consultar todos os produtos.");
                opcao = scanner.nextInt();
                if(opcao == 1) {
                    System.out.println("Digite o nome do produto a ser pesquisado.");
                    nome = scanner.next();
                    Estoque.consultarEstoque(nome);
                } else {
                    Estoque.consultarEstoque();
                }
            } else if (opcao == 2) {
                Estoque.cadastrarProduto();
            } else if (opcao == 3) {
                System.out.println("Digite o nome do produto a ser alterado: ");
                nome = scanner.next();
                Estoque.editarEstoque(nome);
            }
            System.out.println("\n");
        } while (opcao != 4);
        scanner.close();
    }
}