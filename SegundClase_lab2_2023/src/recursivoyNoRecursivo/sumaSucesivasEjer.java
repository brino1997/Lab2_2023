package recursivoyNoRecursivo;

public class sumaSucesivasEjer {
    //metodo recursivo
    public static int sumaSucesiva(int numero, int repeticiones) {
        if (repeticiones == 0) {
            return 0; // Caso base: suma de cero elementos es cero
        } else {
            return numero + sumaSucesiva(numero, repeticiones - 1); //caso recursivo, autollamado a la funcion
        }
    }
    //metodo no recursivo
    public static int sumaSucesiva(int numero, int repeticiones, int result) {
        while(repeticiones>0) {//repito la cantidad de veces de la variable
            result = result + numero;// realizo la suma y almaceno en una variable
            repeticiones--;
        }
        return result;
    }

    public static void main(String[] args) {
        //declaracion de variables y valores
        int numero = 5;
        int repeticiones = 3;
        int cont = 0;
        //llamada de metodo y muestra por pantalla
        int resultado = sumaSucesiva(numero, repeticiones);
        System.out.println("Resultado con recursion: " + resultado);
        int resultado2 = sumaSucesiva(numero, repeticiones, cont);
        System.out.println("Resultado sin recursion : " + resultado2);
    }
}
