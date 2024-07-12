package aula22.ExemploFinal;

public class Teste {
    public static void main(String[] args) {
        Exemplo1 ex = new Exemplo1();
        //Não é possível trocar o valor de um atributo final
       // ex.numero = 25;

        System.out.println(Exemplo1.PI);
    }
}
