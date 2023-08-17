package SegundaClaseLab2_2023;

public class SumaSucesivaRecursiva {
    public static void main(String[] args) {
        int numero = 5;
        int repeticiones = 3;

        int resultado = sumaSucesiva(numero, repeticiones);
        System.out.println("Resultado: " + resultado);
    }

    public static int sumaSucesiva(int numero, int repeticiones) {
        if (repeticiones == 0) {
            return 0; // Caso base: suma de cero elementos es cero
        } else {
            return numero + sumaSucesiva(numero, repeticiones - 1);
        }
    }





}