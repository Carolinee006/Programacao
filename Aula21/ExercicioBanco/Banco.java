package ExercicioBanco;

import java.util.Scanner;

public class Banco {
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
            System.out.println("Selecione uma opção: ");
            System.out.println("d - realizar um depósito");
            System.out.println("s - realizar um saque");
            System.out.println("v - verificar saldo");
            System.out.println("a - alterar senha");
            System.out.println("e - sair");
            opc = leString("").toLowerCase();
            switch (opc){
                case "d" ->{
                    float valor = leFloat("Qual valor deseja depositar? ");
                    c1.depositar(valor);
                    System.out.println("Depósito reaalizado! ");
                }
                case "s" ->{
                    float valor = leFloat("Qual o valor do saque? ");
                    if(c1.sacar(valor))
                        System.out.println("Saque realizado! ");
                    else
                        System.out.println("Saldo mais limite insuficientes. ");
                }
                case "v" -> System.out.println(c1.verificaSaldo());
                case "a" -> {
                    String senha = leString("Qual a nova senha? ");
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
            System.out.println("Selecione uma opção: ");
            System.out.println("d - realizar um depósito");
            System.out.println("s - realizar um saque");
            System.out.println("v - verificar saldo");
            System.out.println("a - alterar senha");
            System.out.println("e - sair");
            opc = leString("").toLowerCase();
            switch (opc){
                case "d" ->{
                    float valor = leFloat("Qual valor deseja depositar? ");
                    c1.depositar(valor);
                    System.out.println("Depósito reaalizado! ");
                }
                case "s" ->{
                    float valor = leFloat("Qual o valor do saque? ");
                    if(c1.sacar(valor))
                        System.out.println("Saque realizado! ");
                    else
                        System.out.println("Saldo insuficiente.");
                }
                case "v" -> System.out.println(c1.verificaSaldo());
                case "a" -> {
                    String senha = leString("Qual a nova senha? ");
                    c1.setSenha(senha);
                }
            }
        }
        while(!opc.equals("e"));
        return c1;
    }

    public static ContaCorrente cadastraCC(){
        String titular = leString("Qual o titular? ");
        String senha = leString("Qual a senha? ");
        float limite = leFloat("Qual o limite inicial? ");
        ContaCorrente c1 = new ContaCorrente(titular,senha,limite);
        System.out.println("Conta cadastrada com o identificador "+c1.getIdentificador());
        return c1;
    }

    public static  ContaPoupanca cadastraCP(){
        String titular = leString("Qual o titular? ");
        String senha = leString("");
        float deposito = leFloat("Qual valor depositar? ");
        ContaPoupanca c1 = new ContaPoupanca(titular,senha,deposito);
        System.out.println("Conta cadastrada com o identificador "+c1.getIdentificador());
        return c1;
    }

    public static void main(String[] args) {
        ContaCorrente[] listaCC = new ContaCorrente[20];
        ContaPoupanca[] listaCP = new ContaPoupanca[20];
        int contCC = 0;
        int contCP = 0;
        String opc;
        do{
            System.out.println("Selecione uma opção: ");
            System.out.println("cc - cadastrar conta corrente");
            System.out.println("cp - cadastrar conta poupança");
            System.out.println("ac - acessar conta corrente");
            System.out.println("ap - acessar conta poupança");
            System.out.println("e - sair");
            opc = leString("");
            switch (opc){
                case "cc" ->{
                    listaCC[contCC] = cadastraCC();
                    contCC++;
                }
                case "cp" ->{
                    listaCP[contCP] = cadastraCP();
                    contCP++;
                }
                case "ac" ->{
                    String identificador = leString("Qual o identificador?");
                    String senha = leString("Qual a senha?");
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


                case "ap" ->{
                    String identificador = leString("Qual o identificador?");
                    String senha = leString("Qual a senha?");
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
        while (!opc.equals("e"));
    }
}
