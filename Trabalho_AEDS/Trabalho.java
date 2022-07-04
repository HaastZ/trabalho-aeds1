/*
Este programa tem o objetivo de realizar vendas de máscaras, contendo um menu para o usuário escolher oque ele deseja visualizar

Data de escrita: dia 24/06

Ultima atualização: 01/07

Feito por: Vinicius Almeida, Matheus Melgaço e Lucas Quintas
 */


import java.util.Scanner;
import java.io.*;

public class Trabalho
{


    //*//
    public static void main(String[] args) throws IOException //método main
    {
        double[][] estoque = lerArquivo("C:\\arquivo\\trabalho.txt", 4);
        double[][] vendas = lerArquivo("C:\\arquivo\\vendas.txt", 100);
        //lendo o arquivo2 e definindo o tamanho de linhas (colocamos 100 por não saber o numero de vendas de cada produto)

        menuInformacoes(estoque, vendas);
        estoque [0][4]=0;
        estoque [1][4]=0;
        estoque [2][4]=0;
        estoque [3][4]=0;
    }


    //*//
    public static void menuInformacoes(double[][] matriz,double[][] vendas) throws IOException
    //método para exibir um menu que mostra as informações
    {
        //passando como parâmetro a matriz
        Scanner entrada = new Scanner(System.in);
        int produto;
        //menu para pedir ao usuário qual informação ele deseja acessar dos produtos

        do {
            System.out.println("Programa Máscaras");
            System.out.println (" ");
            System.out.println("Escolha a opção que você quer:");
            System.out.println(" ");
            System.out.println(" 1.Venda De Produtos\n 2.Relatório Do Estoque das Máscaras\n 3.Relatório de Vendas no dia e lucro obtido\n 4.Fechar o Programa");
            produto = entrada.nextInt();

            switch (produto)
            {

                //caso produto for igual a 1. Será aberto outro menu perguntando ao usúario qual produto ele deseja comprar
                case 1:
                    System.out.println(" ");
                    System.out.println("Informe qual produto você deseja comprar:\n \n 1.Máscara Infantil\n 2.Máscara De Adulto\n 3.Máscara Lisa\n 4.Máscara Estampada");
                    int venda = entrada.nextInt();
                    int quantidade;

                    switch (venda)

                    //o segundo switch case só está pegando oque está na coluna 0 da matriz, ou seja a quantidade em estoque
                    {
                        case 1:
                            System.out.println(" ");
                            System.out.println("Quantas Máscaras você quer comprar?");
                            quantidade = entrada.nextInt();
                            System.out.println(" ");

                            if (matriz[0][0] - quantidade > 0)
                            {
                                matriz[0][0] -= quantidade;
                                //o elemento que está na posição 0,0 da matriz menos a quantidade que o usuario digitou
                                //no caso a quantidade em estoque de máscara infantil

                                matriz [0][4]+= quantidade;
                                System.out.println(" ");
                                System.out.println("Venda de máscaras comcluida com sucesso.");
                                System.out.println(" ");
                            }
                            else
                            {
                                System.out.println(" ");
                                System.out.println("Valor Inválido.");
                                System.out.println(" ");
                            }
                            break;

                        case 2:
                            System.out.println(" ");
                            System.out.println("Quantas Máscaras você quer comprar?");
                            quantidade = entrada.nextInt();

                            if (matriz[1][0] - quantidade > 0)
                            {
                                matriz[1][0] -= quantidade;
                                //o elemento que está na posição 1,0 da matriz menos a quantidade que o usuario digitou
                                //na linha abaixo a 0, está pegando a quantidade em estoque de máscaras de adulto

                                matriz [1][4]+=quantidade;
                                System.out.println(" ");
                                System.out.println("Venda de máscaras comcluida com sucesso.");
                                System.out.println(" ");
                            }
                            else
                            {
                                System.out.println(" ");
                                System.out.println("Valor Inváldo..");
                                System.out.println(" ");
                            }
                            break;

                        case 3:
                            System.out.println(" ");
                            System.out.println("Quantas Máscaras você quer comprar?");
                            quantidade = entrada.nextInt();
                            if (matriz[2][0] - quantidade > 0)
                            {
                                matriz[2][0] -= quantidade;
                                //o elemento que está na posição 2,0 da matriz menos a quantidade que o usuario digitou
                                //na linha abaixo da 1, está pegando a quantidade em estoque de máscaras lisas
                                matriz [2][4]+=quantidade;
                                System.out.println(" ");
                                System.out.println("Venda de máscaras comcluida com sucesso.");
                            }
                            else
                            {
                                System.out.println(" ");
                                System.out.println("Valor Inváldo.");
                            }
                            break;

                        case 4:
                            System.out.println(" ");
                            System.out.println("Quantas Máscaras você quer comprar?");
                            quantidade = entrada.nextInt();
                            if (matriz[3][0] - quantidade > 0)
                            {
                                matriz[3][0] -= quantidade;
                                //o elemento que está na posição 3,0 da matriz menos a quantidade que o usuario digitou
                                //na linha abaixo da 2, está pegando a quantidade em estoque de máscaras estampadas
                                matriz [3][4]+= quantidade;
                                System.out.println(" ");
                                System.out.println("Venda de máscaras comcluida com sucesso");
                                System.out.println(" ");
                            }
                            else
                            {
                                System.out.println(" ");
                                System.out.println("Valor Inválido");
                                System.out.println(" ");
                            }
                            break;

                        default:
                            System.out.println(" ");
                            System.out.println("Opção Invãlida");
                            System.out.println(" ");
                            break;
                    }
                    break;

                case 2:
                    int a = 0;
                    //contador para pegar as linhas do arquivo 1

                    while (a < 4)
                    {
                        String nomeProduto;
                        //a string nomeProduto recebe os nomes dos produtos

                        switch ((int) matriz[a][2])
                        {

                            //caso matriz na coluna 2 seja um numero de 1 a 4, vai mostrar os nomes
                            //convertendo de double para inteiro
                            case 1:
                                nomeProduto = "Máscara Infantil";
                                break;
                            case 2:
                                nomeProduto = "Máscara Adulto";
                                break;
                            case 3:
                                nomeProduto = "Máscara Lisa";
                                break;
                            case 4:
                                nomeProduto = "Máscara Estampada";
                                break;
                            default:
                                nomeProduto = "Erro";
                                break;
                        }
                        //para imprimir as máscaras em estoque(dentro do arquivo trabalho)

                        System.out.println(" ");
                        System.out.println(" São " + Integer.valueOf((int) matriz[a][0]) + " " + nomeProduto + " em estoque");
                        //convertendo double para inteiro
                        a++;//pulando +1 nas linhas do arquivo
                        System.out.println(" ");
                    }

                    break;
                case 3:
                    int cont = 0;
                    //contador para pegar as linhas do arquivo 2

                    while (vendas[cont][1] != 0)
                    {
                        String nome;
                        //a string nome recebe os nomes dos produtos

                        switch ((int) vendas[cont][0])
                        {

                            //caso vendas na coluna 0 seja um numero de 1 a 4, vai mostrar os nomes
                            //convertendo de double para inteiro
                            case 1:
                                nome = "Máscara Infantil";
                                break;
                            case 2:
                                nome = "Máscara Adulto";
                                break;
                            case 3:
                                nome = "Máscara Lisa";
                                break;
                            case 4:
                                nome = "Máscara Estampada";
                                break;
                            default:
                                nome = "Erro";
                                break;
                        }

                        //para imprimir o valor da venda e o lucro obtido(que está dentro do arquivo vendas)

                        System.out.println(" ");
                        System.out.println(nome + ": Quantidade vendida " + matriz[cont][4] + " Lucro Obtido R$" + (vendas [cont][2] -vendas[cont][1])*matriz[cont][4]);
                        cont++;
                        //pulando +1 nas linhas do arquivo
                        System.out.println(" ");
                    }
                    break;

                case 4:
                    System.out.println(" ");
                    System.out.println("Obrigado por usar este programa <3");
                    break;

                default:
                    System.out.println(" ");
                    System.out.println("Erro");
                    break;
            }
        }

        while (produto != 4);
        gravarArquivo(matriz);
    }

