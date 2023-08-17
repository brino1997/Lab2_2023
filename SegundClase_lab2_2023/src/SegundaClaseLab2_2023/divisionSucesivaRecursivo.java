package SegundaClaseLab2_2023;

public class divisionSucesivaRecursivo {
    public static void main(String[] args) {
        int dividendo = 25;
        int divisor = 4;

        int cociente = divisionSucesiva(dividendo, divisor);
        System.out.println("Cociente: " + cociente);
    }

    public static int divisionSucesiva(int dividendo, int divisor) {
        if (dividendo < divisor) {
            return 0; // Caso base: el dividendo es menor que el divisor
        } else {
            return 1 + divisionSucesiva(dividendo - divisor, divisor);
        }
    }
}