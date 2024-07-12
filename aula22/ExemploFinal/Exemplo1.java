package aula22.ExemploFinal;

public class Exemplo1 {
    //Declarando uma variável do tipo final
    final double numero;

    //Criando uma constante, ela DEVE receber um valor no momento da declaração, toda em leta maiúscula
    //Acesso universal pelo -> public
    //Existe independente da criação da instância pelo -> static
    //Não pode ser modificada pelo -> final
    public static final double PI = 3.141592653589793;

    //Como não foi definido um valor no momento da declaração, este valor deverá ser atribuído até o final do construtor.
    public Exemplo1(){
        numero = 10;
    }


}
