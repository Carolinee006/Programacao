package exemploAcesso2;
import exemploAcesso.Pessoa;
public class Principal {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();


        //O nome esta sem modificador na classe Pessoa, desta forma a classe Principal não tem acesso a ele;
        //p1.nome = "Jonas";

    }
}
