package Excecao;

public class Teste {
    public static void main(String[] args) {
        Ex2 e1 = new Ex2();
        try{
            e1.divide(5,0);
        }
        catch(ArithmeticException e){
            System.out.println("Não foi possível dividir.");
        }
    }
}
