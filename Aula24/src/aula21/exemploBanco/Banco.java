package aula21.exemploBanco;

import exemploPessoaLista.Pessoa;

import java.io.*;
import java.util.Scanner;

public class Banco {

    static File caminho = new File("C:\\Users\\Cimol\\Documents");
    static File arquivo = new File(caminho,"contas.db");

    public static ContaCorrente[] leArquivoCC(){
        ContaCorrente[] lista = new ContaCorrente[10];
        try {
            ObjectInputStream leitura = new ObjectInputStream(new FileInputStream(arquivo.getAbsolutePath()));
            lista = (ContaCorrente[]) leitura.readObject();
            leitura.close();
        }
        catch (IOException e){
            System.out.println("Erro ao ler arquivo");
        }
        catch (ClassNotFoundException e){
            System.out.println("Classe não encontrada.");
        }
        return lista;
    }

    public static void gravaArquivoCC(ContaCorrente[] lista){
        try{
            ObjectOutputStream escrita = new ObjectOutputStream(new FileOutputStream(arquivo.getAbsolutePath()));
            escrita.writeObject(lista);
            escrita.close();
        }
        catch (IOException e){
            System.out.println("Erro ao gravar o arquivo");
        }
    }

    public static ContaPoupanca[] leArquivoCP(){
        ContaPoupanca[] lista = new ContaPoupanca[10];
        try {
            ObjectInputStream leitura = new ObjectInputStream(new FileInputStream(arquivo.getAbsolutePath()));
            lista = (ContaPoupanca[]) leitura.readObject();
            leitura.close();
        }
        catch (IOException e){
            System.out.println("Erro ao ler arquivo");
        }
        catch (ClassNotFoundException e){
            System.out.println("Classe não encontrada.");
        }
        return lista;
    }

    public static void gravaArquivoCP(ContaPoupanca[] lista){
        try{
            ObjectOutputStream escrita = new ObjectOutputStream(new FileOutputStream(arquivo.getAbsolutePath()));
            escrita.writeObject(lista);
            escrita.close();
        }
        catch (IOException e){
            System.out.println("Erro ao gravar o arquivo");
        }
    }

    public static String leString(String mensagem){
        Scanner ler = new Scanner(System.in);
        System.out.print(mensagem+": ");
        return ler.nextLine();
    }

    public static float leFloat(String mensagem){
        Scanner ler = new Scanner(System.in);
        System.out.print(mensagem+": ");
        return ler.nextFloat();
    }

    public static ContaCorrente acessaCC(ContaCorrente c1){
        String opc;
        System.out.println("Acessando a conta "+c1.getIdentificador());
        System.out.println("Bem vindo, "+c1.getTitular());
        do{
            System.out.println("Selecione uma opção");
            System.out.println("d - realizar um depósito");
            System.out.println("s - realizar um saque");
            System.out.println("v - verificar o saldo");
            System.out.println("a - alterar a senha");
            System.out.println("e - sair");
            opc = leString("").toLowerCase();
            switch (opc){
                case "d"->{
                    float valor = leFloat("Qual valor deseja depositar");
                    c1.depositar(valor);
                    System.out.println("Depósito realizado!");
                }
                case "s"->{
                    float valor = leFloat("Qual o valor do saque");
                    if(c1.sacar(valor))
                        System.out.println("Saque realizado");
                    else
                        System.out.println("Saldo mais limite insuficientes");
                }
                case "v"->System.out.println(c1.verificaSaldo());
                case "a"->{
                    String senha = leString("Qual a nova senha");
                    c1.setSenha(senha);
                }
            }
        }
        while(!opc.equals("e"));
        return c1;
    }