    public static double[][] lerArquivo(String caminhoArquivo, int tamanhoLinhas) throws FileNotFoundException
    {
        //função para ler os dois arquivos
        //tamanhoLinhas porque não se sabe a quantidade de vendas

        double[][] vendas = new double[tamanhoLinhas][5];
        File arquivo = new File(caminhoArquivo);
        int cont = 0;
        //contador para contar as linhas

        Scanner ler = new Scanner(arquivo);
        while (ler.hasNextLine())
        {
            String[] verArquivo = ler.nextLine().split(";");
            //está separando em ; oque está no arquivo 2 e armazenando no vetor verArquivo

            for (int i = 0; i < 3; i++)
            {
                vendas[cont][i] = Double.parseDouble(verArquivo[i]);
                //convertendo a string para double

            }
            cont++;
            //contador para pular mais 1 linha no arquivo toda vez que o while rodar

        }
        return vendas;
        //retorna a matriz preenchida

    }

    public static void gravarArquivo(double[][] estoque) throws IOException
    {
        File arquivo = new File("C:\\arquivo\\trabalho.txt");
        FileWriter escrever = new FileWriter(arquivo);

        for(int ln = 0; ln < 4 ;ln++)
        {
            for(int col = 0;col <3;col++)
            {
                escrever.write(estoque[ln][col] + ";" );
            }
            escrever.write("\n" );
        }
        escrever.close();
    }

}