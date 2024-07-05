package exemploStatic;


public class Operacoes {
    static float soma(float n1, float n2){
        return n1+n2;
    }


    static float potencia(float base, float exp){
        float mult = 1;
        for(int i=0; i<exp; i++){
            mult*=base;
        }
        return mult;
    }
}