    public static ContaPoupanca acessaCP(ContaPoupanca c1){
        String opc;
        System.out.println("Acessando a conta "+c1.getIdentificador());
        System.out.println("Bem vindo, "+c1.getTitular());
        do{
            System.out.println("Selecione uma opção");
            System.out.println("d - realizar um depósito");
            System.out.println("s - realizar um saque");
            System.out.println("v - verificar o saldo");
            System.out.println("a - alterar a senha");
            System.out.println("e - sair");
            opc = leString("").toLowerCase();
            switch (opc){
                case "d"->{
                    float valor = leFloat("Qual valor deseja depositar");
                    c1.depositar(valor);
                    System.out.println("Depósito realizado!");
                }
                case "s"->{
                    float valor = leFloat("Qual o valor do saque");
                    if(c1.sacar(valor))
                        System.out.println("Saque realizado");
                    else
                        System.out.println("Saldo insuficiente");
                }
                case "v"->System.out.println(c1.verificaSaldo());
                case "a"->{
                    String senha = leString("Qual a nova senha");
                    c1.setSenha(senha);
                }
            }
        }
        while(!opc.equals("e"));
        return c1;
    }

    public static ContaCorrente cadastraCC(){
        String titular = leString("Qual o titular da conta");
        String senha = leString("Qual a senha");
        float limite = leFloat("Qual o limite inicial");
        ContaCorrente c1 = new ContaCorrente(titular,senha,limite);
        System.out.println("Conta cadastrada com o identificador "+c1.getIdentificador());
        return c1;
    }

    public static ContaPoupanca cadastraCP(){
        String titular = leString("Qual o titular da conta");
        String senha = leString("Qual a senha");
        float deposito = leFloat("Qual valor depositar");
        ContaPoupanca c1 = new ContaPoupanca(titular,senha,deposito);
        System.out.println("Conta cadastrada com o identificador "+c1.getIdentificador());
        return c1;
    }




    public static void main(String[] args) {
        ContaCorrente[] listaCC = new ContaCorrente[20];
        ContaPoupanca[] listaCP = new ContaPoupanca[20];

        ContaPoupanca[] lista = leArquivoCP();
        int contCP = 0;
        ContaPoupanca CP;
        do{
            CP = listaCP[contCP];
            if(CP!=null){
                contCP++;
            }
        }
        while (CP!=null);

        ContaCorrente[] listaCC = leArquivoCC();
        int contCC = 0;
        ContaCorrente CC;
        do{
            CC = listaCC[contCC];
            if(CC!=null){
                contCC++;
            }
        }
        while (CC!=null);


        String opc;
        do{
            System.out.println("Selecione uma opção");
            System.out.println("cc - cadastrar conta corrente");
            System.out.println("cp - cadastrar conta poupança");
            System.out.println("ac - acessar conta corrente");
            System.out.println("ap - acessar conta poupança");
            System.out.println("l = listar");
            System.out.println("e - sair");
            opc = leString("");
            switch (opc){
                case "l"->{
                    for(int i=0;i<cont;i++){
                        System.out.println(lista[i]);
                    }
                }
                case "cc"->{
                    listaCC[contCC] = cadastraCC();
                    contCC++;
                }
                case "cp"->{
                    listaCP[contCP] = cadastraCP();
                    contCP++;
                }
                case "ac"->{
                    String identificador = leString("Qual o identificador");
                    String senha = leString("Qual a senha");
                    int posicao = -1;
                    for(int i=0;i<contCC;i++){
                        if(listaCC[i].validaAcesso(identificador,senha))
                            posicao = i;
                    }
                    if(posicao>=0){
                        listaCC[posicao] = acessaCC(listaCC[posicao]);
                    }
                    else{
                        System.out.println("Conta inexistente ou senha incorreta!");
                    }
                }
                case "ap"->{
                    String identificador = leString("Qual o identificador");
                    String senha = leString("Qual a senha");
                    int posicao = -1;
                    for(int i=0;i<contCP;i++){
                        if(listaCP[i].validaAcesso(identificador,senha))
                            posicao = i;
                    }
                    if(posicao>=0){
                        listaCP[posicao] = acessaCP(listaCP[posicao]);
                    }
                    else{
                        System.out.println("Conta inexistente ou senha incorreta!");
                    }
                }
            }
        }
        while(!opc.equals("e"));
    }
}