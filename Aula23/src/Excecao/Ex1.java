package Excecao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex1 {

    public static int leNumero(String mensagem){
        Scanner ler = new Scanner(System.in);
        int num = 0;
        boolean correto;
        do{
            try{
                System.out.print(mensagem);
                num = ler.nextInt();
               correto = true;
            }
            catch (InputMismatchException erro) {
             correto = false;
             ler.next();
             System.out.println("Valor inválido!");
            }
        }
        while (!correto);

        return num;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int n1 = leNumero("Digite um valor para n1: ");
        int n2 = leNumero("Digite um valor para n2: ");

        try {
            int resposta = n1 / n2;
            System.out.println(resposta);
        }
        catch (InputMismatchException erro){
            System.out.println("Os valores precisam ser números.");
        }
        catch (ArithmeticException erro){
            System.out.println("Não é possível dividir por zero.");
        }
    }
}
