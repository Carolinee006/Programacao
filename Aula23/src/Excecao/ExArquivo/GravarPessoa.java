package Excecao.ExArquivo;

import java.io.*;

public class GravarPessoa {
    public static void main(String[] args) {
        File caminho = new File("C:\\Users\\Cimol\\Documents\\aula23");
        if(!caminho.exists()){
            System.out.print("Caminho não existe, tentando criar...");
            caminho.mkdir();
            System.out.println(" [ok]");
        }
        File arquivo = new File(caminho, "pessoas.db");
        try {
            ObjectOutputStream objEscrita =
                    new ObjectOutputStream(new FileOutputStream(arquivo.getAbsolutePath()));
            //Criando uma instância de pessoa para escrever dentro do arquivo
            Pessoa p1 = new Pessoa();
            p1.setNome("Jonas");
            p1.setSobrenome("Silva");
            //Escrevendo p1 dentro do arquivo
            objEscrita.writeObject(p1);
            objEscrita.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrato ou não pode ser criado!");
        }
        catch (IOException e){
            System.out.println("Erro ao ler o arquivo.");
        }
    }
}
