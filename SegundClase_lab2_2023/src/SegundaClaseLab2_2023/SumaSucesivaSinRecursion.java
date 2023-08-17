package SegundaClaseLab2_2023;

public class SumaSucesivaSinRecursion {
    public static void main(String[] args) {
        int numero = 5;
        int repeticiones = 2;

        int resultado = sumaSucesivas(numero, repeticiones);
        System.out.println("Resultado: " + resultado);
    }
    public static int sumaSucesivas(int numero, int repeticiones) {
        int result = 0;
        while(repeticiones>0) {
            result = result + numero;
            repeticiones--;
        }
        return result;
    }
}
