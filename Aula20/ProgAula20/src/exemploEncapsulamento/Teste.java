package exemploEncapsulamento;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Qual o nome: ");
        String nome = ler.next();
        System.out.print("Qual o sobrenome: ");
        String sobrenome = ler.next();
        Pessoa pessoaUm = new Pessoa(nome,sobrenome);
        System.out.println("Nome: "+pessoaUm.getNome());
        System.out.println("Sobrenome: "+pessoaUm.getSobrenome());
    }
}
